import styled from 'styled-components'

const MileageBox = styled.div`
    width: 20vw;
    height: 7vh;
    background: white;
    border: solid 0.5vh black;
    border-radius: 2vh;
    text-align: center;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1.3vw;
`
const LeftStyle = styled.div`
    flex-direction: column;
    display: flex;
    align-items: flex-start;
    margin: 1vh 3vw;
    // margin-left: 3vw;
`

const RightStyle = styled.div`
    flex-direction: column;
    display: flex;
    align-items: flex-end;
    margin: 1vh 3vw;
    // margin-right: 3vw;
`

export {MileageBox, LeftStyle, RightStyle};