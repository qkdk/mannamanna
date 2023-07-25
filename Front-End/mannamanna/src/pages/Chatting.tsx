import React from 'react';
import Container from '../../src/components/common/Container';
import BackBox  from '../components/common/Back';
import SidebarChat from '../components/layout/Sidebar/SidebarChat';

const Chatting = () => {
    return (
        <div>
            <div style={{height:'5vh' }}></div>
        <BackBox>
            <div style={{ height:'80vh' }}>
            <SidebarChat></SidebarChat>
            </div>
            <div style={{ height:'80vh'}}>
            <Container></Container>
            </div>
            <div></div>
        </BackBox>
        </div>           
    );
};

export default Chatting;