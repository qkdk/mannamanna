import React from 'react';
import styled from 'styled-components'
import Profile from '../../../components/common/Profile';
import Button from '@mui/material/Button';
import { Outlet } from 'react-router-dom'
import { useNavigate } from 'react-router-dom';
import MacBookBox from '../../../components/common/macbookBox';
import BackBox from '../../../components/common/Back';
import Sidebar from '../../../components/layout/Sidebar/SidebarHome';
// import ContainerBox from '../../../components/common/Container';

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
            fontSize: '2.5vh',
            '&:hover': { backgroundColor: '#f8e3ea' },
        }}
        variant="contained"
        onClick={onClick}
        >{children}</Button>
    )
}
const ContainerBox = styled.div`
    border: solid 5px black;
    background-color : white;
    width: 140vh;
    height: 80vh;
    display: flex;
    justify-content: space-around;
    align-items: center;
`
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
        // <div style={{width:'100%',height:'90vh' ,display:'flex', justifyContent: 'space-around', alignItems: 'center'}}>
        //     <MacBookBox width="30%" height="80%" color1="#bcd3ff" color2="#ffffff" alignItems='center'>
        //         <div style={{ width:'100%',height:'100%' ,flexDirection:'column' ,display:'flex', justifyContent: 'space-around', alignItems: 'center'}}>
        //             <Profile/>
        //             <br/>
        //             이름이름이름
        //             <MyPageButton onClick={GoModify} >내 정보 수정</MyPageButton>
        //             <MyPageButton onClick={GoMileage} >마일리지</MyPageButton>
        //             <MyPageButton onClick={GoHistory} >소개팅/미팅 내역</MyPageButton>
        //             <MyPageButton onClick={GoWithdrawal} >회원탈퇴</MyPageButton>
        //             마일리지 : 10000
        //         </div>
        //     </MacBookBox>
        //     <Outlet></Outlet>
        // </div>
         <div>
         <div style={{height:'5vh' }}></div>
         <BackBox>
            <div style={{ height:'80vh' }}>
                <Sidebar></Sidebar> 
            </div>
            <div style={{ height:'80vh' }}>
                <ContainerBox>
                    <MacBookBox width="30%" height="90%" color1="#bcd3ff" color2="#ffffff" alignItems='center'>
                        <div style={{ width:'100%',height:'100%' ,flexDirection:'column' ,display:'flex', justifyContent: 'space-around', alignItems: 'center'}}>
                            <Profile/>
                            <br/>
                            이름이름이름
                            <MyPageButton onClick={GoModify} >내 정보 수정</MyPageButton>
                            <MyPageButton onClick={GoMileage} >마일리지</MyPageButton>
                            <MyPageButton onClick={GoHistory} >소개팅/미팅 내역</MyPageButton>
                            <MyPageButton onClick={GoWithdrawal} >회원탈퇴</MyPageButton>
                            마일리지 : 10000
                        </div>
                    </MacBookBox>
                    <Outlet></Outlet>
                </ContainerBox>
            </div>
         </BackBox>
     </div>
    );
 };
 
 export default Mypage;