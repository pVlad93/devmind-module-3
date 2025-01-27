export const ADD_NOTE = "ADD_NOTE";
export const DELETE_NOTE = "DELETE_NOTE";
export const MODIFY_NOTE = "MODIFY_NOTE";

export const addNote = (title, description) => {
    return {
        type: ADD_NOTE,
        payload: {
            title: title,
            description: description
        }
    }
}

export const deleteNote = (index) => {
    return {
        type: DELETE_NOTE,
        payload: {
            id: index
        }
    }
}

export const modifyNote = (index, title, description) => {
    return {
        type: MODIFY_NOTE,
        payload: {
            id: index,
            title: title,
            description: description
        }
    }
}