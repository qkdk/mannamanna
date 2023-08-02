import styled from 'styled-components'
import Sidetab from '../Sidetab';

const SidebarStyle = styled.div`
    // width: 20%;
    height: 26vh;
    background : black;
    display: flex;
    justify-Content: flex-end;
    margin: 0%;
    // border: 3px solid red;
`;

function SidebarChat(){
    return(
            <SidebarStyle>
                <div>
                <Sidetab menu={"Home"} bg={"white"}/>
                <Sidetab menu={"MyPage"} bg={"white"}/>
                <Sidetab menu={"Chat"} bg={"pink"}/>
                <Sidetab menu={"Mission"} bg={"white"}/>
                <Sidetab menu={"끝!"} bg={"white"}/>
                </div>
            </SidebarStyle>
    );
}



export default SidebarChat;