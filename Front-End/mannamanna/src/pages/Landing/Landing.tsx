import React from 'react';
import ColorButton from '../../components/common/ColorButton';
import { useNavigate } from 'react-router-dom';
import { CenteredDiv, Content } from './LandingStyle';
import Logo from '../../components/common/Logo';


const LandingPage = () => {
    const navigate = useNavigate();

const GoLogin = () => {
    navigate('/login');
  }
    return (
        <div>
            <div style={{height:'10vh', alignItems:'center'}}><Logo/></div>
        <CenteredDiv style={{height:'90vh', justifyContent:'center',alignItems:'center'}}>
            <Content>
            부담없이 만나는 <br/>
            새로운 인연의 시작<br/>
            맞나?만나!
            </Content>
            <ColorButton onClick={GoLogin}> 
            시작하기
            </ColorButton>
        </CenteredDiv>
        </div>
    );
};

export default LandingPage;