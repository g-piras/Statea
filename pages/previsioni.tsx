import React, { useEffect, useState } from "react";
import BarChart from "../components/BarChart";
import Navbar from "../components/Navbar";
import Sidebar from "../components/Sidebar";
import { labels, data } from "../components/BarChart";
import { Footer } from "../components/Footer";
import Head from "next/head";
import { annualApiForecast } from "../api";

const previsioni = () => {
  const [side, setSide] = useState<boolean>(false);
  const [touristsNumber, setTouristsNumber] = useState<string[]>([]);
  const [years, setYears] = useState<string[]>([]);
  const [nationality, setNationality] = useState<string>("WORLD");
  const [province, setProvince] = useState<string>("ITG2");
  const [year, setYear] = useState<undefined | string>(undefined);
  const [firstSelectMonth, setFirstSelectMonth] = useState<undefined | string>(undefined);
  const [firstSelectYear, setFirstSelectYear] = useState<undefined | string>(undefined);
  const [secondSelectMonth, setSecondSelectMonth] = useState<undefined | string>(undefined);
  const [secondSelectYear, setSecondSelectYear] = useState<undefined | string>(undefined);
  const [yearStartRange, setYearStartRange] = useState<undefined | string>("2008");
  const [yearEndRange, setYearEndRange] = useState<undefined | string>("2021");

  useEffect(() => {
    annualApiForecast(nationality, province, 'AR', yearStartRange).then((res) => {
      setTouristsNumber(res.data)
      setYears(res.labels)
    })
  }, [])

  const handleSidebar = () => {
    setSide(!side)
  };

  return (
    <>
      <Navbar page="previsioni" />
      <Head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
        <meta name="description" content="Con Touristats puoi analizzare il flusso dei turisti in Sardegna grazie a statistiche e previsioni" />
        <link rel="icon" href="/assets/touristats-logo.jpg" />
        <title>Previsioni - TouriStats</title>
      </Head>

      <div>
        <Sidebar
          side={side}
          page="previsioni"
          handleSidebar={handleSidebar}
          handleSaveFilters={() => { }}
        />
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
            className="uppercase my-10 bg-transparent text-blue-700 font-semibold py-2 px-4 border border-blue-500 rounded disabled:opacity-40"
            name="btn"
          >
            filtra
          </button>
        </div>
      </div>
      <div className="chart">
        <BarChart
          data={{
            labels: labels,
            datasets: [
              {
                data: data,
                backgroundColor: "#00ACC1",
              },
            ],
          }}
        />
      </div>
      <Footer />
    </>
  );
};

export default previsioni;
