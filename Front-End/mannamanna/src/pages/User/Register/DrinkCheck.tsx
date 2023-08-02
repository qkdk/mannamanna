import React, { useState } from 'react';
import { Switch } from '@mui/material';
const DrinkCheck = () => {

    const [drinkingChecked, setDrinkingChecked] = useState(false);
    const handleDrinkingClick = () => {
        setDrinkingChecked(!drinkingChecked);
      };
    return (
        <Switch
        checked={drinkingChecked}
        onClick={handleDrinkingClick}
        inputProps={{ 'aria-label': 'controlled' }}
      />
    );
};

export default DrinkCheck;