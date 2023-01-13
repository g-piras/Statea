import React, { useState } from "react";
import {
  AiOutlineCheck,
  AiOutlineClose,
  AiOutlineInfoCircle,
} from "react-icons/ai";

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
    yearEndRange?: string
  ) => void;
}) => {
  const [firstSelectYear, setFirstSelectYear] = useState<undefined | string>(
    "2021"
  );
  const [secondSelectYear, setSecondSelectYear] = useState<undefined | string>(
    "2021"
  );
  const [year, setYear] = useState<undefined | string>("2021");
  const [yearDisabled, setYearDisabled] = useState(true);
  const [periodDisabled, setPeriodDisabled] = useState(true);
  const [yearRangeDisabled, setYearRangeDisabled] = useState(false);

  const handleYear = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setYear(e.target.value);
  };

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

  const handleDisabled = (div: string) => {
    if (div === "year") {
      setYearDisabled(false);
      setPeriodDisabled(true);
      setYearRangeDisabled(true);
    }
    if (div === "period") {
      setYearDisabled(true);
      setPeriodDisabled(false);
      setYearRangeDisabled(true);
    }
    if (div === "yearRange") {
      setYearDisabled(true);
      setPeriodDisabled(true);
      setYearRangeDisabled(false);
    }
  };

  return (
    <>
      <div
        className={`fixed md:top-20 bg-white w-full h-[60vh] md:h-[90vh] md:w-96 ease-in duration-500 overflow-y-scroll pb-5 ${
          props.side
            ? "top-[40%] rounded-t-3xl md:rounded-none md:left-0"
            : "top-[100%] md:left-[-24rem]"
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
            <div className="px-10">
              <div
                onClick={() => {
                  handleDisabled("yearRange");
                }}
              >
                <label className="text-sm font-medium text-gray-900">
                  Range di anni
                </label>
                <div className="flex gap-3">
                  <select
                    id="yearStartRange"
                    className="text-start text-sm text-white mb-5 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-24 p-2.5"
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
                    className="text-start text-sm text-white mb-5 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-24 p-2.5"
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
                </div>
              </div>

              <div
                onClick={() => {
                  handleDisabled("year");
                }}
              >
                <label className="text-sm font-medium text-gray-900">
                  Anno
                </label>
                <select
                  id="year"
                  className="text-start text-sm text-white mb-5 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-24 p-2.5"
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
              </div>
              <div
                onClick={() => {
                  handleDisabled("period");
                }}
              >
                <label className="text-sm font-medium text-gray-900">
                  Periodo
                </label>
                <div className="flex gap-3">
                  <select
                    id="firstSelectMonth"
                    disabled={periodDisabled === true ? true : false}
                    className="text-start text-sm text-white mb-2 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-24 p-2.5"
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
                    className="text-start text-sm text-white mb-2 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-24 p-2.5"
                    value={firstSelectYear}
                  >
                    <option value="2021">2021</option>
                    <option value="2020">2020</option>
                    <option value="2019">2019</option>
                    <option value="2018">2018</option>
                    <option value="2017">2017</option>
                    <option value="2016">2016</option>
                  </select>
                </div>
                <div className="flex gap-3">
                  <select
                    id="secondSelectMonth"
                    disabled={periodDisabled === true ? true : false}
                    className="text-start text-sm text-white mb-5 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-24 p-2.5"
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
                    className="text-start text-sm text-white mb-5 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-24 p-2.5"
                    value={secondSelectYear}
                  >
                    <option value="2021">2021</option>
                    <option value="2020">2020</option>
                    <option value="2019">2019</option>
                    <option value="2018">2018</option>
                    <option value="2017">2017</option>
                    <option value="2016">2016</option>
                  </select>
                </div>
              </div>

              <label className="text-sm font-medium text-gray-900">
                <div className="flex items-center gap-1">
                  <div>Paese di provenienza</div>
                  <button>
                    <AiOutlineInfoCircle />
                  </button>
                  Nota: Tutte la nazionalità sono disponibili solo selezionando
                  il range di anni
                </div>
              </label>
              <select
                id="nationality"
                className="text-start text-sm text-white mb-5 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-[165px] p-2.5"
              >
                <option value="WORLD">Mondo</option>
                <option value="WRL_X_ITA">Paesi esteri</option>
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
                  </>
                ) : (
                  ""
                )}
              </select>

              <label className="text-sm font-medium text-gray-900">
                Provincia
              </label>
              <select
                id="province"
                className="text-start text-sm text-white mb-14 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-[165px] p-2.5"
              >
                <option value="ITG2">Tutte le province</option>
                <option value="ITG25">Sassari</option>
                <option value="ITG26">Nuoro</option>
                <option value="ITG27">Cagliari</option>
                <option value="ITG28">Oristano</option>
                {(yearDisabled === false && year === "2016") ||
                (periodDisabled === false &&
                  (firstSelectYear === "2016" ||
                    secondSelectYear === "2016")) ||
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
