import { faker } from "@faker-js/faker";
import React, { useEffect, useState } from "react";
import BarChart from "../components/BarChart";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import { labels } from "../components/BarChart";
import { toggleSidebar } from "../redux/SidebarSlice";
import { RootState, store } from "../redux/store";
import { useSelector } from "react-redux";

const statistiche = () => {
  const sidebar = useSelector((state: RootState) => state.sidebar.value);
  const [side, setSide] = useState(sidebar);

  useEffect(() => {
    setSide(sidebar);
  }, [sidebar]);

  const handleSidebar = () => {
    store.dispatch(toggleSidebar());
  };

  return (
    <>
      <Navbar page="statistiche" />

      <div>
        <Sidebar side={side} handleSidebar={handleSidebar} />
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
              labels: labels,
              datasets: [
                {
                  data: labels.map(() =>
                    faker.datatype.number({ min: 20000, max: 100000 })
                  ),
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
