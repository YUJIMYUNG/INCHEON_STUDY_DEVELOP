import React from 'react';
import Info from './Info';

const InfoList = () => {
    return (
        <div>
            <Info model={"니로EV"} isConfirm={false} carNumber={"48로 5682"}/>
            <Info model={"카니발"} isConfirm={true} carNumber={"48로 5682"}/>
            <Info model={"쏘렌토"} isConfirm={true} carNumber={"48로 5682"}/>
            <Info model={"쏘렌토"} isConfirm={true} carNumber={"48로 5682"}/>
        </div>
    );
};

export default InfoList;