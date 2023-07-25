import React from 'react';
import {Outlet} from 'react-router-dom';
import Greetings from '../components/common/Greetings';

const Layout = () => {
    return (
        <div>
        <Greetings/>
            <div>
                <Outlet></Outlet>
            </div>
            
        </div>
    );
};



export default Layout;