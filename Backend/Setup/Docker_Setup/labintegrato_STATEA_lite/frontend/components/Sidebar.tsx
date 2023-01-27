import React, { useEffect, useState } from "react";
import { AiOutlineCheck, AiOutlineClose, AiOutlineInfoCircle } from "react-icons/ai";

const Sidebar = (props: {
  side: boolean;
  page: string;
  handleSidebar: () => void;
  handleSaveFilters: (
    nazionality: string,
    province: string,
    firstSelectMonth?: string,
    firstSelectYear?: string,
    secondSelectMonth?: string,
    secondSelectYear?: string,
    yearStartRange?: string,
    yearEndRange?: string
  ) => void;
}) => {

  const [periodDisabled, setPeriodDisabled] = useState(true);
  const [yearRangeDisabled, setYearRangeDisabled] = useState(false);
  const [selected, setSelected] = useState("first");
  const [province, setProvince] = useState("ITG2");
  const [startYear, setStartYear] = useState("2008");
  const [endYear, setEndYear] = useState("2021");

  const yearOptionsControl = (province: string) => {
    if (props.page === "statistiche") {
      if (province === "IT111") {
        return [
          { value: "2021", label: "2021" },
          { value: "2020", label: "2020" },
          { value: "2019", label: "2019" },
          { value: "2018", label: "2018" },
          { value: "2017", label: "2017" },
        ];
      } else if (
        province !== "ITG29" &&
        province !== "ITG2A" &&
        province !== "ITG2B" &&
        province !== "ITG2C"
      ) {
        return [
          { value: "2021", label: "2021" },
          { value: "2020", label: "2020" },
          { value: "2019", label: "2019" },
          { value: "2018", label: "2018" },
          { value: "2017", label: "2017" },
          { value: "2016", label: "2016" },
          { value: "2015", label: "2015" },
          { value: "2014", label: "2014" },
          { value: "2013", label: "2013" },
          { value: "2012", label: "2012" },
          { value: "2011", label: "2011" },
          { value: "2010", label: "2010" },
          { value: "2009", label: "2009" },
          { value: "2008", label: "2008" },
        ];
      } else {
        return [
          { value: "2016", label: "2016" },
          { value: "2015", label: "2015" },
          { value: "2014", label: "2014" },
          { value: "2013", label: "2013" },
          { value: "2012", label: "2012" },
          { value: "2011", label: "2011" },
          { value: "2010", label: "2010" },
          { value: "2009", label: "2009" },
          { value: "2008", label: "2008" },
        ];
      }
    } else {
      return [
        { value: "2023", label: "2023" },
        { value: "2024", label: "2024" },
        { value: "2025", label: "2025" },
        { value: "2026", label: "2026" },
        { value: "2027", label: "2027" },
        { value: "2028", label: "2028" },
        { value: "2029", label: "2029" },
        { value: "2030", label: "2030" },
      ];
    }
  };

  const yearRangeValueControl = (province: string) => {
    if (props.page === "statistiche") {
      if (province === "IT111") {
        return {
          start: "2017",
          end: "2021"
        }
      } else if (province !== "ITG29" &&
        province !== "ITG2A" &&
        province !== "ITG2B" &&
        province !== "ITG2C") {
        return {
          start: "2008",
          end: "2021"
        }
      } else {
        return {
          start: "2008",
          end: "2016"
        }
      }
    } else {
      return {
        start: "2023",
        end: "2030"
      }
    }
  }

  const [yearOptions, setYearOptions] = useState(yearOptionsControl(province))

  const handleStartYearOnChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setStartYear(e.target.value)
  }

  const handleEndYearOnChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setEndYear(e.target.value);
  }

  const handleProvinceOnChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setProvince(e.target.value);
  };

  useEffect(() => {
    const rangeValues = yearRangeValueControl(province)
    setStartYear(rangeValues.start)
    setEndYear(rangeValues.end)
    setYearOptions(yearOptionsControl(province))
  }, [province])

  const handleOnSubmit = (e: any) => {
    e.preventDefault();
    if (periodDisabled === false) {
      props.handleSaveFilters(
        e.target.nationality.value,
        e.target.province.value,
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
        e.target.yearStartRange.value,
        e.target.yearEndRange.value
      );
    }
  };

  const handleTabOnClick = (tab: string) => {
    if (tab === "first") {
      setSelected("first");
      setYearRangeDisabled(false);
      setPeriodDisabled(true);
    }
    if (tab === "second") {
      setSelected("second");
      setYearRangeDisabled(true);
      setPeriodDisabled(false);
    }
  };

  return (
    <>
      <div
        className={`fixed bg-white bottom-0 md:top-20 h-[60vh] md-height w-full md:w-96 ease-in duration-500 overflow-y-scroll overflow-x-hidden ${props.side ? "rounded-t-3xl md:rounded-none md:left-0" : "-bottom-[60vh] md:-left-96"
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
                  name="btn"
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
                  id="btn"
                  className={`tab tab-bordered ${selected === "first" && "tab-active"}`}
                  onClick={() => {
                    handleTabOnClick("first");
                  }}
                >
                  Range di Anni
                </a>
                <a
                  className={`tab tab-bordered ${selected === "second" && "tab-active"}`}
                  id="btn"
                  onClick={() => {
                    handleTabOnClick("second");
                  }}
                >
                  Periodo
                </a>
                <div
                  className="tooltip tooltip-top"
                  data-tip="Nota: Puoi selezionare una sola voce per volta"
                >
                  <button type="button" name="btn" className="w-[44px] h-[44px] flex justify-center items-center relative top-[5px]">
                    <AiOutlineInfoCircle />
                  </button>
                </div>
              </div>

              {selected === "first" && (
                <>
                  <select
                    id="yearStartRange"
                    className="inline text-white mb-7 bg-gray-700 border border-gray-600 rounded-lg w-24 p-2.5 cursor-pointer"
                    disabled={yearRangeDisabled === true ? true : false}
                    onChange={handleStartYearOnChange}
                    value={startYear}
                  >
                    {yearOptions.map(((option) => (
                      <option key={option.value} value={option.value}>
                        {option.label}
                      </option>
                    )))}
                  </select>

                  <select
                    id="yearEndRange"
                    className="inline text-white mb-7 ml-2 bg-gray-700 border border-gray-600 rounded-lg w-24 p-2.5 cursor-pointer"
                    disabled={yearRangeDisabled === true ? true : false}
                    onChange={handleEndYearOnChange}
                    value={endYear}
                  >
                    {yearOptions.map(((option) => (
                      <option key={option.value} value={option.value}>
                        {option.label}
                      </option>
                    )))}
                  </select>
                </>
              )}

              {selected === "second" && (
                <>
                  <div>
                    <select
                      id="firstSelectMonth"
                      disabled={periodDisabled === true ? true : false}
                      className="inline text-white mb-4 bg-gray-700 border border-gray-600 rounded-lg w-24 p-2.5 cursor-pointer"
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
                      className="inline text-white mb-4 ml-2 bg-gray-700 border border-gray-600 rounded-lg w-24 p-2.5 cursor-pointer"
                    >
                      {yearOptions.map(((option) => (
                        <option key={option.value} value={option.value}>
                          {option.label}
                        </option>
                      )))}
                    </select>
                  </div>
                  <div>
                    <select
                      id="secondSelectMonth"
                      disabled={periodDisabled === true ? true : false}
                      className="inline text-white mb-7 bg-gray-700 border border-gray-600 rounded-lg w-24 p-2.5 cursor-pointer"
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
                      className="inline text-white mb-7 ml-2 bg-gray-700 border border-gray-600 rounded-lg w-24 p-2.5 cursor-pointer"
                    >
                      {yearOptions.map(((option) => (
                        <option key={option.value} value={option.value}>
                          {option.label}
                        </option>
                      )))}
                    </select>
                  </div>
                </>
              )
              }

              <div>
                <label htmlFor="nationality" className="font-medium text-gray-900">
                  <div className="inline mr-1">Paese di provenienza</div>
                </label>
                <div
                  className="tooltip tooltip-top relative top-[3px]"
                  data-tip="Nota: Tutte la nazionalità sono disponibili solo selezionando
                il range di anni"
                >
                  <button type="button" name="btn" className="w-[44px] h-[44px] flex justify-center items-center">
                    <AiOutlineInfoCircle />
                  </button>
                </div>
              </div>

              <select
                id="nationality"
                className="text-white mb-5 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-[200px] p-2.5 cursor-pointer"
              >
                <option value="WORLD">Tutte le nazionalità</option>
                <option value="WRL_X_ITA">Tutti - Italia esclusa -</option>
                <option value="IT">Italia</option>
                {periodDisabled && (
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
                )}
              </select>

              <div>
                <label htmlFor="nationality" className="font-medium text-gray-900">
                  <div className="inline mr-1">Provincia</div>
                </label>
                <div
                  className="tooltip tooltip-top relative top-[3px]"
                  data-tip="Nota: Le province (Olbia-Tempio, Ogliastra, Medio Campidano, Carbonia-Iglesias) non sono disponibili per anni successivi al 2016"
                >
                  <button type="button" name="btn" className="w-[44px] h-[44px] flex justify-center items-center">
                    <AiOutlineInfoCircle />
                  </button>
                </div>
              </div>
              {props.page === "statistiche" ? (
                <select
                  id="province"
                  className="text-white mb-14 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-[200px] p-2.5 cursor-pointer"
                  value={province}
                  onChange={handleProvinceOnChange}
                >
                  <option value="ITG2">Tutte le province</option>
                  <option value="ITG25">Sassari</option>
                  <option value="ITG26">Nuoro</option>
                  <option value="ITG27">Cagliari</option>
                  <option value="ITG28">Oristano</option>
                  <option value="ITG29">Olbia-Tempio</option>
                  <option value="ITG2A">Ogliastra</option>
                  <option value="ITG2B">Medio Campidano</option>
                  <option value="ITG2C">Carbonia-Iglesias</option>
                  <option value="IT111">Sud Sardegna</option>
                </select>
              ) : (
                <select
                  id="province"
                  className="text-white mb-14 mt-2 bg-gray-700 border border-gray-600 rounded-lg block w-[200px] p-2.5 cursor-pointer"
                  value={province}
                  onChange={handleProvinceOnChange}
                >
                  <option value="ITG2">Tutte le province</option>
                  <option value="ITG25">Sassari</option>
                  <option value="ITG26">Nuoro</option>
                  <option value="ITG27">Cagliari</option>
                  <option value="ITG28">Oristano</option>
                  <option value="IT111">Sud Sardegna</option>
                </select>
              )}
            </div>
          </form>
        </aside>
      </div>
    </>
  );
};

export default Sidebar;
