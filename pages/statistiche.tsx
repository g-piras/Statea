import React, { use, useEffect, useState } from "react";
import BarChart from "../components/BarChart";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import { toggleSidebar } from "../redux/SidebarSlice";
import { RootState, store } from "../redux/store";
import { useSelector } from "react-redux";
import { annualApi, monthlyApi } from "../api";

const statistiche = () => {
  const sidebar = useSelector((state: RootState) => state.sidebar.value);
  const [side, setSide] = useState<boolean>(sidebar);
  const [touristsNumber, setTouristsNumber] = useState<string[]>([]);
  const [years, setYears] = useState<string[]>([]);
  const [nazionality, setNazionality] = useState<string>("IT");
  const [province, setProvince] = useState<string>("ITG27");
  const [year, setYear] = useState<undefined | string>(undefined);
  const [firstSelectMonth, setFirstSelectMonth] = useState<undefined | string>(undefined);
  const [firstSelectYear, setFirstSelectYear] = useState<undefined | string>(undefined);
  const [secondSelectMonth, setSecondSelectMonth] = useState<undefined | string>(undefined);
  const [secondSelectYear, setSecondSelectYear] = useState<undefined | string>(undefined);

  useEffect(() => {
    setSide(sidebar);
  }, [sidebar]);

  useEffect(() => {
    annualApi(nazionality, province, "AR").then((res) => {
      setTouristsNumber(res.data);
      setYears(res.labels);
    });
  }, []);

  const handleSidebar = () => {
    store.dispatch(toggleSidebar());
  };

  const handleSaveFilters = (
    nazionality: string,
    province: string,
    year?: string,
    firstSelectMonth?: string,
    firstSelectYear?: string,
    secondSelectMonth?: string,
    secondSelectYear?: string
  ) => {
    setNazionality(nazionality);
    setProvince(province);
    setYear(year);
    setFirstSelectMonth(firstSelectMonth);
    setFirstSelectYear(firstSelectYear);
    setSecondSelectMonth(secondSelectMonth);
    setSecondSelectYear(secondSelectYear);

    if (year) {
      monthlyApi(province, "AR", year + "-01-01", year + "-12-01").then((res) => {
        setTouristsNumber(res.data);
        setYears(res.labels);
      });
    }

    if (firstSelectMonth && firstSelectYear && secondSelectMonth && secondSelectYear) {
      const startDate = new Date(Number(firstSelectYear), Number(firstSelectMonth));
      const endDate = new Date(Number(secondSelectYear), Number(secondSelectMonth));
      const startStringDate = startDate
        .toLocaleString("it-IT", { day: "2-digit", month: "2-digit", year: "numeric" })
        .replace(/\//g, "-")
        .split("-")
        .reverse()
        .join("-");
      const endStringDate = endDate
        .toLocaleString("it-IT", { day: "2-digit", month: "2-digit", year: "numeric" })
        .replace(/\//g, "-")
        .split("-")
        .reverse()
        .join("-");

      monthlyApi(province, "AR", startStringDate, endStringDate).then((res) => {
        setTouristsNumber(res.data);
        setYears(res.labels);
      });
    }

    handleSidebar();
  };

  return (
    <>
      <Navbar page="statistiche" />

      <div>
        <Sidebar side={side} handleSidebar={handleSidebar} handleSaveFilters={handleSaveFilters} />
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
            className="uppercase mb-10 bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded"
          >
            filtra
          </button>
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
    </>
  );
};
export default statistiche;
