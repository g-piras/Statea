import React from "react";
import { Footer } from "../components/Footer";
import Navbar from "../components/Navbar";

const about = () => {
  return (
    <>
      <Navbar page="about" />
      <div className="w-full h-full text-center pt-20">
        <section className="w-full h-full text-center lg:px-24 text-gray-800">
          <h1 className="uppercase my-10 px-10">
            <span className="text-[#284697]">Ab</span>
            <span className="text-[#00ACC1]">
              <span className="half" title="O">
                o
              </span>
              ut
            </span>
          </h1>
          <p className="tracking-wide text-gray-600 mx-auto max-w-[70%] pt-10">
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Quo assumenda iusto sequi officiis earum odit quas officia! Fugit minus odit iusto eveniet error excepturi, rem molestiae impedit quisquam fugiat dolor!
            <br />
            Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dolor similique obcaecati impedit minus. Deserunt reprehenderit similique voluptatum. Quisquam adipisci provident sed sequi eius debitis, eveniet fuga qui at nostrum consequatur.
          </p>
          <h2 className="uppercase text-gray-800 my-20 px-10">
            the Team
          </h2>
        </section>

        <section className="w-full h-full mb-[160px]">
          <div className=" lg:pt-36 relative">
            <div className="grid md:grid-cols-2 sm:grid-cols-1 gap-10 row-gap-8 mx-auto sm:row-gap-10 lg:max-w-screen-lg lg:grid-cols-3">

              <div className="relative lg:left-[39px] transition transform delay-150 hover:scale-150">
                <div className="flex flex-col items-center">
                  <img className="object-cover w-20 h-20 rounded-full shadow" src="https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=3&amp;h=750&amp;w=1260" alt="Person" />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold ">Sebastiano Demichelis</p>
                    <p className="text-sm text-gray-800 text-center">Front-End Developer</p>
                  </div>
                </div>
              </div>

              <div className="relative lg:top-[-100px] transition transform delay-150 hover:scale-150">
                <div className="flex flex-col items-center">
                  <img className="object-cover w-20 h-20 rounded-full shadow " src="https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=3&amp;h=750&amp;w=1260" alt="Person" />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold ">Joele Melchiorre</p>
                    <p className="text-sm text-gray-800 text-center">Front-End Developer <br />Team Leader</p>
                  </div>
                </div>
              </div>

              <div className="relative transition transform delay-150 hover:scale-150">
                <div className="flex flex-col items-center">
                  <img className="object-cover w-20 h-20 rounded-full shadow" src="https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=3&amp;h=750&amp;w=1260" alt="Person" />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold ">Federico Luciano Stroppiana</p>
                    <p className="text-sm text-gray-800 text-center">Front-End Developer</p>
                  </div>
                </div>
              </div>

              <div className="relative flex flex-col justify-center lg:w-[150px] transition transform delay-150 hover:scale-150 ">
                <div className="flex flex-col items-center">
                  <img className="object-cover w-20 h-20 rounded-full shadow" src="https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=3&amp;h=750&amp;w=1260" alt="Person" />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold ">Giampietro Piras</p>
                    <p className="text-sm text-gray-800 text-center">Front-End Developer</p>
                  </div>
                </div>
              </div>

              <div className="lg:flex lg:justify-center hidden hover:animate-rotate-360 ">
                <img className="object-cover w-150 h-150  " src="/assets/statea2.png" alt="Logo" />
              </div>

              <div className="relative flex flex-col justify-center lg:w-[150px] lg:left-[159px] transition transform delay-150 hover:scale-150">
                <div className="flex flex-col items-center ">
                  <img className="object-cover w-20 h-20 rounded-full shadow" src="https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=3&amp;h=750&amp;w=1260" alt="Person" />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold ">Emilio Gasbarro</p>
                    <p className="text-sm text-gray-800 text-center">Back-End Developer</p>
                  </div>
                </div>
              </div>

              <div className="relative transition transform delay-150 hover:scale-150">
                <div className="flex flex-col items-center">
                  <img className="object-cover w-20 h-20 rounded-full shadow" src="https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=3&amp;h=750&amp;w=1260" alt="Person" />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold ">Matteo Taricco</p>
                    <p className="text-sm text-gray-800 text-center">Back-End Developer</p>
                  </div>
                </div>
              </div>

              <div className="relative lg:bottom-[-100px] transition transform delay-150 hover:scale-150">
                <div className="flex flex-col items-center">
                  <img className="object-cover w-20 h-20  rounded-full shadow" src="https://images.pexels.com/photos/774909/pexels-photo-774909.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=3&amp;h=750&amp;w=1260" alt="Person" />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold">Fabio Leoni</p>
                    <p className="text-sm text-gray-800">Fintech Developer</p>
                  </div>
                </div>
              </div>

              <div className="relative transition transform delay-150 hover:scale-150">
                <div className="flex flex-col items-center">
                  <img className="object-cover w-20 h-20 rounded-full shadow" src="https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&amp;cs=tinysrgb&amp;dpr=3&amp;h=750&amp;w=1260" alt="Person" />
                  <div className="flex flex-col justify-center">
                    <p className="text-lg font-bold ">Matteo Drago</p>
                    <p className="text-sm text-gray-800 text-center">Fintech Developer</p>
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
