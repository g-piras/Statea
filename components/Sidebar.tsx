import React, { useState } from "react";
import { AiOutlineCheck, AiOutlineClose, AiOutlineInfoCircle } from "react-icons/ai";

const Sidebar = (props: {
  side: boolean;
  page: string;
  handleSidebar: () => void;
  handleSaveFilters: (
    nazionality: string,
    province: string,
    year?: string,
    firstSelectMonth?: string,
    firstSelectYear?: string,
    secondSelectMonth?: string,
    secondSelectYear?: string,
    yearStartRange?: string,
    yearEndRange?: string,
  ) => void;
}) => {
  const [firstSelectYear, setFirstSelectYear] = useState<undefined | string>("2021");
  const [secondSelectYear, setSecondSelectYear] = useState<undefined | string>("2021");
  const [year, setYear] = useState<undefined | string>("2021");
  const [yearDisabled, setYearDisabled] = useState(true);
  const [periodDisabled, setPeriodDisabled] = useState(true);
  const [yearRangeDisabled, setYearRangeDisabled] = useState(false);
  const [selected, setSelected] = useState("first");

  // const handleYear = (e: React.ChangeEvent<HTMLSelectElement>) => {
  //   setYear(e.target.value);
  // };

  const handleFirstSelectYear = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setFirstSelectYear(e.target.value);
  };

  const handleSecondSelectYear = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setSecondSelectYear(e.target.value);
  };

  const handleOnSubmit = (e: any) => {
    e.preventDefault();
    if (yearDisabled === false) {
      props.handleSaveFilters(
        e.target.nationality.value,
        e.target.province.value,
        e.target.year.value
      );
    }
    if (periodDisabled === false) {
      props.handleSaveFilters(
        e.target.nationality.value,
        e.target.province.value,
        undefined,
        e.target.firstSelectMonth.value,
        e.target.firstSelectYear.value,
        e.target.secondSelectMonth.value,
        e.target.secondSelectYear.value
      );
    }
    if (yearRangeDisabled === false) {
      props.handleSaveFilters(
        e.target.nationality.value,
        e.target.province.value,
        undefined,
        undefined,
        undefined,
        undefined,
        undefined,
        e.target.yearStartRange.value,
        e.target.yearEndRange.value
      );
    }
  };

  const handleTabOnClick = (tab: string) => {
    if (tab === "first") {
      setSelected("first");
      setYearRangeDisabled(false);
      setYearDisabled(true);
      setPeriodDisabled(true);
    }
    // if (tab === "second") {
    //   setSelected("second");
    //   setYearRangeDisabled(true);
    //   setYearDisabled(true);
    //   setPeriodDisabled(false);
    // }
    if (tab === "second") {
      setSelected("second");
      setYearRangeDisabled(true);
      setYearDisabled(true);
      setPeriodDisabled(false);
    }
  };

  return (
    <>
      <div
        className={`fixed bg-white bottom-0 md:top-20 h-[60vh] md-height w-full md:w-96 ease-in duration-500 overflow-y-scroll overflow-x-hidden ${props.side
          ? "rounded-t-3xl md:rounded-none md:left-0"
          : "-bottom-[60vh] md:-left-96"
          }`}
      >
        <aside>
          <form onSubmit={handleOnSubmit}>
            <div className="flex w-full items-center justify-between p-10">
              <span className="font-bold text-[#284697] text-2xl ">Filtra</span>
              <div className="flex gap-1">
                <button
                  type="submit"
                  className=" rounded-full shadow-lg shadow-gray-400 p-[10px] cursor-pointer"
                >
                  <AiOutlineCheck />
                </button>
                <div
                  className=" rounded-full shadow-lg shadow-gray-400 p-[10px] cursor-pointer"
                  onClick={props.handleSidebar}
                >
                  <AiOutlineClose />
                </div>
              </div>
            </div>
            <div className="ml-10 w-fit">
              <div className="tabs mb-5">
                <a
                  className={`tab tab-bordered ${selected === "first" && "tab-active"}`}
                  onClick={() => {
                    handleTabOnClick("first");
                  }}
                >
                  Range di Anni
                </a>
                {/* <a
                  className={`tab tab-bordered ${selected === "second" && "tab-active"}`}
                  onClick={() => {
                    handleTabOnClick("second");
                  }}
                >
                  Anno
                </a> */}
                <a
                  className={`tab tab-bordered ${selected === "second" && "tab-active"}`}
                  onClick={() => {
                    handleTabOnClick("second");
                  }}
                >
                  Periodo
                </a>
                <div
                  className="tooltip tooltip-top ml-2"
                  data-tip="Nota: Puoi selezionare una sola voce per volta"
                >
                  <button type="button">
                    <AiOutlineInfoCircle />
                  </button>
                </div>
              </div>

              {selected === "first" && (
                <>
                  <select
                    id="yearStartRange"
                    className="inline text-white mb-7 bg-gray-700 border border-gray-600 rounded-lg  w-24 p-2.5 cursor-pointer"
                    disabled={yearRangeDisabled === true ? true : false}
                    defaultValue="2008"
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
                  <select
                    id="yearEndRange"
                    className="inline text-white mb-7 ml-2 bg-gray-700 border border-gray-600 rounded-lg  w-24 p-2.5 cursor-pointer"
                    disabled={yearRangeDisabled === true ? true : false}
                    defaultValue="2021"
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
                </>
              )}

              {/* {selected === "second" && (
                <>
                  <select
                    id="year"
                    className="text-white mb-7 bg-gray-700 border border-gray-600 rounded-lg  w-24 p-2.5 cursor-pointer"
                    value={year}
                    onChange={handleYear}
                    disabled={yearDisabled === true ? true : false}
                  >
                    {props.page === "statistiche" ? (
                      <>
                        <option value="2021">2021</option>
                        <option value="2020">2020</option>
                        <option value="2019">2019</option>
                        <option value="2018">2018</option>
                        <option value="2017">2017</option>
                        <option value="2016">2016</option>
                      </>
                    ) : (
                      <>
                        <option value="2023">2023</option>
                        <option value="2024">2024</option>
                        <option value="2025">2025</option>
                        <option value="2026">2026</option>
                        <option value="2027">2027</option>
                        <option value="2028">2028</option>
                      </>
                    )}
                  </select>
                </>
              )} */}

              {selected === "second" && (
                <>
                  <div>
                    <select
                      id="firstSelectMonth"
                      disabled={periodDisabled === true ? true : false}
                      className="inline text-white mb-4 bg-gray-700 border border-gray-600 rounded-lg  w-24 p-2.5 cursor-pointer"
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
                      id="firstSelectYear"
                      disabled={periodDisabled === true ? true : false}
                      onChange={handleFirstSelectYear}
                      className="inline text-white mb-4 ml-2 bg-gray-700 border border-gray-600 rounded-lg  w-24 p-2.5 cursor-pointer"
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
                  <div>
                    <select
                      id="secondSelectMonth"
                      disabled={periodDisabled === true ? true : false}
                      className="inline text-white mb-7 bg-gray-700 border border-gray-600 rounded-lg  w-24 p-2.5 cursor-pointer"
                      defaultValue="12"
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
                      id="secondSelectYear"
                      disabled={periodDisabled === true ? true : false}
                      onChange={handleSecondSelectYear}
                      className="inline text-white mb-7 ml-2 bg-gray-700 border border-gray-600 rounded-lg  w-24 p-2.5 cursor-pointer"
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
                </>
              )}

              <div>
                <label htmlFor="nationality" className="font-medium text-gray-900">
                  <div className="inline mr-1">Paese di provenienza</div>
                </label>
                <div
                  className="tooltip tooltip-top ml-3 relative top-[3px]"
                  data-tip="Nota: Tutte la nazionalità sono disponibili solo selezionando
                il range di anni"
                >
                  <button type="button">
                    <AiOutlineInfoCircle />
                  </button>
                </div>
              </div>
              <select
                id="nationality"
                className="text-white mb-5 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-[165px] p-2.5 cursor-pointer"
              >
                <option value="WORLD">Mondo</option>
                <option value="WRL_X_ITA">Paesi esteri - Italia esclusa -</option>
                <option value="IT">Italia</option>
                {yearDisabled && periodDisabled ? (
                  <>
                    <option value="AR">Argentina</option>
                    <option value="AT">Austria</option>
                    <option value="AU">Australia</option>
                    <option value="BE">Belgio</option>
                    <option value="BG">Bulgaria</option>
                    <option value="BR">Brasile</option>
                    <option value="CA">Canada</option>
                    <option value="CZ">Cechia</option>
                    <option value="CN">Cina</option>
                    <option value="CY">Cipro</option>
                    <option value="KR">Corea del Sud</option>
                    <option value="HR">Croazia</option>
                    <option value="DK">Danimarca</option>
                    <option value="EG">Egitto</option>
                    <option value="EE">Estonia</option>
                    <option value="FI">Finlandia</option>
                    <option value="FR">Francia</option>
                    <option value="DE">Germania</option>
                    <option value="JP">Giappone</option>
                    <option value="GR">Grecia</option>
                    <option value="IN">India</option>
                    <option value="IE">Irlanda</option>
                    <option value="IS">Islanda</option>
                    <option value="IL">Israele</option>
                    <option value="LV">Lettonia</option>
                    <option value="LT">Lituania</option>
                    <option value="LU">Lussemburgo</option>
                    <option value="HU">Ungheria</option>
                    <option value="MT">Malta</option>
                    <option value="MX">Messico</option>
                    <option value="NO">Norvegia</option>
                    <option value="NZ">Nuova Zelanda</option>
                    <option value="NL">Paesi Bassi</option>
                    <option value="PL">Polonia</option>
                    <option value="PT">Portogallo</option>
                    <option value="RO">Romania</option>
                    <option value="RU">Russia</option>
                    <option value="SK">Slovacchia</option>
                    <option value="SI">Slovenia</option>
                    <option value="ES">Spagna</option>
                    <option value="ZA">Sud Africa</option>
                    <option value="SE">Svezia</option>
                    <option value="TR">Turchia</option>
                    <option value="US">United States</option>
                    <option value="HU">Ungheria</option>
                    <option value="VE">Venezuela</option>
                  </>
                ) : (
                  ""
                )}
              </select>

              <div>
                <label htmlFor="nationality" className="font-medium text-gray-900">
                  <div className="inline mr-1">Provincia</div>
                </label>
                <div
                  className="tooltip tooltip-top ml-3 relative top-[3px]"
                  data-tip="Nota: Alcune province non possono essere selezionate se vengono inseriti dati mensili troppo recenti"
                >
                  <button type="button">
                    <AiOutlineInfoCircle />
                  </button>
                </div>
              </div>
              <select
                id="province"
                className="text-white mb-14 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-[165px] p-2.5 cursor-pointer"
              >
                <option value="ITG2">Tutte le province</option>
                <option value="ITG25">Sassari</option>
                <option value="ITG26">Nuoro</option>
                <option value="ITG27">Cagliari</option>
                <option value="ITG28">Oristano</option>
                {(yearDisabled === false && year === "2016") ||
                  (periodDisabled === false &&
                    (firstSelectYear === "2016" || secondSelectYear === "2016")) ||
                  yearRangeDisabled === false ? (
                  <>
                    <option value="ITG29">Olbia-Tempio</option>
                    <option value="ITG2A">Ogliastra</option>
                    <option value="ITG2B">Medio Campidano</option>
                    <option value="ITG2C">Carbonia-Iglesias</option>
                  </>
                ) : (
                  ""
                )}
              </select>
            </div>
          </form>
        </aside>
      </div>
    </>
  );
};

export default Sidebar;
