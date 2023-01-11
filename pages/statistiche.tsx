import React, { useEffect, useState } from "react";
import BarChart from "../components/BarChart";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import { toggleSidebar } from "../redux/SidebarSlice";
import { RootState, store } from "../redux/store";
import { useSelector } from "react-redux";
import { getData } from "../Api";

const statistiche = () => {
  const sidebar = useSelector((state: RootState) => state.sidebar.value);
  const [side, setSide] = useState(sidebar);
  const [year, setYear] = useState("2022");
  // const [period, setPeriod] = useState(["01/2022", "03/2022"]);
  const [nazionality, setNazionality] = useState("IT");
  const [province, setProvince] = useState("ITG27");
  const [touristsNumber, setTouristsNumber] = useState([])
  const [years, setYears] = useState([])


  useEffect(() => {
    setSide(sidebar);
  }, [sidebar]);

  const handleSidebar = () => {
    store.dispatch(toggleSidebar());
  };

  useEffect(() => {
    handleData()
  }, [])

  const handleData = async () => {
    const res = await getData('data/annual/origin/WORLD/destination/ITG2/type/AR')
    console.log(res)

    const resTouristsNumber: any = [];
    const resYears: any = [];

    res.map((el: any) => {
      resTouristsNumber.push(el.observation)
      resYears.push(el.year)
    });

    setTouristsNumber(resTouristsNumber);
    setYears(resYears)
  }

  const handleSaveFilters = (year: string, nazionality: string, province: string) => {
    setYear(year);
    console.log(year);
    setNazionality(nazionality);
    console.log(nazionality);
    setProvince(province);
    console.log(province);
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
