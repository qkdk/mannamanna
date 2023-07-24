import React from 'react';
import {Outlet} from 'react-router-dom';

const Layout = () => {
    return (
        <div>
            <div>
            헤더 넣을꺼
            </div>
            <div>
                <Outlet></Outlet>
            </div>
            
        </div>
    );
};



export default Layout;