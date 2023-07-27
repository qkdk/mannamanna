import React from 'react';
import styled from 'styled-components'
import BackBox  from '../components/common/Back';
import Sidebar from '../components/layout/Sidebar/SidebarHome';
import MacBookBox from '../components/common/macbookBox';

const LeftChatBox = styled.div`
    width: 80%;
    height: 7vh;
    background: white;
    border: solid 0.5vh black;
    border-radius: 2vh 2vh 2vh 0vh;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1.3vw;
`
const RightChatBox = styled.div`
    width: 80%;
    height: 7vh;
    background: white;
    border: solid 0.5vh black;
    border-radius: 2vh 2vh 0vh 2vh;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1.3vw;
`
const ChatProFile = styled.div`
    width: 3vw;
    height: 3vw;
    background : black;
    border-radius: 50%;
    margin: 1vh;
`;
const ChatContainerBox = styled.div`
    border: solid 5px black;
    background-color : white;
    width: 140vh;
    height: 80vh;
    display: flex;
    justify-content: space-around;
    align-items: center;
`
const ChatLeftStyle = styled.div`
    border: solid 2px orange;
    width: 80%;
    background: blue;
    display: flex;
    justify-content: start;
    align-items: center;
    margin: 1vh 3vw 1vh 0.5vw;
`

const ChatRightStyle = styled.div`
    border: solid 2px pink;
    width: 80%;    
    background: blue;
    display: flex;
    justify-content: end;
    align-items: center;
    margin: 1vh 0.5vw 1vh 3vw;
`

const Chatting = () => {
    return (
        <div>
            <div style={{height:'5vh' }}></div>
            <BackBox>
            <div style={{ height:'80vh' }}>
                <Sidebar></Sidebar> 
            </div>
                <ChatContainerBox>
                    <MacBookBox width="30%" height="90%" color1="#ffcced" color2="#ffffff" alignItems='center'>

                    </MacBookBox>
                    <MacBookBox width="60%" height="90%" color1="#ffcced" color2="#ffffff" alignItems='center'>
                        <div style={{height:'85%', overflow:'auto'}}>
                            <div style={{flexDirection: 'column', display: 'flex',alignItems: 'center'}}>
                                <GetChat/>
                                <SendChat/>
                                <GetChat/>
                                <SendChat/>
                            </div>
                        </div>
                        <div style={{flexDirection: 'column', display: 'flex',alignItems: 'center',justifyContent: 'center',height:'15%'}}>
                            채팅보내기채팅보내기채팅보내기
                        </div>
                    </MacBookBox>
                </ChatContainerBox>
            </BackBox>
        </div>
             
    );
};

function GetChat(){
    return(
        <ChatLeftStyle>
            <ChatProFile/>
            <LeftChatBox>-50 Point 쪽지 보내기</LeftChatBox>
        </ChatLeftStyle>
    );
}
function SendChat(){
    return(
        <ChatRightStyle>
            <RightChatBox>+50 Point 미션 참여</RightChatBox>
            <ChatProFile/>
        </ChatRightStyle>
    );
}






export default Chatting;