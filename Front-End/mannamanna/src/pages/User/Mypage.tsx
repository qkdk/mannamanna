import React from 'react';
import styled from 'styled-components'
import Profile from '../../components/common/Profile';
import Button from '@mui/material/Button';

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
    return (
        <div style={{width:'100%',height:'90vh' ,display:'flex', justifyContent: 'space-around', alignItems: 'center'}}>
            <Hello style={{width:'30%',height:'80%'}}>
                <Profile/>
                <br/>
                안녕 임시저장임시저장
                <br/>
                <Button variant="outlined">내 정보 수정</Button>
                <br/>
                <Button variant="outlined">내 정보 수정</Button>
                <br/>
                <Button variant="outlined">내 정보 수정</Button>
                <br/>
                <Button variant="outlined">내 정보 수정</Button>
                <br/>
                <MyPageButton>안녕</MyPageButton>
                마일리지 : 10000
            </Hello>
            <Hello style={{width:'50%',height:'80%'}}>
                가나다라
            </Hello>
        </div>
    );
 };
  
 export default Mypage;