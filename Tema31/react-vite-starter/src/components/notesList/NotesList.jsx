import { useSelector } from "react-redux";
import Note from "../note/Note";
import { useEffect } from "react";

const NotesList = () => {
    const notes = useSelector((state) => state.notes);
    const warnings = useSelector((state) => state.warnings);

    useEffect(() => {
        console.log(warnings);
    });

    return(
        <div style={{
            width: "100%",
            display: "flex",
            flexWrap: "wrap",
            justifyContent: "space-evenly",
            rowGap: "10px"
        }}>
            {notes && notes.map((note,idx) => <Note key = {idx} title = {note.title} description = {note.description} noteKey = {idx}/>)}
        </div>
    );
}

export default NotesList;