import { useDispatch } from "react-redux";
import { deleteNote, modifyNote } from "../../redux/actions/actions";
import { useState } from "react";

const Note = (props) => {

    const [editState, setEditState] = useState(false);
    const [inputs, setInputs] = useState({});

    const dispatch = useDispatch();

    const deleteButton = () => {
        dispatch(deleteNote(props.noteKey));
    }

    const editButton = () => {
        setEditState(true);
    }

    const handleSubmit = (event) => {
        event.preventDefault();
        const title = inputs.title;
        const description = inputs.description;
        const noteId = inputs.id;
        dispatch(modifyNote(noteId, title, description));
        setEditState(false);
    }

    const handleChange = (event) => {
        console.log(props.noteKey);
        const name = event.target.name;
        const value = event.target.value;
        setInputs(values => ({...values, [name]: value, "id": props.noteKey}));
      }

    return (
        <div style={{
            width: "240px",
            height: "240px",
            background: "#f5b042",
            borderRadius: "20px",
            overflowY: "auto",
            margin: "4px",
            padding: "10px"
        }}>
            {
            editState !== undefined && editState === false ?
                <div>
                    <button onClick={deleteButton}>Delete note</button>
                    <button onClick={editButton}>Edit note</button>
                    <h3>{props.title}</h3>
                    <span style={{marginTop: "8px"}}>{props.description}</span>
                </div>
                :
                <div>
                    <form onSubmit={handleSubmit}>
                        <label>
                            Title
                            <br/>
                            <input type="text" 
                                placeholder={props.title} 
                                name="title" 
                                onChange={handleChange}/>
                        </label>
                        <label>
                            Description
                            <input type="text" 
                                placeholder={props.description} 
                                name="description" 
                                onChange={handleChange}/>
                        </label>
                        <input type="submit" value="Save note"/>
                    </form>
                </div>
            }
        </div>
    );
}

export default Note;