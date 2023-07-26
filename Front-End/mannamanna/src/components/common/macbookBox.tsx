import styled from 'styled-components';
import React, { ReactNode } from 'react';

interface MacBookBoxProps {
  children: ReactNode;
  width: string;
  height: string;
  color1:string;
  color2:string;

}

function MacBookBox({ children, width, height,color1,color2}: MacBookBoxProps) {
  let MacBox = styled.div`
    border: solid 7px black;
    width: ${width};
    height: ${height};
    border-radius: 4vh;
    display: flex; 
    flex-direction: column; 
    justify-content: center; 
    align-items: center; 
  `;

  let UpBox = styled.div`
    border-bottom: solid 5px black;
    width: ${width};
    height: 10vh;
    border-top-left-radius: 3vh;
    border-top-right-radius: 3vh;
    background-color: ${color1};
    display: flex;
    align-items: center;
    justify-content: end;
  `;

  let MidBox = styled.div`
    width: ${width};
    height: $;
    background-color: ${color2};
    overflow:auto;
    &::-webkit-scrollbar {
      width: 0.7vw;
    }
    &::-webkit-scrollbar-thumb {
      border-radius: 0.5vh;
    }
  `;

  let BottomBox = styled.div`
    border-top: solid 5px black;
    width: ${width};
    height: 7vh;
    border-bottom-left-radius: 3vh;
    border-bottom-right-radius: 3vh;
    background-color: ${color1};
  `;

let MacBtnContainer = styled.div`
width : 5vw;
height : 4vh;
display: flex;
justify-content: space-around;
align-items: center;
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
  );
}

export default MacBookBox;