import Head from "next/head";
import React from "react";
import { Footer } from "../components/Footer";
import Navbar from "../components/Navbar";

const about = () => {
  return (
    <>
      <Head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1"></meta>
        <meta name="description" content="Con Touristats puoi analizzare il flusso dei turisti in Sardegna grazie a statistiche e previsioni" />
        <link rel="icon" href="/assets/touristats-logo.jpg" />
        <title>About - TouriStats</title>
      </Head>
      <Navbar page="about" />
      <div className="w-full h-full text-center pt-[120px]">
        <section className="w-full h-full text-gray-800">
          <h1 className="uppercase my-10 px-10">
            <span className="text-[#284697]">Ab</span>
            <span className="text-[#00ACC1]">
              <span className="half" title="O">
                o
              </span>
              ut
            </span>
          </h1>
          <p className="tracking-wide text-gray-600 mx-auto max-w-[70%] pt-10 text-lg text-justify text-last-center">
            Benvenuti in{" "}
            <span className="font-bold uppercase">Statea</span>. Siamo un'azienda che
            sviluppa siti e applicazioni per il web, basati su dati ISTAT,
            per il settore del turismo. Siamo orgogliosi di offrire soluzioni
            che consentano di monitorare e analizzare in modo{" "}
            <span className="font-bold uppercase">semplice</span> e{" "}
            <span className="font-bold uppercase"> intuitivo</span> l'affluenza
            dei turisti in diverse aree della Sardegna, così come previsioni su come
            cambieranno in futuro.
          </p>
          <h3 className="uppercase text-gray-800 mt-[100px] mb-1 px-10 text-2xl">
            con i nostri prodotti ...
          </h3>
          <p className="tracking-wide text-gray-600 mx-auto max-w-[70%] pt-10 text-lg text-justify text-last-center">
            ... ci poniamo l'obiettivo di{" "}
            <span className="font-bold uppercase">aiutare</span> le aziende che operano nel
            settore turistico a{" "}
            <span className="font-bold uppercase">comprendere</span> e sfruttare
            al meglio i dati e le previsioni presenti all'interno delle{" "}
            nostre Web-App per
            migliorare il loro{" "}
            <span className="font-bold uppercase">business</span>.
          </p>

          <h3 className="uppercase text-gray-800 mt-[100px] mb-1 px-10 text-2xl">
            Con noi ...
          </h3>
          <p className="tracking-wide text-gray-600 mx-auto max-w-[70%] pt-10 text-lg text-justify text-last-center">
            ... troverai terreno fertile in cui potrai dar vita alle tue <span className="font-bold uppercase"> idee</span>.
            Verrai seguito passo dopo passo nella realizzazione del tuo <span className="font-bold uppercase"> prodotto</span>.
            Con il nostro team non ci sono limiti all'immaginazione.
            Vieni a conoscerci
          </p>

          <h2 className="uppercase text-gray-800 mt-[120px] mb-10 lg:mb-[-55px] px-10">
            noi siamo
          </h2>
        </section>

        <section className="w-full h-full mb-[160px]">
          <div className=" lg:pt-36 relative">
            <div className="grid md:grid-cols-2 sm:grid-cols-1 gap-10 row-gap-8 mx-auto sm:row-gap-10 lg:max-w-screen-lg lg:grid-cols-3">

              <div className="relative lg:top-[39px] lg:left-[60px] transition transform delay-150 lg:hover:scale-150 ">
                <div className="flex flex-col items-center">
                  <img
                    className="object-cover w-28 h-28 rounded-full shadow"
                    src="/assets/sebastiano.jpg"
                    alt="Sebastiano"
                  />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold ">Sebastiano Demichelis</p>
                    <p className="text-sm text-gray-800 text-center">
                      Front-End Developer
                    </p>
                  </div>
                </div>
              </div>

              <div className="relative lg:top-[-37px] transition transform delay-150 order-first md:order-none lg:active:animate-rotate-infinite lg:hover:scale-150">
                <div className="flex flex-col items-center">
                  <img
                    className="object-cover w-28 h-28 rounded-full shadow "
                    src="/assets/Joele.jpg"
                    alt="Joele"
                  />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold ">Joele Melchiorre</p>
                    <p className="text-sm text-gray-800 text-center">
                      Front-End Developer <br />
                      Team Leader
                    </p>
                  </div>
                </div>
              </div>

              <div className="relative lg:top-[39px] lg:left-[-60px] transition transform delay-150 lg:hover:scale-150">
                <div className="flex flex-col items-center">
                  <img
                    className="object-cover w-28 h-28 rounded-full shadow"
                    src="/assets/Federico.jpg"
                    alt="Federico"
                  />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold ">
                      Federico Luciano Stroppiana
                    </p>
                    <p className="text-sm text-gray-800 text-center">
                      Front-End Developer
                    </p>
                  </div>
                </div>
              </div>

              <div className="relative lg:left-[30px] flex flex-col justify-center lg:w-[150px] transition transform delay-150 lg:hover:scale-150">
                <div className="flex flex-col items-center">
                  <img
                    className="object-cover w-28 h-28 rounded-full shadow"
                    src="/assets/giampietro.jpg"
                    alt="Giampietro"
                  />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold ">Giampietro Piras</p>
                    <p className="text-sm text-gray-800 text-center">
                      Front-End Developer
                    </p>
                  </div>
                </div>
              </div>

              <div className="lg:flex lg:justify-center hidden lg:hover:animate-rotate-360">
                <img
                  className="object-cover w-150 h-150"
                  src="/assets/statea1.png"
                  alt="Logo"
                />
              </div>

              <div className="relative flex flex-col justify-center lg:w-[150px] lg:left-[135px] transition transform delay-150 lg:hover:scale-150">
                <div className="flex flex-col items-center ">
                  <img
                    className="object-cover w-28 h-28 rounded-full shadow"
                    src="/assets/Emilio.jpg"
                    alt="Emilio"
                  />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold ">Emilio Gasbarro</p>
                    <p className="text-sm text-gray-800 text-center">
                      Back-End Developer
                    </p>
                  </div>
                </div>
              </div>

              <div className="relative lg:top-[-39px] transition transform delay-150 lg:hover:scale-150">
                <div className="flex flex-col items-center relative lg:left-[54px]">
                  <img
                    className="object-cover w-28 h-28 rounded-full shadow"
                    src="/assets/matteo2.jpg"
                    alt="Matteo"
                  />
                  <div className=" relative flex flex-col justify-center">
                    <p className="text-lg font-bold ">Matteo Taricco</p>
                    <p className="text-sm text-gray-800 text-center">
                      Back-End Developer
                    </p>
                  </div>
                </div>
              </div>

              <div className="relative lg:bottom-[-30px] transition transform delay-150 lg:hover:scale-150">
                <div className="flex flex-col items-center">
                  <img
                    className="object-cover w-28 h-28  rounded-full shadow"
                    src="/assets/fabio.png"
                    alt="Fabio"
                  />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold">Fabio Leoni</p>
                    <p className="text-sm text-gray-800">Fintech Developer</p>
                  </div>
                </div>
              </div>

              <div className="relative lg:top-[-39px] transition transform delay-150 lg:hover:scale-150">
                <div className="flex flex-col items-center relative lg:left-[-54px]">
                  <img
                    className="object-cover w-28 h-28 rounded-full shadow"
                    src="/assets/Matteo.jpg"
                    alt="Matteo"
                  />
                  <div className="relative lg:left-[-39px]flex flex-col justify-center">
                    <p className="text-lg font-bold ">Matteo Drago</p>
                    <p className="text-sm text-gray-800 text-center">
                      Fintech Developer
                    </p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
      <Footer />
    </>
  );
};

export default about;
