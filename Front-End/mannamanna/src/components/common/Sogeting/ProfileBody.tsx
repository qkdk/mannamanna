import React from 'react';
import styled from 'styled-components'
import profile from '../Sogeting/DummyImage.jpg'

const ProfileBody = styled.div`
height: 40vh;
width: 20vw;
// background-color: white;
border-radius: 1.5vw;
background-image: url(${profile}); 
background-size: 40vh 20vw;
position: relative;
`

const UnderBar = styled.div`
height: 7vh;
width: 20vw;
// background-color: red;
background-color :rgba(255, 204, 237, 0.6) ;
border-bottom-right-radius: 1.5vw;;
border-bottom-left-radius:  1.5vw;;
// border-top: solid black 0.4rem;
position: absolute;
bottom: 0px;
`

const Profile = () => {
    return(
        <ProfileBody>
            <UnderBar></UnderBar>
        </ProfileBody>
    );
}



export default Profile;