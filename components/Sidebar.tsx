import React, { useState } from "react";
import { AiOutlineClose } from "react-icons/ai";

const Sidebar = (props: { side: boolean; handleSidebar: () => void }) => {
  return (
    <>
      <div
        className={`fixed md:top-20 bg-white w-full h-full md:w-96 ease-in duration-500 ${
          props.side ? "top-[40%] overflow-scroll rounded-3xl md:rounded-none md:left-0" : "top-[100%] md:left-[-24rem]"
        }`}
      >
        <aside>
          <div className="flex w-full items-center justify-between p-10">
            <span className="font-bold text-[#284697] text-2xl ">Filtra</span>
            <div
              className=" rounded-full shadow-lg shadow-gray-400 p-[10px] cursor-pointer"
              onClick={props.handleSidebar}
            >
              <AiOutlineClose />
            </div>
          </div>
          <div className="flex flex-col px-10 ">
            <label className="mb-2 text-sm font-medium text-gray-900">
              Seleziona l'anno
            </label>
            <select
              id="anno"
              className="text-start mb-5 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-[100px] p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            >
              <option selected>2022</option>
              <option value="2021">2021</option>
              <option value="2020">2020</option>
              <option value="2019">2019</option>
              <option value="2018">2018</option>
              <option value="2017">2017</option>
              <option value="2016">2016</option>
              <option value="2015">2015</option>
              <option value="2014">2014</option>
            </select>

            <label className="mb-2 text-sm font-medium text-gray-900">
              Seleziona il periodo - con data picker
            </label>
            <select
              id="periodo"
              className="text-start mb-5 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-[165px] p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            >
              <option selected>01/2022 - 03/2023</option>
            </select>

            <label className="mb-2 text-sm font-medium text-gray-900">
              Seleziona la nazionalità
            </label>
            <select
              id="nazionalita"
              className="text-start mb-5 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-[165px] p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            >
              <option selected>Italia</option>
              <option value="WORLD">Mondo</option>
              <option value="US">United States</option>
              <option value="CA">Canada</option>
              <option value="FR">France</option>
              <option value="DE">Germany</option>
            </select>

            <label className="mb-2 text-sm font-medium text-gray-900">
              Seleziona la provincia
            </label>
            <select
              id="province"
              className="text-start mb-5 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-[165px] p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            >
              <option selected>Nuoro</option>
              <option value="">Sassari</option>
              <option value="">Oristano</option>
              <option value="">Cagliari</option>
              <option value="">Sud Sardegna</option>
            </select>
          </div>
        </aside>
      </div>
    </>
  );
};

export default Sidebar;
