import React, { useState } from 'react';
import Navbar from '../components/Navbar';
import Sidebar from '../components/Sidebar';


const statistiche = () => {

    const [side, setSide] = useState(false)

    const handleSide = () => {
        setSide(!side)
    }

    return (
        <>
            <Navbar page="statistiche" />
            <div className=''>
                <Sidebar open={side} />
                <h1 className='uppercase pt-20 text-center '><span className="text-[#284697]">Stati<span className="half" title="S">s</span></span>
                    <span className="text-[#00ACC1]">tiche</span></h1>
                <div className='flex justify-center my-5'>
                    <button onClick={handleSide} className="  uppercase mb-10 bg-transparent hover:bg-blue-500 text-blue-700 font-semibold hover:text-white py-2 px-4 border border-blue-500 hover:border-transparent rounded">
                        filtra
                    </button>

                </div>
            </div>
        </>
    );
};

export default statistiche;