import { useEffect, useState } from "react";
import { getAllTodos, getUserDetails } from "../api/TodosApi.js";
import { Box } from "@mui/material";
import { DataGrid } from "@mui/x-data-grid";
import UserModal from "./UserModal.jsx";

const TodosScreen = () => {

    const [todos, setTudos] = useState(undefined);
    const [modalData, setModalData] = useState(undefined);

    const columns = [
        {field: "id", headerName: "ID"},
        {field: "userId", headerName: "userId"},
        {field: "title", headerName: "Title", width: 400},
        {field: "completed", headerName: "Completed"}
    ];

    useEffect(() => {
        getAllTodos()
            .then(result => result.json())
            .then(result => setTudos(result));
    }, []);

    const onCellClick = (cellInfo) => {
        const userId = cellInfo.row.userId;
        getUserDetails(userId)
            .then(result => result.json())
            .then(userData => setModalData({
                todo: cellInfo.row,
                userData: userData
            }));
    }

    const onModalClose = () => {
        setModalData(undefined);
    }

    return (
        <Box>
            {todos === undefined && <div>There is no to do yet</div>}
            {todos && (
                <Box padding="10px">
                    <DataGrid onCellClick={onCellClick} rows={todos} columns={columns} />
                </Box>
            )}
            {modalData !== undefined && <UserModal userData={modalData.userData} todo={modalData.todo} onClose={onModalClose}/>}
        </Box>
    );
}

export default TodosScreen;