import React from 'react';
import Navbar from '../components/Navbar';

const previsioni = () => {
    return (
        <>
            <Navbar page="previsioni" />
            <div className='"w-full h-full flex justify-center pt-20'>
                <h1 className='uppercase'><span className="text-[#284697]">Prev<span className="half" title="is">is</span></span>
                    <span className="text-[#00ACC1]">ioni</span></h1>
            </div>
        </>
    );
};

export default previsioni;