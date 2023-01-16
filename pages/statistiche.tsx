import React, { useEffect, useState } from "react";
import BarChart from "../components/BarChart";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import { annualApi, monthlyApi } from "../api";
import { Footer } from "../components/Footer";
import Head from "next/head";

const statistiche = () => {
  const [side, setSide] = useState<boolean>(false);
  const [touristsNumber, setTouristsNumber] = useState<string[]>([]);
  const [years, setYears] = useState<string[]>([]);
  const [nazionality, setNazionality] = useState<string>("WORLD");
  const [province, setProvince] = useState<string>("ITG2");
  const [year, setYear] = useState<undefined | string>(undefined);
  const [firstSelectMonth, setFirstSelectMonth] = useState<undefined | string>(undefined);
  const [firstSelectYear, setFirstSelectYear] = useState<undefined | string>(undefined);
  const [secondSelectMonth, setSecondSelectMonth] = useState<undefined | string>(undefined);
  const [secondSelectYear, setSecondSelectYear] = useState<undefined | string>(undefined);
  const [yearStartRange, setYearStartRange] = useState<undefined | string>("2008");
  const [yearEndRange, setYearEndRange] = useState<undefined | string>("2021");

  useEffect(() => {
    annualApi(nazionality, province, "AR", yearStartRange, yearEndRange).then((res) => {
      setTouristsNumber(res.data);
      setYears(res.labels);
    });
  }, []);

  const handleSidebar = () => {
    setSide(!side);
  };

  const handleSaveFilters = (
    nazionality: string,
    province: string,
    year?: string,
    firstSelectMonth?: string,
    firstSelectYear?: string,
    secondSelectMonth?: string,
    secondSelectYear?: string,
    yearStartRange?: string,
    yearEndRange?: string
  ) => {
    setNazionality(nazionality);
    setProvince(province);
    setYear(year);
    setFirstSelectMonth(firstSelectMonth);
    setFirstSelectYear(firstSelectYear);
    setSecondSelectMonth(secondSelectMonth);
    setSecondSelectYear(secondSelectYear);
    setYearStartRange(yearStartRange);
    setYearEndRange(yearEndRange);

    if (year) {
      monthlyApi(nazionality, province, "AR", year + "-01-01", year + "-12-01").then((res) => {
        setTouristsNumber(res.data);
        setYears(res.labels);
      });
    }

    if (firstSelectMonth && firstSelectYear && secondSelectMonth && secondSelectYear) {
      let startDate = firstSelectYear + "-" + firstSelectMonth + "-01";
      let endDate = secondSelectYear + "-" + secondSelectMonth + "-01";

      if (new Date(startDate) > new Date(endDate)) {
        const temp = startDate;
        startDate = endDate;
        endDate = temp;
      }

      monthlyApi(nazionality, province, "AR", startDate, endDate).then((res) => {
        setTouristsNumber(res.data);
        setYears(res.labels);
      });
    }

    if (yearStartRange && yearEndRange) {
      if (new Date(yearStartRange) > new Date(yearEndRange)) {
        const temp = yearStartRange;
        yearStartRange = yearEndRange;
        yearEndRange = temp;
      }
      annualApi(nazionality, province, "AR", yearStartRange, yearEndRange).then((res) => {
        setTouristsNumber(res.data);
        setYears(res.labels);
      });
    }

    handleSidebar();
  };

  return (
    <>
      <Head>
        <link rel="icon" href="/assets/touristats-logo.jpg" />
        <title>Statistiche - TouriStats</title>
      </Head>
      <Navbar page="statistiche" />
      <div className="h-full">
        <Sidebar
          side={side}
          page="statistiche"
          handleSidebar={handleSidebar}
          handleSaveFilters={handleSaveFilters}
        />
        <h1 className="uppercase text-center pt-32">
          <span className="text-[#284697]">
            Stati
            <span className="half" title="S">
              s
            </span>
          </span>
          <span className="text-[#00ACC1]">tiche</span>
        </h1>
        <div className="text-center my-5">
          <button
            onClick={handleSidebar}
            className="uppercase my-10 bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded"
          >
            filtra
          </button>
        </div>

        <div className="text-center">
          {yearStartRange && yearEndRange && yearStartRange < yearEndRange ? (
            <div className="badge bg-[#284697] border-transparent">
              {yearStartRange} - {yearEndRange}
            </div>
          ) : yearStartRange && yearEndRange && yearStartRange === yearEndRange ? (
            <div className="badge bg-[#284697] border-transparent">
              {yearStartRange} - {yearEndRange}
            </div>
          ) : firstSelectMonth &&
            secondSelectMonth &&
            secondSelectYear &&
            firstSelectYear &&
            firstSelectYear < secondSelectYear ? (
            <div className="badge  bg-[#284697] border-transparent">
              {firstSelectMonth}/{firstSelectYear} - {secondSelectMonth}/{secondSelectYear}
            </div>
          ) : yearStartRange && yearEndRange && yearStartRange > yearEndRange ? (
            <div className="badge bg-[#284697] border-transparent">
              {yearEndRange} - {yearStartRange}
            </div>
          ) : firstSelectMonth &&
            secondSelectMonth &&
            secondSelectYear &&
            firstSelectYear &&
            firstSelectYear > secondSelectYear ? (
            <div className="badge bg-[#284697] border-transparent">
              {secondSelectMonth}/{secondSelectYear} - {firstSelectMonth}/{firstSelectYear}
            </div>
          ) : (
            firstSelectMonth &&
            secondSelectMonth &&
            secondSelectYear &&
            firstSelectYear &&
            firstSelectYear === secondSelectYear && (
              <div className="badge  bg-[#284697] border-transparent">
                {secondSelectMonth}/{firstSelectYear} - {firstSelectMonth}/{secondSelectYear}
              </div>
            )
          )}
        </div>
        <div className="chart">
          <BarChart
            data={{
              labels: years,
              datasets: [
                {
                  data: touristsNumber,
                  backgroundColor: "#284697",
                },
              ],
            }}
          />
        </div>
      </div>

      <Footer />
    </>
  );
};
export default statistiche;
