import React, { useState } from "react";
import { AiOutlineCheck, AiOutlineClose, AiOutlineDelete } from "react-icons/ai";

const Sidebar = (props: {
  side: boolean;
  handleSidebar: () => void;
  handleSaveFilters: (
    nazionality: string,
    province: string,
    year?: string,
    firstSelectMonth?: string,
    firstSelectYear?: string,
    secondSelectMonth?: string,
    secondSelectYear?: string
  ) => void;
}) => {
  const [nazionality, setNazionality] = useState<string>("IT");
  const [province, setProvince] = useState<string>("ITG2");
  const [year, setYear] = useState<undefined | string>("2021");
  const [firstSelectMonth, setFirstSelectMonth] = useState<undefined | string>("01");
  const [firstSelectYear, setFirstSelectYear] = useState<undefined | string>("2020");
  const [secondSelectMonth, setSecondSelectMonth] = useState<undefined | string>("01");
  const [secondSelectYear, setSecondSelectYear] = useState<undefined | string>("2021");
  const [yearDisabled, setYearDisabled] = useState(false);
  const [periodDisabled, setPeriodDisabled] = useState(true);

  const handleFirstSelectMonth = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setFirstSelectMonth(e.target.value);
  };

  const handleFirstSelectYear = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setFirstSelectYear(e.target.value);
  };

  const handleSecondSelectMonth = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setSecondSelectMonth(e.target.value);
  };

  const handleSecondSelectYear = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setSecondSelectYear(e.target.value);
  };

  const handleYear = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setYear(e.target.value);
  };

  const handleNazionality = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setNazionality(e.target.value);
  };

  const handleProvince = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setProvince(e.target.value);
  };

  const handleOnClickSave = () => {
    if (yearDisabled === false) {
      props.handleSaveFilters(nazionality, province, year);
    }
    if (periodDisabled === false) {
      props.handleSaveFilters(
        nazionality,
        province,
        undefined,
        firstSelectMonth,
        firstSelectYear,
        secondSelectMonth,
        secondSelectYear
      );
    }
  };

  const handleOnClickReset = () => {
    setNazionality("IT");
    setProvince("ITG2");
    setYear("2021");
    setFirstSelectMonth("01");
    setFirstSelectYear("2020");
    setSecondSelectMonth("01");
    setSecondSelectYear("2021");
  };

  const handleDisabled = (div: string) => {
    if (div === "year") {
      setYearDisabled(false);
      setPeriodDisabled(true);
    } else {
      setYearDisabled(true);
      setPeriodDisabled(false);
    }
  };

  return (
    <>
      <div
        className={`fixed md:top-20 bg-white w-full md:h-full md:w-96 ease-in duration-500 overflow-y-scroll h-[60vh] ${
          props.side
            ? "top-[40%] rounded-3xl md:rounded-none md:left-0"
            : "top-[100%] md:left-[-24rem]"
        }`}
      >
        <aside className="">
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
            <div
              onClick={() => {
                handleDisabled("year");
              }}
            >
              <label className="mb-2 text-sm font-medium text-gray-900">Seleziona l'anno</label>
              <select
                id="anno"
                className="text-start mb-5 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-[100px] p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                value={year}
                onChange={handleYear}
                disabled={yearDisabled === true ? true : false}
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
            </div>
            <label className="mb-2 text-sm font-medium text-gray-900">
              Seleziona il periodo - con data picker
            </label>
            <div
              className="flex gap-3"
              onClick={() => {
                handleDisabled("period");
              }}
            >
              <select
                disabled={periodDisabled === true ? true : false}
                onChange={handleFirstSelectMonth}
                className="text-start mb-5 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-22 p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                value={firstSelectMonth}
              >
                <option value="01">Gen</option>
                <option value="02">Feb</option>
                <option value="03">Mar</option>
                <option value="04">Apr</option>
                <option value="05">Mag</option>
                <option value="06">Giu</option>
                <option value="07">Lug</option>
                <option value="08">Ago</option>
                <option value="09">Set</option>
                <option value="10">Ott</option>
                <option value="11">Nov</option>
                <option value="12">Dic</option>
              </select>
              <select
                disabled={periodDisabled === true ? true : false}
                onChange={handleFirstSelectYear}
                className="text-start mb-5 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-22 p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                value={firstSelectYear}
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
            </div>
            <div
              className="flex gap-3"
              onClick={() => {
                handleDisabled("period");
              }}
            >
              <select
                disabled={periodDisabled === true ? true : false}
                onChange={handleSecondSelectMonth}
                className="text-start mb-5 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-22 p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                value={secondSelectMonth}
              >
                <option value="01">Gen</option>
                <option value="02">Feb</option>
                <option value="03">Mar</option>
                <option value="04">Apr</option>
                <option value="05">Mag</option>
                <option value="06">Giu</option>
                <option value="07">Lug</option>
                <option value="08">Ago</option>
                <option value="09">Set</option>
                <option value="10">Ott</option>
                <option value="11">Nov</option>
                <option value="12">Dic</option>
              </select>
              <select
                disabled={periodDisabled === true ? true : false}
                onChange={handleSecondSelectYear}
                className="text-start mb-5 bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-22 p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
                value={secondSelectYear}
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
            </div>

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

            <label className="mb-2 text-sm font-medium text-gray-900">Seleziona la provincia</label>
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
              onClick={handleOnClickSave}
            >
              <AiOutlineCheck />
            </div>
          </div>
          <div className="flex w-full justify-end px-10 my-5">
            <div
              className=" rounded-full shadow-lg shadow-gray-400 p-[10px] cursor-pointer"
              onClick={handleOnClickReset}
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
