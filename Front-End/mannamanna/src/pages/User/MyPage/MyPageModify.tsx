import React from 'react';
import styled from 'styled-components'
import MacBookBox from '../../../components/common/macbookBox';
import InputSlider from '../../../components/common/slider';

const ModifyBox = styled.div`
    width: 35vw;
    height: 7vh;
    background: rgba(255, 255, 255, 0.5);
    border: solid 0.5vh black;
    border-radius: 2vh;
    text-align: center;
    flex-direction: column; 
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 1.3vw;
`

function MyPageModify() {
    return (
            <MacBookBox width="50%" height="80%" color1="#bcd3ff" color2="ffffff" alignItems='center'>
                <ModifyBox>
                    <div>기본정보</div>
                    <div>
                        키<InputSlider/>
                    </div>
                </ModifyBox>
            </MacBookBox>
    );
 };
  




 export default MyPageModify;