import styled from 'styled-components';
import Stack from '@mui/material/Stack';
import Button from '@mui/material/Button';
import React from 'react';
// import backgroundImage from 'C:\Users\SSAFY\Desktop\css_Component\css_component\background.jpg';
import './App.css';

let LoginBox = styled.form`
border : solid white 4px; 
width: 1000px;
height: 600px;
border-radius: 5%;
display: flex;
flex-direction: column;
justify-content: center;
align-items: center;
background-color:rgba(255,255,255, 0.2);/*까만색(0,0,0) 20% 불투명도*/
`
let InputBox = styled.div`
// border: solid 2px red;
width: 600px;
height: 100px;
margin-bottom: 7%;
display: flex;
justify-content: center;
align-items: center;
`
let IdLabel = styled.label`
  width: 200px;
  height: 60px;
  font-size: 25px;
  // border:solid 2px blue;
  text-align: center;
  line-height : 60px;
`;
let IdInput = styled.input`
  width: 400px;
  height: 60px;
  margin-left: 7%;
  font-size: 20px;
  background-color: #ffcced;
  border: none;
  // box-shadow: 0 0 20 5px #ffffff;
`;
let BtnBox = styled.div`
width: 400px
height: 200px
` 

function App() {
  return (
    <div className="App" >
  <LoginBox>
  <InputBox>
          <IdLabel>ID</IdLabel>
          <IdInput type="text" name="user_id"></IdInput>
        </InputBox>
        <InputBox>
          <IdLabel>PASSWORD</IdLabel>
          <IdInput type="password" name="user_pw"></IdInput>
        </InputBox>
        <BtnBox>
        <Button 
        variant="outlined"  
        sx={{
    m : 1,
    width: "200px",
    height: "70px",
    color: "#ffffff",
    border: "solid 3px",
    borderColor: "#ffcced",
    borderRadius: "15px",
    fontSize:"25px",
    ":hover": {
       borderColor: "#d9cff4",
       color:"#d9cff4",
       border: "solid 3px",
   },
  }}>로그인</Button>
        <Button variant="outlined"  
        sx={{
    m : 1,
    width: "200px",
    height: "70px",
    color: "#ffffff",
    border: "solid 3px",
    borderColor: "#ffcced",
    borderRadius: "15px",
    fontSize:"25px",
    ":hover": {
       borderColor: "#d9cff4",
       color:"#d9cff4",
       border: "solid 3px",
   },
  }}>회원가입</Button>
        </BtnBox>
  </LoginBox>
  
    </div>
  );
}

export default App;