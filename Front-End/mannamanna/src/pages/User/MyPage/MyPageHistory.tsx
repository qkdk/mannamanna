import React from 'react';
import styled from 'styled-components'
import {MileageBox, LeftStyle, RightStyle} from './MyPageStyle';
import MacBookBox from '../../../components/common/macbookBox';

function MyPageHistory() {
    return (
        <MacBookBox width="50%" height="80%" color1="#bcd3ff" color2="ffffff" alignItems='none'>
            <SogeList/>
            <MeetList/>
            <SogeList/>
            <MeetList/>
            <SogeList/>
            <MeetList/>
            <SogeList/>
            <MeetList/>
            <SogeList/>
            <MeetList/>
            <SogeList/>
            <MeetList/>
            <SogeList/>
            <MeetList/>
            <SogeList/>
            <MeetList/>
            <SogeList/>
            <MeetList/>
            <SogeList/>
            <MeetList/>
            <SogeList/>
            <MeetList/>
        </MacBookBox>
    );
 };

function SogeList(){
    return(
        <LeftStyle>
            <MileageBox>소개팅소개팅소개팅</MileageBox>
        </LeftStyle>
    );
}
function MeetList(){
    return(
        <RightStyle>
            <MileageBox>미팅미팅미팅</MileageBox>
        </RightStyle>
    );
}

 export default MyPageHistory;