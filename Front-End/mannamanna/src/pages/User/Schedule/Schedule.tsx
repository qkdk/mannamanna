import React from 'react';
import BackBox  from '../../../components/common/Back';
import Sidebar from '../../../components/layout/Sidebar/SidebarHome';
import RadiusContainerBox from './../../../components/common/RadiusContainer';
import { DateCalendar } from '@mui/x-date-pickers';

const Schedule = () => {
    return (
        <div>
            <div style={{height:'5vh' }}></div>
        <BackBox>
            <div style={{ height:'80vh' }}>
            <Sidebar></Sidebar>
            </div>
            <div style={{ height:'80vh'}}>
            <RadiusContainerBox>
            <DateCalendar showDaysOutsideCurrentMonth fixedWeekNumber={6} />
            </RadiusContainerBox>
            </div>
            <div></div>
        </BackBox>
        </div>           
    );
};

export default Schedule;