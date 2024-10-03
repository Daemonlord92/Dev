import { Paper, Table, TableBody, TableCell, TableHead, TableRow } from "@mui/material";
import MonsterRow from "./MonsterRow";

function MonsterIndex() {
    return (
        <Paper sx={{width:'100%', overflow: 'hidden'}}>
            <Table stickyHeader>
                <TableHead>
                    <TableRow>
                        <TableCell>
                            Name
                        </TableCell>
                        <TableCell>
                            Species
                        </TableCell>
                        <TableCell>
                            Attack Power
                        </TableCell>
                        <TableCell>
                            Defense Power
                        </TableCell>
                        <TableCell>
                            Price
                        </TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    <MonsterRow/>
                </TableBody>
            </Table>
        </Paper>
    );
}

export default MonsterIndex;