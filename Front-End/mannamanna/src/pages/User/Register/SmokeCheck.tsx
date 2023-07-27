import React, { useState } from 'react';
import { Switch } from '@mui/material';
import { styled } from 'styled-components';
const SmokeCheck = () => {

  const CustomSwitch = styled(Switch)(({ theme }) => ({
  }));

    const [smokingChecked, setSmokingChecked] = useState(false);
    const handleSmokingClick = () => {
        setSmokingChecked(!smokingChecked);
      };
    return (
        <Switch 
        checked={smokingChecked}
        onClick={handleSmokingClick}
        inputProps={{ 'aria-label': 'controlled' }}
      />
    );
};

export default SmokeCheck;