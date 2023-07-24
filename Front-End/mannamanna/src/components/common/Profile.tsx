import styled from 'styled-components'

const ProFile = styled.div`
    width: 75px;
    height: 75px;
    background : black;
    border-radius: 50%;
    opacity: 1;
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