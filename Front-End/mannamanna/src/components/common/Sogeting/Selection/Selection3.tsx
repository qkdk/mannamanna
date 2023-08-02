import * as React from "react";
import InputLabel from "@mui/material/InputLabel";
import MenuItem from "@mui/material/MenuItem";
import FormHelperText from "@mui/material/FormHelperText";
import FormControl from "@mui/material/FormControl";
import Select, { SelectChangeEvent } from "@mui/material/Select";
import { isNonNullExpression } from "typescript";

export default function SelectionObj3() {
  const [religion, setReligion] = React.useState("");

  const handleChange = (event: SelectChangeEvent) => {
    setReligion(event.target.value);
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
      <InputLabel id="demo-simple-select-helper-label">종교</InputLabel>
      <Select
        labelId="demo-simple-select-helper-label"
        id="demo-simple-select-helper"
        value={religion}
        label="종교"
        onChange={handleChange}
      >
        <MenuItem value={0}>기독교</MenuItem>
        <MenuItem value={1}>천주교</MenuItem>
        <MenuItem value={2}>불교</MenuItem>
        <MenuItem value={3}>무교</MenuItem>
      </Select>
    </FormControl>
  );
}
