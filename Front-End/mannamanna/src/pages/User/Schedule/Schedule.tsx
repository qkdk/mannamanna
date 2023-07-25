import React from 'react';
import Container from '../../../components/common/Container';
import BackBox  from '../../../components/common/Back';
import Sidebar from '../../../components/layout/Sidebar/SidebarHome';

const Schedule = () => {
    return (
        <div>
            <div style={{height:'5vh' }}></div>
        <BackBox>
            <div style={{ height:'80vh' }}>
            <Sidebar></Sidebar>
            </div>
            <div style={{ height:'80vh'}}>
            <Container></Container>
            </div>
            <div></div>
        </BackBox>
        </div>           
    );
};

export default Schedule;