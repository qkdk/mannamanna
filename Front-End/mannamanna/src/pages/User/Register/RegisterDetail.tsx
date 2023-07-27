import React, { useState } from 'react';
import { CenterBox, StyledButton } from '../Login/LoginStyle';
import GoBackIcon from '../../../components/common/GoBackIcon';
import RadiusContainerBox from '../../../components/common/RadiusContainer';
import signup from '../../../asset/image/signup.png';
import Logo from '../../../components/common/Logo';
import { ImageBox, SmallInputBox } from './RegisterStyle';
import MacbookBox from '../../../components/common/macbookBox';
import KeyboardArrowDownIcon from '@mui/icons-material/KeyboardArrowDown';
import { Avatar, Switch , SwitchProps } from '@mui/material';
import OutboxIcon from '@mui/icons-material/Outbox';
import { useNavigate } from 'react-router-dom';

const RegisterDetail = () => {
  const navigate = useNavigate();

  const GoMain = () => {
      navigate('/main');
    }
  const SwitchMemo: React.FC<SwitchProps> = React.memo(Switch);
  const [smokingChecked, setSmokingChecked] = useState(false);
  const [drinkingChecked, setDrinkingChecked] = useState(false);

  const handleSmokingClick = () => {
    setSmokingChecked(!smokingChecked);
  };

  const handleDrinkingClick = () => {
    setDrinkingChecked(!drinkingChecked);
  };

  return (
    <div>
      <div style={{ height: '5vh', alignItems: 'center' }}>
        <Logo />
      </div>
      <CenterBox>
        <GoBackIcon></GoBackIcon>
      <CenterBox style={{ flexDirection: 'column' }}>
        <img src={signup} alt="Signup" style={{ maxWidth: '80vh', maxHeight: '100vh' }}></img>
          <MacbookBox width="120vh" height="60vh" color1="#bcd3ff" color2="#FFFFFF" alignItems='center' >
            <CenterBox style={{ flexDirection: 'column' }}>
                <ImageBox>
                <Avatar src="/broken-image.jpg" />
                <Avatar src="/broken-image.jpg" />
                <Avatar src="/broken-image.jpg" />
                </ImageBox>
              <SmallInputBox>
                <div>
                  <p>자신을 표현가능한 사진 3장을 입력해주세요.</p>
                </div>
                <OutboxIcon fontSize='large'></OutboxIcon>
              </SmallInputBox>

              <SmallInputBox>
                <div>
                  <p>직업을 골라주세요</p>
                </div>
                <KeyboardArrowDownIcon fontSize="large" />
              </SmallInputBox>
              <SmallInputBox>
                <div>
                  <p>흡연을 하시나요?</p>
                </div>
                {/* SwitchMemo로 감싸서 최적화 */}
                <SwitchMemo
                  checked={smokingChecked}
                  onClick={handleSmokingClick}
                  inputProps={{ 'aria-label': 'controlled' }}
                />
              </SmallInputBox>
              <SmallInputBox>
                <div>
                  <p>음주를 하시나요?</p>
                </div>
                <SwitchMemo
                  checked={drinkingChecked}
                  onClick={handleDrinkingClick}
                  inputProps={{ 'aria-label': 'controlled' }}
                />
              </SmallInputBox>
              <SmallInputBox>
                <div>
                  <p>종교을 골라주세요</p>
                </div>
                <KeyboardArrowDownIcon fontSize="large" />
              </SmallInputBox>
              <SmallInputBox>
                <div>
                  <p>MBTI를 골라주세요</p>
                </div>
                <KeyboardArrowDownIcon fontSize="large" />
              </SmallInputBox>
              <StyledButton onClick={GoMain}>완료</StyledButton>
            </CenterBox>
          </MacbookBox>
      </CenterBox></CenterBox>
    </div>
  );
};

export default RegisterDetail;
