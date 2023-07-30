import React from "react";
import Back from "../../components/common/Sogeting/SogetingMainBack";
import Font1 from "../../components/common/Sogeting/SogetingFont1";
import Btn1 from "../../components/common/Sogeting/button/NewPersonBtn";
import FilterContainer from "../../components/common/Sogeting/FilterContainer";
import FilterBody from "../../components/common/Sogeting/FilterBody";
import OnlineBox from "../../components/common/OnlineBtn";
import BtnBox from "../../components/common/Sogeting/BtnBox";

import {
  ProfileContaine,
  UnderBar,
  Profile,
  Online,
  DetailProfile,
  DetailText,
} from "./SoagaetinStyle";
// import Button from '@mui/material/Button';

const SoagetingFilter = () => {
  return (
    <div>
      <Back>
        <div
          style={{
            border: `solid 1px red`,
            height: "87vh",
          }}
        >
          <Font1
            style={
              {
                // border: 'solid 1px gold'
              }
            }
          >
            <p>
              소개팅~~
              <br />
              추천
            </p>
          </Font1>
          <FilterContainer>
            <FilterBody></FilterBody>
          </FilterContainer>
        </div>

        <div
          style={{
            // border: `solid 1px green`,
            height: "87vh",
            width: "25vw",
            display: "flex",
            flexDirection: "column",
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <ProfileContaine>
            <DetailProfile>
              <DetailText>
                <p>테버 / 29 / 188cm / 대전</p>
                <br />
                <p>저는 김치볶음밥을 좋아합니다.</p>
                <br />
                <p>#비흡연 #술조아 # ENFP</p>
              </DetailText>
            </DetailProfile>
            <Profile>
              <UnderBar>
                <Online>
                  <OnlineBox></OnlineBox>
                </Online>
                <BtnBox />
              </UnderBar>
            </Profile>
          </ProfileContaine>

          <ProfileContaine>
            <DetailProfile></DetailProfile>
            <Profile>
              <UnderBar>
                <Online>
                  <OnlineBox></OnlineBox>
                </Online>
                <BtnBox></BtnBox>
              </UnderBar>
            </Profile>
          </ProfileContaine>
        </div>

        <div
          style={{
            // border: `solid 1px black`,
            height: "87vh",
            width: "13vw",
          }}
        >
          <Font1>
            <p>
              내 근처
              <br />
              추천
            </p>
          </Font1>
          <Btn1 />
        </div>

        <div
          style={{
            // border: `solid 1px orange`,
            height: "87vh",
            width: "50vw",
            display: "flex",
            justifyContent: "center",
            alignItems: "center",
          }}
        >
          <div>
            <ProfileContaine>
              <DetailProfile></DetailProfile>
              <Profile>
                <UnderBar>
                  <Online>
                    <OnlineBox></OnlineBox>
                  </Online>
                  <BtnBox />
                </UnderBar>
              </Profile>
            </ProfileContaine>

            <ProfileContaine>
              <DetailProfile></DetailProfile>
              <Profile>
                <UnderBar>
                  <Online>
                    <OnlineBox></OnlineBox>
                  </Online>
                  <BtnBox />
                </UnderBar>
              </Profile>
            </ProfileContaine>
          </div>
          <div>
            <ProfileContaine>
              <DetailProfile></DetailProfile>
              <Profile>
                <UnderBar>
                  <Online>
                    <OnlineBox></OnlineBox>
                  </Online>
                  <BtnBox />
                </UnderBar>
              </Profile>
            </ProfileContaine>

            <ProfileContaine>
              <DetailProfile></DetailProfile>
              <Profile>
                <UnderBar>
                  <Online>
                    <OnlineBox></OnlineBox>
                  </Online>
                  <BtnBox />
                </UnderBar>
              </Profile>
            </ProfileContaine>
          </div>
        </div>
      </Back>
    </div>
  );
};

export default SoagetingFilter;
