import styled from 'styled-components'

type SidebarProps = {
    menu: string,
    bg : string;
 }

const Sidecom = styled.button`
    width: 15vh;
    height: 8vh;
    opacity: 1;
    border-style: solid;
    border-color: #000000;
    border-radius: 10px;
    border-width: 0.3vh;
    justify-content: center;
    align-items: center;
`;

function Sidetab(props:SidebarProps){
    return(
        <div>
            <Sidecom style={{background:`${props.bg}`}}>
                {props.menu}
            </Sidecom>
        </div>
    );
}
export default Sidetab;