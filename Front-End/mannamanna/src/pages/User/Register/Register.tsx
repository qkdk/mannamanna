import React from 'react';
import { CenterBox, StyledButton } from '../Login/LoginStyle';
import GoBackIcon from '../../../components/common/GoBackIcon';
import RadiusContainerBox from '../../../components/common/RadiusContainer';
import signup from '../../../asset/image/signup.png';
import Logo from '../../../components/common/Logo';
import { SmallInput, SmallInputBox } from './RegisterStyle';
import InputSlider from '../../../components/common/slider';
import MacBookBox from '../../../components/common/macbookBox';
import { useNavigate } from 'react-router-dom';
const Register = () => {
    const navigate = useNavigate();

    const GoRegisterDetail = () => {
        navigate('/registerDetail');
      }
    return (
        <div>
        <div style={{height:'10vh', alignItems:'center'}}><Logo/></div>
        <CenterBox>
            <GoBackIcon></GoBackIcon>
            <RadiusContainerBox>
            <img src={signup} alt="Signup" style={{ maxWidth: '80vh', maxHeight: '100vh' }}></img>
            <MacBookBox width="120vh" height="60vh" color1="#bcd3ff" color2="ffffff">
            <CenterBox style={{ flexDirection: 'column' }}>
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
                <div>
                <p>아이디 적어주세요</p>
                <SmallInput placeholder='아이디 입력칸'></SmallInput>
                </div>
                <StyledButton>
                   중복확인
                </StyledButton>
            </SmallInputBox>
            <SmallInputBox>
            <div>
                <p>비밀번호를 적어주세요</p>
                <SmallInput placeholder='비밀번호 입력칸'></SmallInput>
                </div>
            </SmallInputBox>
            <SmallInputBox>
            <div>
                <p>비밀번호를 확인해주세요</p>
                <SmallInput placeholder='비밀번호 입력칸'></SmallInput>
                </div>
                <StyledButton>
                    비밀번호 확인
                </StyledButton>
            </SmallInputBox>
            <SmallInputBox>
            <div>
                <p>사는 지역을 선택해주세요</p>
                </div>
                <StyledButton>
                    지역 찾기
                </StyledButton>
            </SmallInputBox>
            <SmallInputBox>
            <div>
                <p>키를 입력해주세요</p>
                </div>
        <InputSlider ></InputSlider>
            </SmallInputBox>
            <SmallInputBox>
            <div>
                <p>자기소개를 작성해주세요</p>
                </div>
                <StyledButton>
                    작성하기
                </StyledButton>
            </SmallInputBox>
            <StyledButton onClick={GoRegisterDetail}>
                다음
            </StyledButton>
            </CenterBox>
            </MacBookBox>
            </RadiusContainerBox>
        </CenterBox>
        </div>
    );
};

export default Register;