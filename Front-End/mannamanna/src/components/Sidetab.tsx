import styled from 'styled-components'

type SidebarProps = {
    menu: string,
    bg : string;
 }

const Sidecom = styled.button`
    width: 150px;
    height: 50px;
    opacity: 1;
    border-style: solid;
    border-color: #000000;
    border-radius: 10px;
    border-width: 3px;
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