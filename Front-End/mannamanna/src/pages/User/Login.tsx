import React from 'react';
import { Outlet } from 'react-router-dom';

const Login = () => {
    return (
        <div>
            로그인
            <Outlet />
        </div>
    );
};

export default Login;