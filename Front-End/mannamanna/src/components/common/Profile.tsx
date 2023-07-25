import styled from 'styled-components'

const ProFile = styled.div`
    width: 75px;
    height: 75px;
    background : black;
    border-radius: 50%;
    opacity: 1;
    // border: 1px solid red;
    margin: 2vh;
`;

function Profile(){
    return(
        <div>
            <ProFile>
            </ProFile>
        </div>
    );
}



export default Profile;