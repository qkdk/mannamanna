import React from 'react';
import { CenterBox, StyledButton } from '../Login/LoginStyle';
import GoBackIcon from '../../../components/common/GoBackIcon';
import RadiusContainerBox from '../../../components/common/RadiusContainer';
import signup from '../../../asset/image/signup.png';
import Logo from '../../../components/common/Logo';
import { SmallInput, SmallInputBox } from './RegisterStyle';
import InputSlider from '../../../components/common/slider';
const Register = () => {
    return (
        <div>
        <div style={{height:'10vh', alignItems:'center'}}><Logo/></div>
        <CenterBox>
            <GoBackIcon></GoBackIcon>
            <RadiusContainerBox style={{overflow: 'auto'}}>
            <img src={signup} alt="Signup" style={{ maxWidth: '80vh', maxHeight: '100vh' }}></img>

            <SmallInputBox>
                <div  style={{ width:'65%' }}>
                <p>카카오톡 연동이 필요합니다.</p>
                <p>카카오톡 인증을 해주세요!</p>
                </div>
                <StyledButton>
                    인증하러가기
                </StyledButton>
            </SmallInputBox>

            <SmallInputBox>
                <div style={{ width:'65%' }}>
                <p>아이디 적어주세요</p>
                <SmallInput placeholder='아이디 입력칸'></SmallInput>
                </div>
                <StyledButton>
                   중복확인
                </StyledButton>
            </SmallInputBox>
            <SmallInputBox  style={{ justifyContent: 'flex-start'}}>
                <div>
                <p>비밀번호를 적어주세요</p>
                <SmallInput placeholder='비밀번호 입력칸'></SmallInput>
                </div>
            </SmallInputBox>
            <SmallInputBox>
                <div style={{ width:'65%' }}>
                <p>비밀번호를 확인해주세요</p>
                <SmallInput placeholder='비밀번호 입력칸'></SmallInput>
                </div>
                <StyledButton>
                    비밀번호 확인
                </StyledButton>
            </SmallInputBox>
            <SmallInputBox>
              <div style={{ width:'65%' }}>
                <p>사는 지역을 선택해주세요</p>
                </div>
                <StyledButton>
                    인증하러가기
                </StyledButton>
            </SmallInputBox>
            <SmallInputBox>
               <div style={{ width:'65%' }}>
                <p>키를 입력해주세요</p>
                </div>
        <InputSlider></InputSlider>
            </SmallInputBox>
            <SmallInputBox>
              <div style={{ width:'65%' }}>
                <p>자기소개를 작성해주세요</p>
                </div>
                <StyledButton>
                    작성하기
                </StyledButton>
            </SmallInputBox>
            
            </RadiusContainerBox>
        </CenterBox>
        </div>
    );
};

export default Register;