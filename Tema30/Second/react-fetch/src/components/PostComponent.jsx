import { useEffect, useState } from "react";
import { Box } from "@mui/material";
import { DataGrid } from "@mui/x-data-grid";
import { getAllPosts, getPostComments } from "../api/PostsApi";
import CommentsModal from "./CommentsModal.jsx";

const PostComponent = () => {

    const [posts, setPosts] = useState(undefined);
    const [modalData, setModalData] = useState(undefined);

    const columns = [
        {field: "id", headerName: "Comment id"},
        {field: "userId", headerName: "User id"},
        {field: "title", headerName: "Post title", width: 500},
        {field: "body", headerName: "Post body", width: 750}
    ]

    useEffect(() => {
        getAllPosts()
            .then(response => {
                if(response.ok) {
                    return response.json();
                }
            })
            .then((posts) => {
                setPosts(posts);
            });
    }, []);

    const onCellClick = (cellInfo) => {
        getPostComments(cellInfo.row.id)
            .then(response => response.json())
            .then(comments => {
                setModalData({
                    title: cellInfo.row.title,
                    post: cellInfo.row.body,
                    comments: comments
                });
            })
            .catch((error) => {
                console.log(error);
            })
    }

    const onModalClose = () => {
        setModalData(undefined);
    }

    return (
        <Box width="100%" height="100%" display="flex" justifyContent="center">
            {posts === undefined && <div>There are no posts yet</div>}
            {posts && (
                <Box width="80%">
                    <DataGrid onCellClick={onCellClick} rows={posts} columns={columns} getRowHeight={() => 'auto'}/>
                </Box>
            )}
            {modalData !== undefined && <CommentsModal comments={modalData.comments} post={modalData.post} title={modalData.title} onClose={onModalClose}/>}
        </Box>
    )
};

export default PostComponent;