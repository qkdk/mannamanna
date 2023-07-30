import React from 'react';
import { CenterBox,BtnBox, IdInput, InputBox, LoginBox  } from '../Login/LoginStyle'
import { LargeStyledButton, SmallIdLabel } from './ForgotIdStyle';
import { useNavigate } from 'react-router-dom';
import GoBackIcon from '../../../components/common/GoBackIcon';
import Logo from '../../../components/common/Logo';


const ForgotId = () => {
    return (
      <div>
      <div style={{height:'10vh', alignItems:'center'}}><Logo/></div>
        <CenterBox>
            <GoBackIcon></GoBackIcon>
        <LoginBox>
          <InputBox>
            <SmallIdLabel>이름</SmallIdLabel>
            <IdInput type="text" name="user_id" />
          </InputBox>
          <InputBox>
            <SmallIdLabel>이메일</SmallIdLabel>
            <IdInput type="test" name="user_email" />
          </InputBox>
          <BtnBox>
            <LargeStyledButton>아이디찾기</LargeStyledButton>
          </BtnBox>
        </LoginBox>
      </CenterBox>
      </div>
    );
};

export default ForgotId;