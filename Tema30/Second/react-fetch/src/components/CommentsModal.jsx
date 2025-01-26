import { Modal, Box } from "@mui/material";
import CloseIcon from '@mui/icons-material/Close';

const CommentsModal = (props) => {
    const comments = props.comments;
    const post = props.post;
    const title = props.title;
    const onClose = props.onClose;
    
    return (
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

                    <Box>Title: {title}</Box>
                    <Box>Body: {post}</Box>
                    <Box fontWeight="bold">Comments to the post: </Box>
                    <Box width="100%" display="flex" alignItems="center">
                        {
                             <div>
                             {comments.map(comment => (
                                 <p key={comment.id}>{comment.id}: {comment.body}</p>
                             ))}
                         </div>
                        }
                    </Box>


                </Box>
            </Box>
        </Modal>
    )
}

export default CommentsModal;