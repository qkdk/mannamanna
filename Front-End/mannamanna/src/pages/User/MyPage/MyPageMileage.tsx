import React from 'react';
import styled from 'styled-components'
import {MileageBox, LeftStyle, RightStyle} from './MyPageStyle';

let Hello = styled.div`
 border: solid 7px black;
  border-radius:20px;
  display: flex;
  flex-direction: column;
//   justify-content: center;
//   align-items: center;
  ` 


function MyPageMiileage() {
    return (
        <Hello style={{width:'50%',height:'80%',overflow: 'auto'}}>
            <UseMileage/>
            <GetMileage/>
            <UseMileage/>
            <GetMileage/>
            <UseMileage/>
            <GetMileage/>
        </Hello>
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