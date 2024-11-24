import React from 'react';
import { GoHome } from "react-icons/go";
import { IoIosSearch } from "react-icons/io";
import { CgAddR } from "react-icons/cg";
import { FaHeart } from "react-icons/fa6";
import { MdAccountCircle } from "react-icons/md";



const SnsButton = () => {
    return (
        <div style={{
            fontSize:"30px",
            display:"flex",
            justifyContent:"space-between"
            }}>
            <GoHome />
            <IoIosSearch />
            <CgAddR />
            <FaHeart />
            <MdAccountCircle />

        </div>
    );
};

export default SnsButton;