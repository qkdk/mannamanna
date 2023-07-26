import { styled } from 'styled-components';

export let RegisterBox = styled.form`
  border: solid black 4px;
  width: 100vh;
  height: 90vh;
  border-radius: 5%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: rgba(188, 211, 255, 0.8); /* Using rgba() for transparency */
`;
export let SmallInputBox = styled.div`
  display: flex;
  border: solid rgba(248, 227, 234, 0.68) 4px;
  width: 40vw;
  height: 6vh;
  align-items: center;
  margin-bottom: 10px;
  font-size: 2.5vh;
  padding: 5px;
  background-color: white;
  border-radius: 3px;
  justify-content: space-between; /* 두 개의 요소가 양쪽 끝에 배치되도록 설정 */
`;
export let ImageBox = styled.div`
  display: flex;
  width: 20vw;
  height: 6vh;
  align-items: center;
  margin-bottom: 10px;
  font-size: 2.5vh;
  padding: 5px;
  background-color: white;
  border-radius: 3px;
  justify-content: space-between; /* 두 개의 요소가 양쪽 끝에 배치되도록 설정 */
`;


export let SmallInput = styled.input`
  width: 30vh;
  height: 1.5vh;
  margin-bottom: 10px;
  font-size: 2.5vh;
  padding: 5px;
  border: none;
  background-color: rgba(248, 227, 234, 0);
  border-radius: 3px;

  ::placeholder {
    /* Styles for the placeholder text */
    color: #000; /* Placeholder text color */
    opacity: 0.6; /* Opacity of the placeholder text */
  }
`;
