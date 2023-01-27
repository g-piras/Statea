import React, { useEffect, useState } from "react";
import BarChart from "../components/BarChart";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import { Footer } from "../components/Footer";
import Head from "next/head";
import { annualApiForecast, monthlyApiForecast } from "../api";

const previsioni = () => {
  const [side, setSide] = useState<boolean>(false);
  const [touristsNumber, setTouristsNumber] = useState<string[]>([]);
  const [years, setYears] = useState<string[]>([]);
  const [nationality, setNationality] = useState<string>("WORLD");
  const [province, setProvince] = useState<string>("ITG2");
  const [firstSelectMonth, setFirstSelectMonth] = useState<undefined | string>(undefined);
  const [firstSelectYear, setFirstSelectYear] = useState<undefined | string>(undefined);
  const [secondSelectMonth, setSecondSelectMonth] = useState<undefined | string>(undefined);
  const [secondSelectYear, setSecondSelectYear] = useState<undefined | string>(undefined);
  const [yearStartRange, setYearStartRange] = useState<undefined | string>("2023");
  const [yearEndRange, setYearEndRange] = useState<undefined | string>("2030");

  useEffect(() => {
    annualApiForecast(nationality, province, 'AR', yearStartRange).then((res) => {
      setTouristsNumber(res.data)
      setYears(res.labels)
    })
  }, [])

  const handleSidebar = () => {
    setSide(!side)
  };

  const handleSaveFilters = (
    nationality: string,
    province: string,
    firstSelectMonth?: string,
    firstSelectYear?: string,
    secondSelectMonth?: string,
    secondSelectYear?: string,
    yearStartRange?: string,
    yearEndRange?: string
  ) => {
    setNationality(nationality);
    setProvince(province);
    setFirstSelectMonth(firstSelectMonth);
    setFirstSelectYear(firstSelectYear);
    setSecondSelectMonth(secondSelectMonth);
    setSecondSelectYear(secondSelectYear);
    setYearStartRange(yearStartRange);
    setYearEndRange(yearEndRange);

    if (firstSelectMonth && firstSelectYear && secondSelectMonth && secondSelectYear) {
      let startDate = firstSelectYear + "-" + firstSelectMonth + "-01";
      let endDate = secondSelectYear + "-" + secondSelectMonth + "-01";

      if (new Date(startDate) > new Date(endDate)) {
        setFirstSelectMonth(secondSelectMonth);
        setFirstSelectYear(secondSelectYear);
        setSecondSelectMonth(firstSelectMonth);
        setSecondSelectYear(firstSelectYear);
        const temp = startDate;
        startDate = endDate;
        endDate = temp;
      }
      else {
        setFirstSelectMonth(firstSelectMonth);
        setFirstSelectYear(firstSelectYear);
        setSecondSelectMonth(secondSelectMonth);
        setSecondSelectYear(secondSelectYear);
      }

      monthlyApiForecast(nationality, province, "AR", startDate, endDate).then((res) => {
        setTouristsNumber(res.data);
        setYears(res.labels);
      });
    }

    if (yearStartRange && yearEndRange) {
      if (new Date(yearStartRange) > new Date(yearEndRange)) {
        setYearStartRange(yearEndRange);
        setYearEndRange(yearStartRange);
        const temp = yearStartRange;
        yearStartRange = yearEndRange;
        yearEndRange = temp;
      }
      else {
        setYearStartRange(yearStartRange);
        setYearEndRange(yearEndRange);
      }
      annualApiForecast(nationality, province, "AR", yearStartRange, yearEndRange).then((res) => {
        setTouristsNumber(res.data);
        setYears(res.labels);
      });
    }

    handleSidebar();
  };

  return (
    <>
      <Head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
        <meta name="description" content="Con Touristats puoi analizzare il flusso dei turisti in Sardegna grazie a statistiche e previsioni" />
        <link rel="icon" href="/assets/touristats-logo.jpg" />
        <title>Previsioni - TouriStats</title>
      </Head>
      <Navbar page="previsioni" />
      <div className="h-full">
        <Sidebar
          side={side}
          page="previsioni"
          handleSidebar={handleSidebar}
          handleSaveFilters={handleSaveFilters}
        />
        <h1 className="uppercase text-center pt-40">
          <span className="text-[#284697]">
            Prev
            <span className="half" title="S">
              is
            </span>
          </span>
          <span className="text-[#00ACC1]">ioni</span>
        </h1>
        <div className="text-center my-5">
          <button
            onClick={handleSidebar}
            className="uppercase my-10 bg-transparent hover:bg-[#00ACC1] text-[#0094c1] hover:text-white font-semibold py-2 px-4 border border-[#00ACC1] hover:border-transparent rounded shadow-md shadow-[#0094c1] disabled:opacity-40"
            name="btn"
          >
            filtra
          </button>
        </div>
        <div className="flex justify-center pb-5">
          <p className="uppercase font-semibold">filtri attivi:</p>
        </div>
        <div className="flex flex-col sm:justify-center gap-2 sm:flex-row items-center">
          {yearStartRange && yearEndRange && (
            <div className="badge bg-[#0084c1] border-none rounded-sm uppercase p-3 font-semibold bg-opacity-60">
              {yearStartRange} - {yearEndRange}
            </div>
          )}
          {firstSelectMonth &&
            secondSelectMonth &&
            secondSelectYear &&
            firstSelectYear && (
              <div className="badge  bg-[#0084c1] border-none rounded-sm uppercase p-3 font-semibold bg-opacity-60">
                {firstSelectMonth}/{firstSelectYear} - {secondSelectMonth}/{secondSelectYear}
              </div>
            )}
          <div className="badge bg-[#0084c1] border-none rounded-sm uppercase p-3 font-semibold bg-opacity-60">
            {nationality === "WORLD" ? "Tutte le nazionalità" : nationality === "WRL_X_ITA" ? "Paesi esteri" : nationality}
          </div>
          <div className="badge bg-[#0084c1] border-none rounded-sm uppercase p-3 font-semibold bg-opacity-60">
            {province === "ITG2" ? "Tutte le province" : province === "ITG25" ? "Sassari" : province === "ITG26" ? "Nuoro" :
              province === "ITG27" ? "Cagliari" : province === "ITG28" ? "Oristano" : province === "ITG29" ? "Olbia-Tempio" :
                province === "ITG2A" ? "Ogliastra" : province === "ITG2B" ? "Medio Campidano" : province === "ITG2C" ? "Carbonia-Iglesias"
                  : province === "IT111" && "Sud Sardegna"
            }
          </div>
        </div>

        <div className="chart">
          <BarChart
            data={{
              labels: years,
              datasets: [
                {
                  data: touristsNumber,
                  backgroundColor: "#00ACC1",
                },
              ],
            }}
          />
        </div>
        <Footer />
      </div>
    </>
  );
};

export default previsioni;
