import Head from "next/head";
import Link from "next/link";
import BarChart from "../components/BarChart";
import { Footer } from "../components/Footer";
import Navbar from "../components/Navbar";
import { useEffect, useState } from "react";
import { monthlyApi, monthlyApiForecast } from "../api";

export default function Home() {
  const [touristsNumber, setTouristsNumber] = useState<string[]>([]);
  const [months, setMonths] = useState<string[]>([]);

  const [touristsNumberForecast, setTouristsNumberForecast] = useState<string[]>([]);
  const [monthsForecast, setMonthsForecast] = useState<string[]>([]);

  useEffect(() => {
    monthlyApi("WORLD", "ITG2", "AR", "2021-01-01", "2021-12-01").then((res) => {
      setTouristsNumber(res.data);
      setMonths(res.labels);
    });
    monthlyApiForecast("WORLD", "ITG2", "AR", "2023-01-01", "2023-12-01").then((res) => {
      setTouristsNumberForecast(res.data);
      setMonthsForecast(res.labels);
    });

  }, []);

  return (
    <>
      <Head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
        <meta name="description" content="Con Touristats puoi analizzare il flusso dei turisti in Sardegna grazie a statistiche e previsioni" />
        <link rel="icon" href="/assets/touristats-logo.jpg" />
        <title> HomePage - TouriStats</title>
      </Head>

      <Navbar page="home" />
      <div className="w-full h-full text-center pt-20">
        <p className="uppercase text-sm tracking-widest text-gray-600 my-10 px-10">
          Dai uno sguardo alle nostre statistiche
        </p>
        <h1 className="uppercase text-gray-800 my-10 px-10">
          Benvenuti in <span className="text-[#284697]">Touri</span>
          <span className="text-[#00ACC1]">Stats</span>
        </h1>
        <p className="tracking-wide text-lg text-gray-600 mx-auto max-w-[70%] text-last-center text-justify">
          <span className="text-[#284697] font-semibold text-xl">Touri</span>
          <span className="text-[#00ACC1] font-semibold text-xl">Stats </span>è un servizio
          web dedicato all'analisi del flusso turistico in
          <span className="uppercase font-bold"> Sardegna </span>
          <br />
          Basato su dataset ufficiali Istat, forniamo statistiche e previsioni
          sui flussi di turisti italiani e stranieri verso la regione
        </p>
        <div className="text-gray-700">
          <h2 className="mt-[50px] mb-5 px-10">Statistiche anno 2021</h2>
          <p className="mx-auto text-lg max-w-[70%] text-last-center text-justify">Quasi 2.5 milioni di turisti arrivati da tutto  il mondo nell'anno 2021</p>
          <div className="chart">
            <BarChart
              data={{
                labels: months,
                datasets: [
                  {
                    data: touristsNumber,
                    backgroundColor: "#284697",
                  },
                ],
              }}
            />
          </div>
          <Link href="/statistiche">
            <button className="mb-10 bg-transparent hover:bg-[#284697] text-[#284697] hover:text-white font-semibold py-2 px-4 border border-[#284697] hover:border-transparent rounded shadow-md shadow-[#284697]">
              Vai a Statistiche
            </button>
          </Link>
          <h2 className="mt-[50px] mb-5 px-10">Previsioni anno successivo</h2>
          <p className="mx-auto text-lg max-w-[70%] text-last-center text-justify">Prevediamo l'arrivo di circa 3.6 milioni di turisti da tutto il mondo nell'anno 2023</p>
          <div className="chart">
            <BarChart
              data={{
                labels: monthsForecast,
                datasets: [
                  {
                    data: touristsNumberForecast,
                    backgroundColor: "#00ACC1",
                  },
                ],
              }}
            />
          </div>
          <Link href="/previsioni">
            <button className="bg-transparent hover:bg-[#00ACC1] text-[#0094c1] hover:text-white font-semibold py-2 px-4 border border-[#00ACC1] hover:border-transparent rounded shadow-md shadow-[#0094c1]">
              Vai a Previsioni
            </button>
          </Link>
        </div>
      </div>
      <Footer />

    </>
  );
}
