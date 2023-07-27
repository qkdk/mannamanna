import React from 'react';
import BackBox from '../components/common/Back';
import Sidebar from '../components/layout/Sidebar/SidebarHome';
import RadiusContainerBox from './../components/common/RadiusContainer';
import { StyledButton } from './User/Login/LoginStyle';
import { useNavigate } from 'react-router-dom';

const Main = () => {
    const navigate = useNavigate();

    const GoChoice = () => {
      navigate('/choice');
    };
    return (
        <div>
            <div style={{height:'5vh' }}></div>
        <BackBox>
            <div style={{ height:'80vh' }}>
            <Sidebar></Sidebar>
            </div>
            <div style={{ height:'80vh'}}>
           <RadiusContainerBox>
            <StyledButton onClick={GoChoice}>
                인연찾으러가즈아
            </StyledButton>
           </RadiusContainerBox>
            </div>
            <div></div>
        </BackBox>
        </div>         
    );
};

export default Main;