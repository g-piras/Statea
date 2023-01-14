import React, { useState } from 'react';

const prova = () => {

    const [checked, setChecked] = useState('first-checkbox')


    return (
        <div>
            <input
                type='checkbox'
                checked={checked === 'first-checkbox'}
                onChange={() => setChecked('first-checkbox')}
            />

            {
                checked === 'first-checkbox' ? (<h1>mostra</h1>) : (<h1>nascondi</h1>)
            }

            <input
                type='checkbox'
                checked={checked === 'second-checkbox'}
                onChange={() => setChecked('second-checkbox')}
            />
            <input
                type='checkbox'
                checked={checked === 'third-checkbox'}
                onChange={() => setChecked('third-checkbox')}
            />
        </div>
    );
};

export default prova;