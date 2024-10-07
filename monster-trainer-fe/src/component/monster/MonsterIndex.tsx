import { Button, Paper, Table, TableBody, TableCell, TableHead, TableRow } from "@mui/material";
import MonsterRow from "./MonsterRow";
import { useQuery } from "@tanstack/react-query";
import Monster from "../../types/Monster";
import { useState } from "react";
import CreateMonster from "./CreateMonster";

function MonsterIndex() {
    const [isOpen, setIsOpen] = useState(false)
    const {data, error, isLoading } = useQuery<Monster[], Error>({
        queryKey: ['monsters'],
        queryFn: async function():Promise<Monster[]> {
            const request = await fetch(import.meta.env.VITE_API_URL + "/monster/", {
                method: 'GET'
            })
            const response = await request.json()
            console.table(response)
            return response
        }
    })

    const openCreateMonster = () => setIsOpen(true)

    const closeCreateMonster = () => setIsOpen(false)

    if(isLoading) return <div>Getting all the Monsters, Please wait...</div>

    if(error) return <div>An error has occurred, Developers are hiding under the desk: {error.message}</div>

    return (
        <Paper sx={{width:'100%', overflow: 'hidden'}}>
            <Button onClick={openCreateMonster}>
                Create new Monster
            </Button>
            <CreateMonster isOpen={isOpen} onClose={closeCreateMonster} />
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
                    {
                        data?.map((monster) => (
                            <MonsterRow data={monster} />
                        ))
                    }
                </TableBody>
            </Table>
        </Paper>
    );
}

export default MonsterIndex;