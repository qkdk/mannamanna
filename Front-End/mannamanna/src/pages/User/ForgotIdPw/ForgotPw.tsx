import React from 'react';
import { CenterBox,BtnBox, IdInput, InputBox, LoginBox  } from '../Login/LoginStyle'
import { LargeStyledButton, SmallIdLabel } from './ForgotIdStyle';
import { useNavigate } from 'react-router-dom';
import GoBackIcon from '../../../components/common/GoBackIcon';
import Logo from '../../../components/common/Logo';


const ForgotPw = () => {
    return (
      <div>
      <div style={{height:'10vh', alignItems:'center'}}><Logo/></div>
        <CenterBox>
            <GoBackIcon></GoBackIcon>
        <LoginBox>
          <InputBox>
            <SmallIdLabel>ID</SmallIdLabel>
            <IdInput type="text" name="user_id" />
          </InputBox>
          <InputBox>
            <SmallIdLabel>E-mail</SmallIdLabel>
            <IdInput type="password" name="user_pw" />
          </InputBox>
          <BtnBox>
            <LargeStyledButton>임시 비밀번호 발급</LargeStyledButton>
          </BtnBox>
        </LoginBox>
      </CenterBox>
      </div>
    );
};

export default ForgotPw;