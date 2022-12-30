import React from 'react';
import Navbar from '../components/Navbar'

const about = () => {
    return (
        <>
            <Navbar />
            <div className='"w-full h-full flex justify-center pt-20'>
                <h1 className='uppercase'><span className="text-[#284697]">Ab</span>
                    <span className="text-[#00ACC1]">out</span></h1>
            </div>
        </>
    );
};

export default about;