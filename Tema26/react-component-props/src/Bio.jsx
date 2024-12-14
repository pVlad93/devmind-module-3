const Bio = (props) => {
    return(
        <div style={{ width: "75%" }}>
          <h5>Data nasterii: {props.dataNasterii}</h5>
          <h5>Descriere: {props.descriere}</h5>
          <h5>Hobby-uri: {props.hobby.join(", ")} </h5>
          <h5>Programmer: {isProgrammer(props.hobby) ? "TRUE" : "FALSE"}</h5>
        </div>
    );
}

const isProgrammer = (hobby) => {
    return hobby.includes("Java", "React");
}
export default Bio;