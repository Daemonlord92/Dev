import { TableCell, TableRow } from "@mui/material";
import Monster from "../../types/Monster";
import { useNavigate } from "react-router-dom";

function MonsterRow({data}:{data:Monster}) {
    const navigate = useNavigate()
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
            <TableCell>
                <a onClick={() => navigate("/update", {state: data})}>Update Monster</a>
            </TableCell>
        </TableRow>
    );
}

export default MonsterRow;