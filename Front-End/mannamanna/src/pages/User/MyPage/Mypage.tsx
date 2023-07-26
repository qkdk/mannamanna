import React from 'react';
import styled from 'styled-components'
import Profile from '../../../components/common/Profile';
import Button from '@mui/material/Button';
import { Outlet } from 'react-router-dom'
import { useNavigate } from 'react-router-dom';

let Hello = styled.div`
 border: solid 7px black;
  border-radius:40px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  font-size: 20px;
  ` 
type MyPageButtonProps = {
    children: string;
    onClick: ()=>void;
};
  
const MyPageButton = ({ children, onClick }: MyPageButtonProps) => {
    return(
        <Button
        sx={{
            width: '15vw', 
            height: '10vh',
            margin: '1vh',
            backgroundColor: '#ffcced',
            border: '0.3vw solid #000',
            borderRadius: 3,
            color:'common.black',
            borderColor: "ffcced",
            fontSize: '3vh',
            '&:hover': { backgroundColor: '#f8e3ea' },
        }}
        variant="contained"
        onClick={onClick}
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
                이름이름이름
                <MyPageButton onClick={GoModify} >내 정보 수정</MyPageButton>
                <MyPageButton onClick={GoMileage} >마일리지</MyPageButton>
                <MyPageButton onClick={GoHistory} >소개팅 미팅 내역</MyPageButton>
                <MyPageButton onClick={GoWithdrawal} >회원탈퇴</MyPageButton>
                마일리지 : 10000
            </Hello>
            
            <Outlet></Outlet>
            
        </div>
    );
 };


 
 export default Mypage;