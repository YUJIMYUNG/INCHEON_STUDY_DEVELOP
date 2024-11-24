import React from 'react';
import CarNumber from './CarNumber';
import CarModel from './CarModel';
import CarAge from './CarAge';

const CarCard = (props) => {
    return (
        <div style={{display:'flex', flexDirection:"column"}}>
            <div style={{display:'flex', alignContent:'space-between'}}>
                <CarNumber></CarNumber>
            </div>

            <div style={{display:'flex', alignContent:'space-between'}}>
                <CarModel></CarModel>
            </div>

            <div style={{display:'flex', alignContent:'space-between'}}>
                <CarAge></CarAge>
            </div>
        </div>
    );
};

export default CarCard;