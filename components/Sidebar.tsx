import React, { useState } from "react";
import {
  AiOutlineCheck,
  AiOutlineClose,
  AiOutlineDelete,
} from "react-icons/ai";

const Sidebar = (props: {
  side: boolean;
  handleSidebar: () => void;
  handleSaveFilters: (
    year: string,
    nazionality: string,
    province: string
  ) => void;
}) => {
  const [year, setYear] = useState("2021");
  // const [period, setPeriod] = useState(["01/2022", "03/2022"]);
  const [nazionality, setNazionality] = useState("IT");
  const [province, setProvince] = useState("ITG2");

  const handleYear = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setYear(e.target.value);
  };

  const handleNazionality = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setNazionality(e.target.value);
  };

  const handleProvince = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setProvince(e.target.value);
  };

  const handleReset = () => {
    setYear("2022");
    setNazionality("IT");
    setProvince("ITG2");
  };

  return (
    <>
      <div
        className={`fixed md:top-20 bg-white w-full h-full md:w-96 ease-in duration-500 ${
          props.side
            ? "top-[40%] rounded-3xl md:rounded-none md:left-0"
            : "top-[100%] md:left-[-24rem]"
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
              value={year}
              onChange={handleYear}
            >
              <option value="2021">2021</option>
              <option value="2020">2020</option>
              <option value="2019">2019</option>
              <option value="2018">2018</option>
              <option value="2017">2017</option>
              <option value="2016">2016</option>
              <option value="2015">2015</option>
              <option value="2014">2014</option>
              <option value="2013">2013</option>
              <option value="2012">2012</option>
              <option value="2011">2011</option>
              <option value="2010">2010</option>
              <option value="2009">2009</option>
              <option value="2008">2008</option>
            </select>

            <label className="mb-2 text-sm font-medium text-gray-900">
              Seleziona il periodo - con data picker
            </label>
            <select
              id="periodo"
              className="text-start mb-5 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-[165px] p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
            >
              <option>01/2022 - 03/2023</option>
            </select>

            <label className="mb-2 text-sm font-medium text-gray-900">
              Seleziona la nazionalità
            </label>
            <select
              id="nazionalita"
              className="text-start mb-5 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-[165px] p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              value={nazionality}
              onChange={handleNazionality}
            >
              <option value="WORLD">Mondo</option>
              <option value="WRL_X_ITA">Paesi esteri</option>
              <option value="AR">Argentina</option>
              <option value="AT">Austria</option>
              <option value="AU">Australia</option>
              <option value="BE">Belgio</option>
              <option value="BG">Bulgaria</option>
              <option value="BR">Brasile</option>
              <option value="CA">Canada</option>
              <option value="CN">Cina</option>
              <option value="CY">Cipro</option>
              <option value="CZ">Cechia</option>
              <option value="DE">Germania</option>
              <option value="DK">Danimarca</option>
              <option value="EE">Estonia</option>
              <option value="EG">Egitto</option>
              <option value="ES">Spagna</option>
              <option value="FI">Finlandia</option>
              <option value="FR">Francia</option>
              <option value="HR">Croazia</option>
              <option value="HU">Ungheria</option>
              <option value="IE">Irlanda</option>
              <option value="IL">Israele</option>
              <option value="IN">India</option>
              <option value="IS">Islanda</option>
              <option value="IT">Italia</option>
              <option value="JP">Giappone</option>
              <option value="KR">Corea del Sud</option>
              <option value="LT">Lituania</option>
              <option value="LU">Lussemburgo</option>
              <option value="LV">Lettonia</option>
              <option value="MT">Malta</option>
              <option value="MX">Messico</option>
              <option value="NL">Paesi Bassi</option>
              <option value="NO">Norvegia</option>
              <option value="NZ">Nuova Zelanda</option>
              <option value="PL">Polonia</option>
              <option value="PT">Portogallo</option>
              <option value="RO">Romania</option>
              <option value="RU">Russia</option>
              <option value="SE">Svezia</option>
              <option value="SI">Slovenia</option>
              <option value="SK">Slovacchia</option>
              <option value="TR">Turchia</option>
              <option value="US">United States</option>
              <option value="VE">Venezuela</option>
              <option value="ZA">Sud Africa</option>
            </select>

            <label className="mb-2 text-sm font-medium text-gray-900">
              Seleziona la provincia
            </label>
            <select
              id="province"
              className="text-start mb-5 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-[165px] p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              value={province}
              onChange={handleProvince}
            >
              <option value="ITG2">Sardegna</option>
              <option value="ITG25">Sassari</option>
              <option value="ITG26">Nuoro</option>
              <option value="ITG27">Cagliari</option>
              <option value="ITG28">Oristano</option>
              <option value="ITG29">Olbia-Tempio</option>
              <option value="ITG2A">Ogliastra</option>
              <option value="ITG2B">Medio Campidano</option>
              <option value="ITG2C">Carbonia-Iglesias</option>
            </select>
          </div>
          <div className="flex w-full justify-end px-10 my-3">
            <div
              className=" rounded-full shadow-lg shadow-gray-400 p-[10px] cursor-pointer"
              onClick={() => {
                props.handleSaveFilters(year, nazionality, province);
              }}
            >
              <AiOutlineCheck />
            </div>
          </div>
          <div className="flex w-full justify-end px-10">
            <div
              className=" rounded-full shadow-lg shadow-gray-400 p-[10px] cursor-pointer"
              onClick={handleReset}
            >
              <AiOutlineDelete />
            </div>
          </div>
        </aside>
      </div>
    </>
  );
};

export default Sidebar;
