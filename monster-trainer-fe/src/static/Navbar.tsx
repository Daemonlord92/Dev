import { AppBar, Container, Typography } from "@mui/material";
import HiveIcon from '@mui/icons-material/Hive';

function Navbar() {
    return (
        <AppBar position="static">
            <Container maxWidth="xl">
                <HiveIcon sx={{display: { md: 'flex'}, mr:1}}/>
                <Typography
                variant="h6"
                noWrap
                component="a"
                href="/"
                sx={{
                    mr: 2,
                    display: { md: 'flex'},
                    fontFamily: 'monospace',
                    fontWeight: 700,
                    letterSpacing: '.3rem',
                    color: 'black',
                    textDecoration: 'none'
                }}
                >
                    Monster Show Hive
                </Typography>
            </Container>
        </AppBar>
    );
}

export default Navbar;