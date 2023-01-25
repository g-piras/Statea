import Link from "next/link"
import { FaGithub } from "react-icons/fa";

export const Footer = () => {
  return (
    <>
      <div className="bg-[#284697] flex justify-between px-5 py-10 mt-36 items-center">
        <div className="w-[50%] h-full text-center ">
          <div className="flex-col">
            <ul className="uppercase">
              <Link href="/">
                <li className="md:py-2 pb-[14px] text-sm ">
                  <span
                    className="border-b border-transparent hover:border-black text-sky-50 uppercase"
                  >
                    Home
                  </span>
                </li>
              </Link>
              <Link href="/statistiche">
                <li className="md:py-2 py-[14px] text-sm ">
                  <span
                    className="border-b border-transparent hover:border-black text-sky-50"
                  >
                    Statistiche
                  </span>
                </li>
              </Link>
              <Link href="/previsioni">
                <li className="md:py-2 py-[14px] text-sm ">
                  <span
                    className="border-b border-transparent hover:border-black text-sky-50"
                  >
                    Previsioni
                  </span>
                </li>
              </Link>
              <Link href="/about">
                <li className="md:py-2 py-[14px] text-sm ">
                  <span
                    className="border-b border-transparent hover:border-black text-sky-50"
                  >
                    About
                  </span>
                </li>
              </Link>
            </ul>
          </div>

        </div>
        <div className="w-full h-full md:flex flex-col items-center hidden">
          <img className="w-[90px] h-[90px] md:w-[170px] md:h-[170px] my-2  " src="/assets/statea2.png" alt="Logo" />
        </div>

        <div className=" h-full flex flex-col items-center w-[50%]">
          <p className="uppercase tracking-widest text-sky-50 text-sm md:text-base text-center">
            <span>Let's</span> Connect
          </p>
          <div className="flex items-center justify-center my-4 w-full min-[480px]:w-[80%]">
            <Link href="https://github.com/KelosDev/Statea" target="_blank" >
              <div className=" rounded-full bg-sky-50 shadow-lg shadow-gray-400 p-3 cursor-pointer hover:scale-105 ease-in duration-300 ">
                <FaGithub />
              </div>
            </Link>
          </div>
          <div>
            <p className="text-sky-50 text-center">
              SEDE OPERATIVA <br></br>
              Torino, via Jacopo Durandi 10 <br></br>
              <a href="#">statea@gmail.com</a>
            </p>
          </div>
        </div>
      </div>
    </>
  );
};
