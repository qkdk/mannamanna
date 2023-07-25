import styled from 'styled-components';
import React, { ReactNode } from 'react';

interface MacBookBoxProps{
  children:ReactNode;
}

function MacBookBox({children} :MacBookBoxProps) {
  let MacBox = styled.div`
 border: solid 7px black;
  width: 700px;
  height: 800px;
  border-radius:40px;
  // display: flex;
  // justify-content: center;
  // align-items: center;
  `
let UpBox = styled.div `
border-bottom: solid 5px black;
width: 700px;
height: 80px;
border-top-left-radius:  35px;
border-top-right-radius: 35px;
background-color: #bcd3ff;
display: flex;
align-items: center;
justify-Content: end;
`
let MidBox = styled.div`
width: 700px;
height:640px;
background-color:#ffffff;
`
let BottomBox = styled.div`
border-top: solid 5px black;
width: 700px;
height: 70px;
border-bottom-left-radius:  35px;
border-bottom-right-radius: 35px;
background-color: #bcd3ff;
`

let MacBtnContainer = styled.div`
width : 110px;
height : 40px;
display: flex;
justify-content: space-around;
align-items: center;
// border: solid 1px black;
margin-right: 10px;
`


interface MacBtnProps {
  bg: string;
}

const MacBtn = styled.div<MacBtnProps>`
  background: ${props => props.bg};
  width: 30px;
  height: 30px;
  border-radius: 50%;
`;

  return (
    <div className="App" >
      <MacBox>
        <UpBox>
        <MacBtnContainer>
      <MacBtn bg="#fe5f57"/>
      <MacBtn bg="#febb2d"/>
      <MacBtn bg="#25c339"/>      
    </MacBtnContainer>
        </UpBox>
        <MidBox>
        {children}
        </MidBox>
        <BottomBox></BottomBox>
      </MacBox>
    </div>
  );
}

export default MacBookBox;