import React from 'react';

const Main = () => {
    return (
        <div className='w-full h-screen text-center'>
            <div className='max-w[1240px] w-full h-full mx-auto flex justify-center items-center'>
                <div>
                    <p className='uppercase text-sm tracking-widest text-gray-600'>Dai uno sguardo alle nostre statistiche</p>
                    <h1 className='py-5 text-gray-800 uppercase'>
                        BENVENUTI in <span className='text-[#284697]'>Touri</span><span className='text-[#00ACC1]'>Stats</span>
                    </h1>
                    <p className='text-gray-600 max-w-[70%] m-auto tracking-wide'>
                        <span className='text-[#284697] text-xl'>Touri</span><span className='text-[#00ACC1] text-xl'>Stats </span>
                        è un servizio web dedicato all'analisi del flusso turistico in <span className='uppercase font-bold'> Sardegna </span>
                        <br />
                        Basato su dataset ufficiali Istat,
                        forniamo statistiche e previsioni sui flussi di turisti italiani e stranieri verso le regione
                    </p>
                </div>
            </div>
        </div>
    );
};

export default Main;