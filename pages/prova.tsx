import React, { useState } from 'react';

const prova = () => {

    const [checked, setChecked] = useState('first-checkbox')


    return (
        <div className='mt-[400px]'>

            <div className="tooltip" data-tip="hello">
                <button className="btn">Hover me</button>
            </div>

        </div>

    );
};

export default prova;