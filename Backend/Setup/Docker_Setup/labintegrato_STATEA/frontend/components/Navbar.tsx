import Image from "next/image";
import Link from "next/link";
import React, { useState } from "react";

import { AiOutlineClose, AiOutlineMenu, AiOutlineMail } from "react-icons/ai";
import { FaGithub } from "react-icons/fa";

const Navbar = (props: { page: string }) => {
  const [nav, setNav] = useState(false);

  const handleNav = () => {
    setNav(!nav)
  };

  return (

    <div className="fixed z-50 w-full h-20 shadow-xl backdrop-filter backdrop-blur-2xl">
      <div
        className={
          nav
            ? "md:hidden fixed left-0 top-0 w-full h-screen bg-black/60 ease-in duration-500"
            : ""
        }
      >
        <div
          className={`fixed landscape:overflow-y-scroll top-0 w-[75%] sm:w-[60%] md:w-[45%] h-screen bg-white p-10 ease-in duration-500 ${nav ? "left-0" : "left-[-100%]"
            }`}
        >
          <div>
            <div className="flex w-full items-center justify-between">
              <Link href="/">
                <Image
                  src="/assets/touristats-logo.png"
                  alt="Touristats Logo"
                  width="70"
                  height="70"
                />
              </Link>
              <div
                onClick={handleNav}
                className="rounded-full shadow-lg shadow-gray-400 p-3 cursor-pointer"
              >
                <AiOutlineClose />
              </div>
            </div>
            <div className="border-b border-gray-300 my-4 min-[480px]:w-[80%]">
              <p className="py-4 text-lg"><span className="text-[#284697] text-2xl font-bold">Touri</span>
                <span className="text-[#00ACC1] text-2xl font-bold">Stats</span> section</p>
            </div>
          </div>
          <div className="py-6 flex-col">
            <ul className="uppercase">
              <Link href="/">
                <li className="py-4">
                  <span
                    className={`border-b border-transparent hover:border-black ${props.page === "home" ? "border-black" : ""
                      }`}
                  >
                    Home
                  </span>
                </li>
              </Link>
              <Link href="/statistiche">
                <li className="py-4">
                  <span
                    className={`border-b border-transparent hover:border-black ${props.page === "statistiche" ? "border-black" : ""
                      }`}
                  >
                    Statistiche
                  </span>
                </li>
              </Link>
              <Link href="/previsioni">
                <li className="py-4">
                  <span
                    className={`border-b border-transparent hover:border-black ${props.page === "previsioni" ? "border-black" : ""
                      }`}
                  >
                    Previsioni
                  </span>
                </li>
              </Link>
              <Link href="/about">
                <li className="py-4">
                  <span
                    className={`border-b border-transparent hover:border-black ${props.page === "about" ? "border-black" : ""
                      }`}
                  >
                    About
                  </span>
                </li>
              </Link>
            </ul>
            <div className="pt-24">
              <p className="uppercase tracking-widest text-[#284697]">
                Let's Connect
              </p>
              <div className="flex items-center justify-between my-4 w-full min-[480px]:w-[80%]">
                <Link href="https://github.com/KelosDev/Statea" target="_blank">
                  <div className="rounded-full shadow-lg shadow-gray-400 p-3 cursor-pointer hover:scale-105 ease-in duration-300">
                    <FaGithub />
                  </div>
                </Link>
              </div>
            </div>
          </div>
        </div>
      </div>
      {/* desktop*/}
      <div className="flex justify-between items-center w-full h-full px-8 2xl:px-12">
        <Link href="/">
          <Image
            src="/assets/touristats-logo.png"
            alt="Touristats Logo"
            width="70"
            height="70"
          />
        </Link>
        <div>
          <ul className="hidden uppercase md:flex">
            <Link href="/">
              <li
                className={`ml-10 text-sm border-b border-transparent hover:border-black ${props.page === "home" ? "border-black" : ""
                  }`}
              >
                Home
              </li>
            </Link>
            <Link href="/statistiche">
              <li
                className={`ml-10 text-sm border-b border-transparent hover:border-black ${props.page === "statistiche" ? "border-black" : ""
                  }`}
              >
                Statistiche
              </li>
            </Link>
            <Link href="/previsioni">
              <li
                className={`ml-10 text-sm border-b border-transparent hover:border-black ${props.page === "previsioni" ? "border-black" : ""
                  }`}
              >
                Previsioni
              </li>
            </Link>
            <Link href="/about">
              <li
                className={`ml-10 text-sm border-b border-transparent hover:border-black ${props.page === "about" ? "border-black" : ""
                  }`}
              >
                About
              </li>
            </Link>
          </ul>
          <div onClick={handleNav} className="md:hidden cursor-pointer">
            <AiOutlineMenu size={25} />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Navbar;
