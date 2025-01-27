import { useState } from "react";
import { useDispatch } from "react-redux";
import { addNote } from "../../redux/actions/actions";

const AddNote = () => {

    const [title, setTitle] = useState("");
    const [description, setDescription] = useState("");

    const dispatch = useDispatch();

    const submitNote = () => {
        const newNote = addNote(title, description);
        dispatch(newNote);
        setTitle("");
        setDescription("");
    }

    return (
        <div style={{
            display: "flex",
            padding: "8px",
            justifyContent: "center"
        }}>
            <div
                style={{
                width: "50%",
                height: "200px",
                display: "flex",
                flexDirection: "column",
                alignItems: "center",
                boxSizing: "border-box"
            }}>
                <h3>Add a new Note</h3>
                <input type="text" style={{ width: "50%", marginBottom: "4px" }} placeholder="Insert title"
                    onChange={(event) => setTitle(event.target.value)}
                    value={title}/>
                <textarea type="text" style={{
                    flex: 1,
                    width: "100%",
                    marginBottom: "4px",
                    resize: "vertical"
                }}
                placeholder="Insert a description..."
                onChange={(event) => setDescription(event.target.value)}
                value={description}/>
                <button style={{ height: "24px", width: "72px" }} onClick={() => submitNote()}>Add note</button>
            </div>
        </div>
    );
}

export default AddNote;