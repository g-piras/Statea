import React from 'react';
import Navbar from '../components/Navbar';

const statistiche = () => {
    return (
        <>
            <Navbar page="statistiche" />
            <div className='"w-full h-full flex justify-center pt-20'>
                <h1 className='uppercase'><span className="text-[#284697]">Statis</span>
                    <span className="text-[#00ACC1]">tiche</span></h1>
            </div>
        </>
    );
};

export default statistiche;