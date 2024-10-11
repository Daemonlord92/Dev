import { Box, Button, FormControl, Input, InputLabel } from "@mui/material";
import { useFormik } from "formik";
import { useNavigate } from "react-router-dom";

function Register() {
    const navigate = useNavigate();

    const formik = useFormik({
        initialValues: {
            email: '',
            password: '',
            role: "USER"
        },
        onSubmit: async (values) => {
            const request = await fetch(import.meta.env.VITE_API_URL + "/auth/register", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(values)
            })

            if(!request.ok){
                const errorMessage = await request.text()
                throw new Error(errorMessage)
            } else {
                alert("New User has been created")
                navigate('/login')
            }
        }
    });

    return (
        <Box
            component="form"
            onSubmit={formik.handleSubmit}
            sx={{
                display: 'flex',
                flexDirection: 'column',
                alignItems: 'center',
                justifyContent: 'center',
                height: '100vh', // Center vertically
                backgroundColor: '#f5f5f5', // Light background
                padding: 3
            }}
        >
            <Box
                sx={{
                    display: 'flex',
                    flexDirection: 'column',
                    alignItems: 'center',
                    width: '100%',
                    maxWidth: '400px', // Width constraints
                    gap: 3 // Spacing between elements
                }}
            >
                <FormControl fullWidth>
                    <InputLabel htmlFor="email">Email</InputLabel>
                    <Input
                        id="email"
                        value={formik.values.email}
                        onChange={formik.handleChange}
                        onBlur={formik.handleBlur}
                    />
                </FormControl>

                <FormControl fullWidth>
                    <InputLabel htmlFor="password">Password</InputLabel>
                    <Input
                        id="password"
                        type="password"
                        value={formik.values.password}
                        onChange={formik.handleChange}
                        onBlur={formik.handleBlur}
                    />
                </FormControl>

                <Button
                    type="submit"
                    variant="contained"
                    color="primary"
                    fullWidth
                    sx={{ padding: '10px 0', fontWeight: 'bold' }}
                >
                    Sign Up
                </Button>
            </Box>
        </Box>
    );
}

export default Register;
