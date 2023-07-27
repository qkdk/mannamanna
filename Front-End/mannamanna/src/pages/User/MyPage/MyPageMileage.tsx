import React from 'react';
import styled from 'styled-components'
import {MileageBox, LeftStyle, RightStyle} from './MyPageStyle';
import MacBookBox from '../../../components/common/macbookBox';

function MyPageMiileage() {
    return (
        <MacBookBox width="60%" height="90%" color1="#bcd3ff" color2="#ffffff" alignItems='center'>
            <UseMileage/>
            <GetMileage/>
            <UseMileage/>
            <GetMileage/>
            <UseMileage/>
            <GetMileage/>
        </MacBookBox>
    );
 };

function UseMileage(){
    return(
        <LeftStyle>
            시간시간시간
            <MileageBox>-50 Point 쪽지 보내기</MileageBox>
        </LeftStyle>
    );
}
function GetMileage(){
    return(
        <RightStyle>
            시간시간시간
            <MileageBox>+50 Point 미션 참여</MileageBox>
        </RightStyle>
    );
}



  
 export default MyPageMiileage;