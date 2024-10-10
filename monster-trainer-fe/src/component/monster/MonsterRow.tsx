import { TableCell, TableRow } from "@mui/material";
import Monster from "../../types/Monster";
import { useNavigate } from "react-router-dom";
import DeleteMonster from "./DeleteMonster";
import { useState } from "react";

function MonsterRow({data}:{data:Monster}) {
    const navigate = useNavigate()
    const {id, name, species, attackPower, defensePower, price} = data

    const [open, setOpen] = useState(false)

    const openModal = () => setOpen(true)
    const closeModal = () => setOpen(false)

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
            <TableCell>
                <DeleteMonster id={id} open={open} openModal={openModal} closeModal={closeModal} />
            </TableCell>
        </TableRow>
    );
}

export default MonsterRow;