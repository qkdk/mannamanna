// import React from "react";
import styled from "styled-components";
import MacBookBox from "../../../components/common/macbookBox";
import { ImageBox, MypageInputBox } from "../Register/RegisterStyle";
import { Avatar } from "@mui/material";
import OutboxIcon from "@mui/icons-material/Outbox";
import {
  BlockCustomSwitch,
  DrinkCustomSwitch,
  JobSelectBox,
  MBTISelectBox,
  MyPagePassButton,
  MyPageTextArea,
  
  MyPageUserHeightSlider,
  
  ReligionSelectBox,
  SaveChangeButton,
  SmokeCustomSwitch,
} from "./MyPageStyles";

const ModifyBox = styled.div`
  width: 90%;
  background: rgba(255, 255, 255, 0.5);
  border: solid 0.5vh black;
  border-radius: 2vh;
  text-align: center;
  flex-direction: column;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 1.3vw;
`;

function MyPageModify() {
  return (
    <MacBookBox
      width="60%"
      height="90%"
      color1="#bcd3ff"
      color2="#ffffff"
      alignItems="center"
    >
      <div
        style={{
          flexDirection: "column",
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <div style={{ width: "90%", margin: "1vh" }}>기본정보</div>
        <ModifyBox>
              <div
                style={{
                  width: "100%",
                  display: "flex",
                  justifyContent: "space-around",
                  alignItems: "center",
                  flexDirection: "row",
                  margin: "1vh",
                }}
              >
                <div>비밀번호 변경</div>
                <MyPagePassButton>변경하러가기</MyPagePassButton>
              </div>
          <div
            style={{
              width: "100%",
              height: "3vh",
              display: "flex",
              justifyContent: "center",
              alignItems: "center",
              flexDirection: "row",
            }}
          >
            <div style={{ width: "25%", height: "100%" }}>주소</div>
            <div style={{ width: "75%", height: "100%" }}>입력입력</div>
          </div>
            <div
              style={{
                width: "100%",
                display: "flex",
                justifyContent: "space-around",
                alignItems: "center",
                flexDirection: "row",
                margin: "1vh",
              }}
            >
              <div>키</div>
              <MyPageUserHeightSlider />
            </div>
          <div
            style={{
              width: "100%",
              display: "flex",
              justifyContent: "space-around",
              alignItems: "center",
              flexDirection: "row",
              margin: "1vh",
            }}
          >
            <div style={{ width: "15%" }}>직업</div>
            <JobSelectBox />
            <div style={{ width: "15%" }}>지인차단</div>
            <BlockCustomSwitch />
          </div>
        </ModifyBox>
      </div>
      <div
        style={{
          flexDirection: "column",
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <div style={{ width: "90%", margin: "1vh" }}>세부정보</div>
        <ModifyBox>
          <div
            style={{
              width: "100%",
              display: "flex",
              justifyContent: "space-around",
              alignItems: "center",
              flexDirection: "row",
              margin: "1vh",
            }}
          >
            <div style={{ width: "15%" }}>흡연</div>
            <SmokeCustomSwitch />
            <div style={{ width: "15%" }}>음주</div>
            <DrinkCustomSwitch />
          </div>
          <div
            style={{
              width: "100%",
              display: "flex",
              justifyContent: "space-around",
              alignItems: "center",
              flexDirection: "row",
              margin: "1vh",
            }}
          >
            <div style={{ width: "15%" }}>종교</div>
            <ReligionSelectBox />
            <div style={{ width: "15%" }}>MBTI</div>
            <MBTISelectBox />
          </div>
        </ModifyBox>
      </div>
      <div
        style={{
          flexDirection: "column",
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <div style={{ width: "90%", margin: "1vh" }}>사진등록</div>
        <ModifyBox>
          <ImageBox>
            <Avatar src="/broken-image.jpg" />
            <Avatar src="/broken-image.jpg" />
            <Avatar src="/broken-image.jpg" />
          </ImageBox>
          <MypageInputBox>
            <div>
              <p>자신을 표현가능한 사진 3장을 입력해주세요.</p>
            </div>
            <OutboxIcon fontSize="large"></OutboxIcon>
          </MypageInputBox>
        </ModifyBox>
      </div>
      <div
        style={{
          flexDirection: "column",
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <div style={{ width: "90%", margin: "1vh" }}>자기소개</div>
        <ModifyBox>
          <div style={{ width: "100%" }}>
            <MyPageTextArea />
          </div>
        </ModifyBox>
      </div>
      <div
        style={{
          display: "flex",
          justifyContent: "center",
          alignItems: "center",
        }}
      >
        <SaveChangeButton>저장하기</SaveChangeButton>
      </div>
    </MacBookBox>
  );
}

export default MyPageModify;
