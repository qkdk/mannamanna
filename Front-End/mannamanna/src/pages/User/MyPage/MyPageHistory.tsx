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
  &::-webkit-scrollbar {
    width: 0.5vw;
  }
  &::-webkit-scrollbar-thumb {
    border-radius: 3px;
    background: #d9cff4;
  }
` 
  


function MyPageHistory() {
    return (
        <Hello style={{width:'50%',height:'80%',overflow: 'auto'}}>
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
        </Hello>
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