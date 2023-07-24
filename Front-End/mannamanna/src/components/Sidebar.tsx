import styled from 'styled-components'
import Sidetab from './Sidetab';

const SidebarStyle = styled.div`
    width: 20%;
    height: 100%;
    background : black;
    display: flex;
    justify-Content: flex-end;
`;

function Sidebar(){
    return(
        <div>
            <SidebarStyle>
                <div>
                <Sidetab menu={"Home"} bg={"pink"}/>
                <Sidetab menu={"MyPage"} bg={"white"}/>
                <Sidetab menu={"Chat"} bg={"white"}/>
                <Sidetab menu={"Mission"} bg={"white"}/>
                <Sidetab menu={"끝!"} bg={"white"}/>
                </div>
            </SidebarStyle>
        </div>
    );
}



export default Sidebar;