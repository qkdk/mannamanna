import React from 'react';
import MacBookBox from '../../components/common/macbookBox';
import unKnown from '../../asset/image/unknown.png';
const Soageting = () => {
    return (
        <div>
           <MacBookBox width="80vh" height="60vh" color1="#F8E3EA" color2="#ffffff" alignItems='center'>
           <img src={unKnown} alt="Start" style={{ width: '100%', height: '90%' }} />
           </MacBookBox>
        </div>
    );
};

export default Soageting;