import React from 'react';
import styled from 'styled-components'

import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormControl from '@mui/material/FormControl';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';

let Hello = styled.div`
 border: solid 7px black;
  border-radius:40px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  ` 
  


function MyPageWithdrawal() {
    const [showPassword, setShowPassword] = React.useState(false);

  const handleClickShowPassword = () => setShowPassword((show) => !show);

  const handleMouseDownPassword = (event: React.MouseEvent<HTMLButtonElement>) => {
    event.preventDefault();
  };
    return (
        <Hello style={{width:'50%',height:'80%',overflow: 'auto'}}>
            <div  style={{display:'flex', justifyContent:'center', alignItems:'center' }}>
                Password : 

                <FormControl sx={{ m: 1, width: '25vw', color:'black' }} variant="outlined">
                <InputLabel htmlFor="outlined-adornment-password">Password</InputLabel>
                <OutlinedInput
                    id="outlined-adornment-password"
                    type={showPassword ? 'text' : 'password'}
                    
                    endAdornment={
                    <InputAdornment position="end">
                        <IconButton
                        aria-label="toggle password visibility"
                        onClick={handleClickShowPassword}
                        onMouseDown={handleMouseDownPassword}
                        edge="end"
                        >
                        {showPassword ? <VisibilityOff /> : <Visibility />}
                        </IconButton>
                    </InputAdornment>
                    }
                    label="Password"
                />
                </FormControl>

            </div>
                <Button variant="outlined">회원탈퇴</Button>
        </Hello>
    );
 };
  
 export default MyPageWithdrawal;