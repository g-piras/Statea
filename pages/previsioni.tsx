import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import { toggleSidebar } from "../redux/SidebarSlice";
import { RootState, store } from "../redux/store";

const previsioni = () => {
  const sidebar = useSelector((state: RootState) => state.sidebar.value);
  const [side, setSide] = useState<boolean>(sidebar);
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
    setYear(year);
    console.log(year);
    setNazionality(nazionality);
    console.log(nazionality);
    setProvince(province);
    console.log(province);
    setFirstSelectMonth(firstSelectMonth);
    console.log(firstSelectMonth);
    setFirstSelectYear(firstSelectYear);
    console.log(firstSelectYear); 
    setSecondSelectMonth(secondSelectMonth);
    console.log(secondSelectMonth);
    setSecondSelectYear(secondSelectYear);
    console.log(secondSelectYear);
    handleSidebar();
  };

  return (
    <>
      <Navbar page="previsioni" />

      <div>
        <Sidebar side={side} handleSidebar={handleSidebar} handleSaveFilters={handleSaveFilters} />
        <h1 className="uppercase text-center pt-32">
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
            className="uppercase mb-10 bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded"
          >
            filtra
          </button>
        </div>
      </div>
    </>
  );
};

export default previsioni;
