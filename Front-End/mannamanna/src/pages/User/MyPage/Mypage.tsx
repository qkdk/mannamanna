import React from 'react';
import { useState } from 'react';
import styled from 'styled-components'
import Profile from '../../../components/common/Profile';
import Button from '@mui/material/Button';
import { Routes, Route, Link, Outlet } from 'react-router-dom'
import { useNavigate } from 'react-router-dom';
import MyPageModify from './MyPageModify';
import MyPageMileage from './MyPageMileage';
import MyPageHistory from './MyPageHistory';
import MyPageWithdrawal from './MyPageWithdrawal';

function Tap(){
    let [탭, 탭변경] = useState(0)
}


{/* <Route path="mypage" element={<Mypage />}>
          <Route path="modify" element={ <MyPageModify/> } />
          <Route path="mileage" element={ <MyPageMiileage/> } />
          <Route path="history" element={ <MyPageHistory/> } />
          <Route path="withdrawal" element={ <MyPageWithdrawal/> } />
        </Route> */}

let Hello = styled.div`
 border: solid 7px black;
  border-radius:40px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  ` 
type MyPageButtonProps = {
    children: string;
};
  
const MyPageButton = ({ children }: MyPageButtonProps) => {
    return(
        <Button
        sx={{
            m : 1,
            color: "#black",
            borderColor: "ffcced",
        }}
        variant="contained"
        >{children}</Button>
    )
}




 const Mypage = () => {

    const navigate = useNavigate();

    const GoModify = () => {
        navigate('/mypage/modify');
    }
    const GoMileage = () => {
        navigate('/mypage/mileage');
    }
    const GoHistory = () => {
        navigate('/mypage/history');
    }
    const GoWithdrawal = () => {
        navigate('/mypage/withdrawal');
    }
    
    return (
        <div style={{width:'100%',height:'90vh' ,display:'flex', justifyContent: 'space-around', alignItems: 'center'}}>
        <Hello style={{width:'30%',height:'80%'}}>
            <Profile/>
            <br/>
            안녕 임시저장임시저장
            <br/>
            <Button variant="outlined" onClick={GoModify} >내 정보 수정</Button>
            <br/>
            <Button variant="outlined" onClick={GoMileage}>마일리지</Button>
            <br/>
            <Button variant="outlined" onClick={GoHistory}>소개팅 미팅 내역</Button>
            <br/>
            <Button variant="outlined" onClick={GoWithdrawal}>회원탈퇴</Button>
            <br/>
            <MyPageButton>안녕</MyPageButton>
            마일리지 : 10000
        </Hello>
        {/* <Hello style={{width:'50%',height:'80%'}}>
            가나다라
        </Hello> */}
        {/* <MyPageModify/> */}
        {/* <MyPageMileage/> */}
        {/* <MyPageHistory/> */}
        {/* <MyPageWithdrawal/> */}
        <Outlet></Outlet>
        </div>
    );
 };


 
 export default Mypage;