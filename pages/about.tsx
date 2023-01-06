import React from "react";
import Navbar from "../components/Navbar";

const about = () => {
  return (
    <>
      <Navbar page="about" />

      <div>
        <h1 className="uppercase text-center pt-32">
          <span className="text-[#284697]">Ab</span>
          <span className="text-[#00ACC1]">
            <span className="half" title="O">
              o
            </span>
            ut
          </span>
        </h1>
      </div>
    </>
  );
};

export default about;
