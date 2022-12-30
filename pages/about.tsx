import React from "react";
import Navbar from "../components/Navbar";

const about = () => {
    return (
        <>
            <Navbar page="about" />
            <div className='"w-full h-full flex justify-center pt-20'>
                <h1 className="uppercase">
                    <span className="text-[#284697]">Ab</span>
                    <span className="text-[#00ACC1]"><span className="half" title="O">o</span>ut</span>
                </h1>
            </div>
        </>
    );
};

export default about;
