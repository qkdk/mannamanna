import * as React from 'react';
import { Navigate, Route, Routes } from 'react-router-dom';
import Layout from './pages/Layout';
import Landing from './pages/Landing/Landing';
import Login from './pages/User/Login/Login';
import Register from './pages/User/Register';
import ResetPassword from './pages/User/ResetPassword';
import MainHome from './pages/MainHome'; 
import Choice from './pages/Choice';
import Schedule from './pages/User/Schedule/Schedule';
import Mypage from './pages/User/Mypage';
import Chatting from './pages/Chatting';
import SoagetingMain from './pages/Sogaeting/SoagetingMain';
import SoagetingWait from './pages/Sogaeting/SoagetingWait';
import Soageting from './pages/Sogaeting/Soageting';
import MeetingMain from './pages/Meeting/MeetingMain';
import MeetingMakeRoom from './pages/Meeting/MeetingMakeRoom';
import MeetingWait from './pages/Meeting/MeetingWait';
import Meeting from './pages/Meeting/Meeting';
import Reserve from './pages/Reserve';
import Mission from './pages/Mission';
import Note from './pages/Note';
import Alarm from './pages/Alarm';
import GlobalFont from './Styles/GlobalFont';
import GlobalStyle from './Styles/GlobalStyle';



function App() {
  return (
    <>

    
    <GlobalFont />
    <GlobalStyle />
    {/* 초기오류수정 */}
      <Routes>
        <Route path="/*" element={<Layout/>}>
        <Route path="home" element={<Landing/>} />
        <Route path="main" element={<MainHome/>} />
        <Route path="schedule" element={<Schedule/>} />
        <Route path="choice" element={<Choice/>}/>
        <Route path="sogaetingMain" element={<SoagetingMain />} />
        <Route path="sogaetingWait" element={<SoagetingWait />} />
        <Route path="sogaeting" element={<Soageting />} />
        <Route path="meetingMain" element={<MeetingMain />} />
        <Route path="meetingMakeRoom" element={<MeetingMakeRoom />} />
        <Route path="meetingWait" element={<MeetingWait  />} />
        <Route path="meeting" element={<Meeting  />} />
        <Route path="reserve" element={<Reserve  />} /> 
        <Route path="mypage" element={<Mypage />} />  
        <Route path="chatting" element={<Chatting />} />    
        <Route path="mission" element={<Mission  />} />
        <Route path="note" element={<Note  />} />
        <Route path="alram" element={<Alarm  />} />
        <Route index element={<Navigate to="home" replace />} />
        </Route>
        <Route path="login" element={<Login/>}/>
        <Route path="passwordReset" element={<ResetPassword/>} />
        <Route path="register" element={<Register/>} />
      </Routes>
    </>
  );
}

export default App;
