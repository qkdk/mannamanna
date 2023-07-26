import React from 'react';
import Back from '../../components/common/Sogeting/SogetingMainBack';
import Font1 from '../../components/common/Sogeting/SogetingFont1';
import Btn1 from '../../components/common/Sogeting/button/NewPersonBtn';
import FilterContainer from '../../components/common/Sogeting/FilterContainer';
import FilterBody from '../../components/common/Sogeting/FilterBody';
import ProfileContaine from '../../components/common/Sogeting/ProfileContainer';
import Profile from '../../components/common/Sogeting/ProfileBody';
// import Button from '@mui/material/Button';

const SoagetingFilter = () => {
    return (
        <div>
            <Back>
                <div
                    style={{
                        border: `solid 1px red`,
                        height: '87vh'
                    }}>
                    <Font1
                        style={{
                            // border: 'solid 1px gold'
                        }}>
                        <p>소개팅
                            <br/>
                            추천</p>
                    </Font1>
                    <FilterContainer>
                        <FilterBody></FilterBody>
                    </FilterContainer>
                </div>

                <div
                    style={{
                        border: `solid 1px green`,
                        height: '87vh',
                        width: "25vw",
                        display: 'flex',
                        flexDirection: 'column',
                        justifyContent: 'center',
                        alignItems: 'center'
                    }}>
                    <ProfileContaine>
                        <Profile></Profile>
                    </ProfileContaine>
                    <ProfileContaine>
                        <Profile></Profile>
                    </ProfileContaine>
                </div>

                <div
                    style={{
                        // border: `solid 1px black`,
                        height: '87vh',
                        width: "13vw"
                    }}>
                    <Font1>
                        <p>내 근처<br/>
                            추천</p>
                    </Font1>
                    <Btn1/>
                </div>

                <div
                    style={{
                        border: `solid 1px orange`,
                        height: '87vh',
                        width: "50vw",
                        display: 'flex',
                        justifyContent: 'center',
                        alignItems: 'center'
                    }}>
                    <div>
                        <ProfileContaine>
                            <Profile></Profile>
                        </ProfileContaine>
                        <ProfileContaine>
                            <Profile></Profile>
                        </ProfileContaine>
                    </div>
                    <div>
                        <ProfileContaine>
                            <Profile></Profile>
                        </ProfileContaine>
                        <ProfileContaine>
                            <Profile></Profile>
                        </ProfileContaine>
                    </div>
                </div>
            </Back>
        </div>
    );
};

export default SoagetingFilter;