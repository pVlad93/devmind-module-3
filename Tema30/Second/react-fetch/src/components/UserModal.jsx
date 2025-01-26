import { Modal, Box, Button } from "@mui/material";
import BadgeIcon from '@mui/icons-material/Badge';
import AlternateEmailIcon from '@mui/icons-material/AlternateEmail';
import LocationCityIcon from '@mui/icons-material/LocationCity';
import WorkIcon from '@mui/icons-material/Work';
import LocalPhoneIcon from '@mui/icons-material/LocalPhone';
import DomainIcon from '@mui/icons-material/Domain';
import FormatListBulletedIcon from '@mui/icons-material/FormatListBulleted';
import CheckIcon from '@mui/icons-material/Check';
import CloseIcon from '@mui/icons-material/Close';

const UserModal = (props) => {
    const userData = props.userData;
    const todo = props.todo;
    const onClose = props.onClose;

    return(
        <Modal open /*{onClose={() => onClose()}*/>
            <Box
                display="flex"
                alignItems="center"
                justifyContent="center"
                paddingTop={5}
            >
                <Box
                    bgcolor="whitesmoke"
                    widht="50%"
                    display="flex"
                    gap="5px"
                    flexDirection="column"
                    p={3}
                >
                    <Box textAlign="end">
                        <CloseIcon onClick={onClose} cursor="pointer"/>
                    </Box>

                    <Box fontWeight="bold">Person Info: </Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <BadgeIcon />
                        <span>{userData.name}</span>
                    </Box>

                    <Box width="100%" display="flex" alignItems="center">
                        <AlternateEmailIcon />
                        <span>{userData.email}</span>
                    </Box>
                    
                    <Box width="100%" display="flex" alignItems="center">
                        <LocationCityIcon />
                        <span>{`${userData.address.city}: ${userData.address.street}`}</span>
                    </Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <DomainIcon />
                        <span>{userData.website}</span>
                    </Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <LocalPhoneIcon />
                        <span>{userData.phone}</span>
                    </Box>

                    <Box my={2} width="100%" height="1px" bgcolor="#fafafa" />


                    <Box fontWeight="bold" py={1}>Company Info:</Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <WorkIcon color="success" />
                        <span>{userData.company.name}</span>
                    </Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <BadgeIcon />
                        <span>{userData.company.bs}</span>
                    </Box>
 
                    <Box my={2} width="100%" height="1px" bgcolor="#fafafa" />

                    <Box fontWeight="bold" py={1}>Todo Info:</Box>
                    <Box width="100%" display="flex" alignItems="center">
                        <FormatListBulletedIcon />
                        <span>{todo.title}</span>
                        {todo.completed ? <CheckIcon color="success" /> : <CloseIcon color="error" />}
                    </Box>

                    {/* <Button variant="contained" onClick={onClose}>Close Modal</Button> */}

                </Box>
            </Box>
        </Modal>
    )
}

export default UserModal;