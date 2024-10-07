import { Box, Button, FormControl, Input, InputLabel } from "@mui/material";
import { useFormik } from "formik";


function CreateMonster({isOpen, onClose}: {isOpen:boolean, onClose:()=>void}) {

    const formik = useFormik({
        initialValues:{
            name: '',
            species: '',
            weight: 0,
            height: 0,
            price: 0,
            attackPower: 0,
            defensePower: 0
        },
        onSubmit: (values) => {

        }
    })

    if(!isOpen) return null

    return (
        <Box component="form">
            <FormControl sx={{my: 1}}>
                <InputLabel htmlFor="name">
                    Name:
                </InputLabel>
                <Input id="name"
                 value={formik.values.name} 
                 onChange={formik.handleChange}
                 onBlur={formik.handleBlur} />
            </FormControl>
            <FormControl sx={{my: 1}}>
                <InputLabel htmlFor="species">
                    Species:
                </InputLabel>
                <Input id="species"
                 value={formik.values.species} 
                 onChange={formik.handleChange}
                 onBlur={formik.handleBlur} />
            </FormControl>
            <FormControl sx={{my: 1}}>
                <InputLabel htmlFor="weight">
                    Weight:
                </InputLabel>
                <Input id="weight"
                inputProps={{type: 'number'}}
                 value={formik.values.weight} 
                 onChange={formik.handleChange}
                 onBlur={formik.handleBlur} />
            </FormControl>
            <FormControl sx={{my: 1}}>
                <InputLabel htmlFor="height">
                    Height:
                </InputLabel>
                <Input id="height"
                inputProps={{type: 'number'}}
                 value={formik.values.height} 
                 onChange={formik.handleChange}
                 onBlur={formik.handleBlur} />
            </FormControl>
            <FormControl sx={{my: 1}}>
                <InputLabel htmlFor="price">
                    Price:
                </InputLabel>
                <Input id="price"
                inputProps={{type: 'number'}}
                 value={formik.values.price} 
                 onChange={formik.handleChange}
                 onBlur={formik.handleBlur} />
            </FormControl>
            <FormControl sx={{my: 1}}>
                <InputLabel htmlFor="attack-power">
                Attack Power:
                </InputLabel>
                <Input id="attack-power"
                inputProps={{type: 'number'}}
                 value={formik.values.attackPower} 
                 onChange={formik.handleChange}
                 onBlur={formik.handleBlur} />
            </FormControl>
            <FormControl sx={{my: 1}}>
                <InputLabel htmlFor="defense-power">
                    Defense Power:
                </InputLabel>
                <Input id="defense-power"
                inputProps={{type: 'number'}}
                 value={formik.values.defensePower} 
                 onChange={formik.handleChange}
                 onBlur={formik.handleBlur} />
            </FormControl>
            <Button type="submit">
                Submit New Monster
            </Button>
        </Box>
    );
}

export default CreateMonster;