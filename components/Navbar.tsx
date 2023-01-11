import Image from "next/image";
import Link from "next/link";
import React, { useEffect, useState } from "react";

import { AiOutlineClose, AiOutlineMenu, AiOutlineMail } from "react-icons/ai";
import { FaLinkedinIn, FaGithub } from "react-icons/fa";
import { BsFillPersonLinesFill } from "react-icons/bs";
import { useSelector } from "react-redux";
import { RootState, store } from "../redux/store";
import { toggleNavbar } from "../redux/NavbarSlice";

const Navbar = (props: { page: string }) => {
  const navbar = useSelector((state: RootState) => state.navbar.value);
  const sidebar = useSelector((state: RootState) => state.sidebar.value);
  const [nav, setNav] = useState(navbar);

  useEffect(() => {
    setNav(navbar);
  }, [navbar]);

  const handleNav = () => {
    if (!sidebar) {
      store.dispatch(toggleNavbar());
    }
  };

  return (
    <div className="fixed w-full h-20 shadow-xl backdrop-filter backdrop-blur-2xl">
      <div
        className={
          nav
            ? "md:hidden fixed left-0 top-0 w-full h-screen bg-black/60 ease-in duration-500"
            : ""
        }
      >
        <div
          className={`fixed z-50 top-0 w-[75%] sm:w-[60%] md:w-[45%] h-screen bg-white p-10 ease-in duration-500 ${nav ? "left-0" : "left-[-100%]"
            }`}
        >
          <div>
            <div className="flex w-full items-center justify-between">
              <Image
                src="/assets/touristats-logo.png"
                alt="/"
                width="70"
                height="70"
              />
              <div
                onClick={handleNav}
                className="rounded-full shadow-lg shadow-gray-400 p-3 cursor-pointer"
              >
                <AiOutlineClose />
              </div>
            </div>
            <div className="border-b border-gray-300 my-4 min-[480px]:w-[80%]">
              <p className="py-4 font-bold text-xl">TouriStats sections</p>
            </div>
          </div>
          <div className="py-4 flex-col">
            <ul className="uppercase">
              <Link href="/">
                <li className="py-4 text-sm ">
                  <span
                    className={`border-b border-transparent hover:border-black ${props.page === "home" ? "border-black" : ""
                      }`}
                  >
                    Home
                  </span>
                </li>
              </Link>
              <Link href="/statistiche">
                <li className="py-4 text-sm ">
                  <span
                    className={`border-b border-transparent hover:border-black ${props.page === "statistiche" ? "border-black" : ""
                      }`}
                  >
                    Statistiche
                  </span>
                </li>
              </Link>
              <Link href="/previsioni">
                <li className="py-4 text-sm ">
                  <span
                    className={`border-b border-transparent hover:border-black ${props.page === "previsioni" ? "border-black" : ""
                      }`}
                  >
                    Previsioni
                  </span>
                </li>
              </Link>
              <Link href="/about">
                <li className="py-4 text-sm ">
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
                <div className="rounded-full shadow-lg shadow-gray-400 p-3 cursor-pointer hover:scale-105 ease-in duration-300">
                  <FaLinkedinIn />
                </div>
                <div className="rounded-full shadow-lg shadow-gray-400 p-3 cursor-pointer hover:scale-105 ease-in duration-300">
                  <FaGithub />
                </div>
                <div className="rounded-full shadow-lg shadow-gray-400 p-3 cursor-pointer hover:scale-105 ease-in duration-300">
                  <AiOutlineMail />
                </div>
                <div className="rounded-full shadow-lg shadow-gray-400 p-3 cursor-pointer hover:scale-105 ease-in duration-300">
                  <BsFillPersonLinesFill />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

      <div className="flex justify-between items-center w-full h-full px-8 2xl:px-12">
        <Image
          src="/assets/touristats-logo.png"
          alt="/"
          width="60"
          height="60"
        />
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
          <div onClick={handleNav} className="md:hidden">
            <AiOutlineMenu size={25} />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Navbar;
