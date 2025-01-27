import AddNote from "./components/addNote/AddNote";
import NotesList from "./components/notesList/NotesList";

import { useState } from "react";


function App() {
  return (
    <>
      <NotesList/>
      <AddNote/>
    </>
  )
}

export default App