import React from 'react';
import styled from 'styled-components'
import MacBookBox from '../../../components/common/macbookBox';

import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import InputAdornment from '@mui/material/InputAdornment';
import FormControl from '@mui/material/FormControl';
import Visibility from '@mui/icons-material/Visibility';
import VisibilityOff from '@mui/icons-material/VisibilityOff';
import Box from '@mui/material/Box';
import Modal from '@mui/material/Modal';

  const style = {
    position: 'absolute' as 'absolute',
    top: '50%',
    left: '50%',
    transform: 'translate(-50%, -50%)',
    width: 400,
    height: 300,
    bgcolor: 'background.paper',
    border: '0.3vw solid #000',
    borderRadius: 4,
    p: 4,
    display: 'flex',
    justifyContent: 'center', 
    alignItems: 'center',
  };

function MyPageWithdrawal() {
    const [showPassword, setShowPassword] = React.useState(false);

    const handleClickShowPassword = () => setShowPassword((show) => !show);

    const handleMouseDownPassword = (event: React.MouseEvent<HTMLButtonElement>) => {
        event.preventDefault();
    };

    const [open, setOpen] = React.useState(false);
    const handleOpen = () => setOpen(true);
    const handleClose = () => setOpen(false);

    return (
        <MacBookBox width="50%" height="80%" color1="#bcd3ff" color2="ffffff" alignItems='center'>
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
            
            <div>
            <Button variant="outlined" onClick={handleOpen}>회원탈퇴</Button>

            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-modal-title"
                aria-describedby="modal-modal-description"
            >
                <Box sx={style}>
                    정말 탈퇴하시겠습니까ㄴㄴㄴ?
                    <div>
                    <Button variant="outlined" color="warning">확인</Button>
                    <Button variant="outlined" color="error">취소</Button>
                    </div>
                </Box>
            </Modal>

            </div>


        </MacBookBox>
    );
 };
  
 export default MyPageWithdrawal;