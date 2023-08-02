import * as React from "react";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormHelperText from "@mui/material/FormHelperText";
import FormControl from "@mui/material/FormControl";
import Select, { SelectChangeEvent } from "@mui/material/Select";
import { isNonNullExpression } from "typescript";

export default function SelectionObj4() {
  const [MBTI, setMBTI] = React.useState("");

  const handleChange = (event: SelectChangeEvent) => {
    setMBTI(event.target.value);
  };

  return (
    <FormControl
      sx={{
        mr: 3,
        ml: 3,
        mt: 2,
        mb: 2,
        // minWidth: 120,
        border: "0.2vw solid black",
        backgroundColor: "white",
        borderRadius: "5vw",
      }}
    >
      <InputLabel id="demo-simple-select-helper-label">MBTI</InputLabel>
      <Select
        labelId="demo-simple-select-helper-label"
        id="demo-simple-select-helper"
        value={MBTI}
        label="MBTI"
        onChange={handleChange}
      >
        <MenuItem value={0}>ISTJ</MenuItem>
        <MenuItem value={1}>ISFJ</MenuItem>
        <MenuItem value={2}>INFJ</MenuItem>
        <MenuItem value={3}>INTJ</MenuItem>
        <MenuItem value={4}>ISTP</MenuItem>
        <MenuItem value={5}>ISFP</MenuItem>
        <MenuItem value={6}>INFP</MenuItem>
        <MenuItem value={7}>INTP</MenuItem>
        <MenuItem value={8}>ESTP</MenuItem>
        <MenuItem value={9}>ESFP</MenuItem>
        <MenuItem value={10}>ENFP</MenuItem>
        <MenuItem value={11}>ENTP</MenuItem>
        <MenuItem value={12}>ESTJ</MenuItem>
        <MenuItem value={13}>ESFJ</MenuItem>
        <MenuItem value={14}>ENFJ</MenuItem>
        <MenuItem value={15}>ENTJ</MenuItem>
      </Select>
    </FormControl>
  );
}
