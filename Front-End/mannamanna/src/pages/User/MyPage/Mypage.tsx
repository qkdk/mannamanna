import React from 'react';
import styled from 'styled-components'
import Profile from '../../../components/common/Profile';
import Button from '@mui/material/Button';
import { Outlet } from 'react-router-dom'
import { useNavigate } from 'react-router-dom';
import MacBookBox from '../../../components/common/macbookBox';

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
            <MacBookBox width="30%" height="80%" color1="#bcd3ff" color2="ffffff" alignItems='center'>
                <Profile/>
                <br/>
                이름이름이름
                <MyPageButton onClick={GoModify} >내 정보 수정</MyPageButton>
                <MyPageButton onClick={GoMileage} >마일리지</MyPageButton>
                <MyPageButton onClick={GoHistory} >소개팅 미팅 내역</MyPageButton>
                <MyPageButton onClick={GoWithdrawal} >회원탈퇴</MyPageButton>
                마일리지 : 10000
            </MacBookBox>
            <Outlet></Outlet>
        </div>
    );
 };
 
 export default Mypage;