import React, { useState } from 'react';
import { Switch } from '@mui/material';
const SmokeCheck = () => {

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