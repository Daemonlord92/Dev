import { Box, Button, Paper, Table, TableBody, TableCell, TableHead, TableRow, Typography } from "@mui/material";
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
        <>
            <Box sx={{ height: '200px', backgroundColor: '#3f51b5', color: 'white', display: 'flex', alignItems: 'center', justifyContent: 'center', textAlign: 'center' }}>
                <Box>
                <Typography variant="h3" component="h1">
                    Welcome to the Monster Show!
                </Typography>
                <Typography variant="h5" component="p" sx={{ mt: 2 }}>
                    Explore our amazing collection of monsters.
                </Typography>
                </Box>
            </Box>
            <Paper sx={{width:'100%', overflow: 'hidden'}}>
                {sessionStorage.getItem("Authorization") ? <Button onClick={openCreateMonster}>
                    Create new Monster
                </Button> : null}
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
        </>
    );
}

export default MonsterIndex;