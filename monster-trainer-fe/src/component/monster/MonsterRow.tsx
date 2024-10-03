import { TableCell, TableRow } from "@mui/material";

function MonsterRow() {
    return (
        <TableRow hover tabIndex={-1}>
            <TableCell>
                Skully
            </TableCell>
            <TableCell>
                Flying Skull
            </TableCell>
            <TableCell>
                15
            </TableCell>
            <TableCell>
                5
            </TableCell>
            <TableCell>
                $ 50.00
            </TableCell>
        </TableRow>
    );
}

export default MonsterRow;