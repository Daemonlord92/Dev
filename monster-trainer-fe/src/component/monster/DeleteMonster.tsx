import { Box, Button, ButtonGroup, Modal, Typography } from "@mui/material";
import { useMutation, useQueryClient } from "@tanstack/react-query";


function DeleteMonster({id, open, closeModal, openModal}:{id:number, open:boolean, closeModal:()=>void, openModal:()=>void}) {

    const queryClient = useQueryClient();

    const deleteMonster = async () => {
        const request = await fetch(import.meta.env.VITE_API_URL + "/monster/delete/" + id, {
            method: 'DELETE',
            headers: {
                "Authorization": "Bearer " + sessionStorage.getItem("Authorization")
            }
        })
        const response = request.json()
        return response;
    }

    const mutation = useMutation({
        mutationFn: deleteMonster,
        onSuccess:() => {
            alert("Monster has been deleted")
            queryClient.invalidateQueries()
            closeModal()
        }
    })

    return (
        <>
            <Button onClick={openModal}>
                Delete Monster
            </Button>
            <Modal
                open={open}
                onClose={closeModal}
                >
                   <Box color={"white"} bgcolor={"black"} sx={{my:10, mx:'auto', maxWidth: '40%'}}>
                        <Typography variant="h4">
                            Do you want to delete this Monster
                        </Typography>
                        <br />
                        <ButtonGroup variant="contained">
                            <Button onClick={() => mutation.mutate()}>
                                Yes
                            </Button>
                            <Button onClick={() => closeModal()}>
                                No
                            </Button>
                        </ButtonGroup>
                    </Box> 
                </Modal>
        </>
    );
}

export default DeleteMonster;