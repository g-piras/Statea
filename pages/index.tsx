import Head from "next/head";
import Link from "next/link";
import BarChart from "../components/BarChart";
import { Footer } from "../components/Footer";
import Navbar from "../components/Navbar";
import { labels, data } from "../components/BarChart";
import { useEffect, useState } from "react";
import { monthlyApi } from "../api";

export default function Home() {
  const [touristsNumber, setTouristsNumber] = useState<string[]>([]);
  const [months, setMonths] = useState<string[]>([]);

  useEffect(() => {
    monthlyApi("WORLD", "ITG2", "AR", "2021-01-01", "2021-12-01").then((res) => {
      setTouristsNumber(res.data);
      setMonths(res.labels);
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
        <p className="tracking-wide text-gray-600 mx-auto max-w-[70%]">
          <span className="text-[#284697] text-xl">Touri</span>
          <span className="text-[#00ACC1] text-xl">Stats </span>è un servizio
          web dedicato all'analisi del flusso turistico in
          <span className="uppercase font-bold"> Sardegna </span>
          <br />
          Basato su dataset ufficiali Istat, forniamo statistiche e previsioni
          sui flussi di turisti italiani e stranieri verso la regione
        </p>
        <div className="text-gray-700">
          <h2 className="mt-10 mb-14 px-10">Statistiche anno 2021</h2>
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
            <button className="mb-10 bg-transparent hover:bg-blue-500 text-blue-700  hover:text-white font-semibold py-2 px-4 border border-blue-500 hover:border-transparent rounded">
              Vai a Statistiche
            </button>
          </Link>
          <h2 className="mt-10 mb-14 px-10">Previsioni anno successivo</h2>
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
          <Link href="/previsioni">
            <button className="bg-transparent hover:bg-blue-500 text-blue-700 hover:text-white font-semibold py-2 px-4 border border-blue-500 hover:border-transparent rounded">
              Vai a Previsioni
            </button>
          </Link>
        </div>
      </div>
      <Footer />

    </>
  );
}
