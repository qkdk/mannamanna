import React from 'react';
import { CenterBox ,BtnBox, ForgotPasswordLink, IdInput, IdLabel, InputBox, LoginBox, StyledButton } from './LoginStyle';
import { useNavigate } from 'react-router-dom';
import GoBackIcon from '../../../components/common/GoBackIcon';
import Logo from '../../../components/common/Logo';

const Login = () => {
  const navigate = useNavigate();

  const GoFindId = () => {
    navigate('/ForgotId');
  };
  const GoFindPw = () => {
    navigate('/ForgotPw');
  };
  const GoRegister = () => {
    navigate('/register');
  };


  return (
    <div>
    <div style={{height:'10vh', alignItems:'center'}}><Logo/></div>
    <CenterBox>
        <GoBackIcon></GoBackIcon>
      <LoginBox>
        <InputBox>
          <IdLabel>ID</IdLabel>
          <IdInput type="text" name="user_id" />
        </InputBox>
        <InputBox>
          <IdLabel>PASSWORD</IdLabel>
          <IdInput type="password" name="user_pw" />
        </InputBox>
        <BtnBox>
        <ForgotPasswordLink onClick={GoFindId}>
          아이디 찾기
        </ForgotPasswordLink>
        <ForgotPasswordLink onClick={GoFindPw}>
          비밀번호 찾기
        </ForgotPasswordLink></BtnBox>
        <BtnBox>
          <StyledButton>로그인</StyledButton>
          <StyledButton onClick={GoRegister}>회원가입</StyledButton>
        </BtnBox>
      </LoginBox>
    </CenterBox>
    </div>
  );
};

export default Login;
