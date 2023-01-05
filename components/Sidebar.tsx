import React, { useState } from 'react';
import { AiOutlineClose } from 'react-icons/ai';

const Sidebar = (props: { open: boolean }) => {

    // const [side, setSide] = useState(props.open)

    // const handleSide = () => {
    //     setSide(!side)
    // }


    return (
        <>
            <div className={
                props.open
                    ? " bg-red-500 my-[80px] fixed left-0 top-0 'bg-white w-[400px] min-h-screen flex flex-col ease-in duration-500"
                    : " fixed left-[-100%] top-0 'bg-white w-64 min-h-screen flex flex-col ease-in duration-500"
            } >
                <aside>
                    <span className='text-center uppercase'>Filtra</span>
                </aside>

            </div>


        </>
    );
};

export default Sidebar;