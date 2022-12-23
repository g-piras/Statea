import Link from "next/link";
import React from "react";
import BarChart from "./BarChart";
import { faker } from "@faker-js/faker";

const Main = () => {
  const labels = [
    "January",
    "February",
    "March",
    "April",
    "May",
    "June",
    "July",
  ];

  return (
    <div className="w-full h-full flex justify-center pt-20">
      <div className="text-center">
        <p className="uppercase text-sm tracking-widest text-gray-600 mt-10">
          Dai uno sguardo alle nostre statistiche
        </p>
        <h1 className="text-gray-800 uppercase my-10">
          Benvenuti in <span className="text-[#284697]">Touri</span>
          <span className="text-[#00ACC1]">Stats</span>
        </h1>
        <p className="text-gray-600 mx-auto max-w-[70%] tracking-wide ">
          <span className="text-[#284697] text-xl">Touri</span>
          <span className="text-[#00ACC1] text-xl">Stats </span>è un servizio
          web dedicato all'analisi del flusso turistico in{" "}
          <span className="uppercase font-bold"> Sardegna </span>
          <br />
          Basato su dataset ufficiali Istat, forniamo statistiche e previsioni
          sui flussi di turisti italiani e stranieri verso le regione
        </p>
        <div className="text-center text-gray-700">
          <h2 className="my-10">Statistiche anno corrente</h2>
          <div className="w-3/4 mt-16 mb-12 mx-auto">
            <BarChart
              data={{
                labels: labels,
                datasets: [
                  {
                    data: labels.map(() =>
                      faker.datatype.number({ min: 20000, max: 100000 })
                    ),
                    backgroundColor: "#284697",
                  },
                ],
              }}
            />
          </div>
          <button className="mb-16 bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded">
            <Link href="./">Vai a Statistiche</Link>
          </button>
          <h2 className="mb-10">Previsioni anno successivo</h2>
          <div className="w-3/4 mt-16 mb-12 mx-auto">
            <BarChart
              data={{
                labels: labels,
                datasets: [
                  {
                    data: labels.map(() =>
                      faker.datatype.number({ min: 20000, max: 100000 })
                    ),
                    backgroundColor: "#00ACC1",
                  },
                ],
              }}
            />
          </div>
          <button className="mb-10 bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded">
            <Link href="./">Vai a Previsioni</Link>
          </button>
        </div>
      </div>
    </div>
  );
};

export default Main;
