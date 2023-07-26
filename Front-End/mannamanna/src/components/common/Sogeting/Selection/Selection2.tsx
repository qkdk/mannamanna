import * as React from "react";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormHelperText from "@mui/material/FormHelperText";
import FormControl from "@mui/material/FormControl";
import Select, { SelectChangeEvent } from "@mui/material/Select";
import { isNonNullExpression } from "typescript";

export default function SelectionObj2() {
  const [alcohol, setAlcohol] = React.useState("");

  const handleChange = (event: SelectChangeEvent) => {
    setAlcohol(event.target.value);
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
      <InputLabel id="demo-simple-select-helper-label">음주</InputLabel>
      <Select
        labelId="demo-simple-select-helper-label"
        id="demo-simple-select-helper"
        value={alcohol}
        label="음주"
        onChange={handleChange}
      >
        <MenuItem value={0}>음주</MenuItem>
        <MenuItem value={1}>비음주</MenuItem>
      </Select>
    </FormControl>
  );
}
