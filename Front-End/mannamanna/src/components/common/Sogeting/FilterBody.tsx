import React from 'react';
import styled from 'styled-components'

const FilterBody = styled.div `
height: 55vh;
width: 12vw;
border: solid black 0.4rem;
// background-color: white;
border-radius: 5vh;
`
const UpBar = styled.div `
height: 3.5vh;
width: 12vw;
background-color: pink;
border-top-right-radius: 5vw;
border-top-left-radius:  5vw;
border-bottom: solid black 0.4rem;
`

const Box = styled.div`
height: 46.7vh;
width: 12vw;
`

const DownBar = styled.div `
height: 3.5vh;
width: 12vw;
background-color: pink;
border-bottom-right-radius: 5vw;
border-bottom-left-radius:  5vw;
border-top: solid black 0.4rem;
`

const Filter = () => {
    return (<FilterBody>
        <UpBar></UpBar>
        <Box></Box>
        <DownBar></DownBar>
    </FilterBody>
    );
}

export default Filter;