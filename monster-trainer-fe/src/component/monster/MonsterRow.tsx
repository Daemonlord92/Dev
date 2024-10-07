import { TableCell, TableRow } from "@mui/material";
import Monster from "../../types/Monster";

function MonsterRow({data}:{data:Monster}) {
    const {id, name, species, attackPower, defensePower, price} = data
    return (
        <TableRow key={id} hover tabIndex={-1}>
            <TableCell>
                {name}
            </TableCell>
            <TableCell>
                {species}
            </TableCell>
            <TableCell>
                {attackPower}
            </TableCell>
            <TableCell>
                {defensePower}
            </TableCell>
            <TableCell>
                $ {price}
            </TableCell>
        </TableRow>
    );
}

export default MonsterRow;