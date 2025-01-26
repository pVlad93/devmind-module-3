import { useParams } from "react-router";
import { tableHelper } from "../helpers/helpers";


export const RepositoryDetails = (props) => {
    const data = tableHelper(props.info);
    const params = useParams();
    const repositoryId = params.reposId ?? "";
    let repositoryDetails = [];
    let found = false;

    if (repositoryId !== "") {
        for (let current of data) {
            if (current.id == repositoryId) {
                found = true;
                repositoryDetails = current;
                break;
            }
        }
    }

    return (
        <>
            <h1>Repository with id: {repositoryId}</h1>
            { found ? 
                <div>
                    <p>This repository belongs to the user: {repositoryDetails.ownerName}</p>
                    <p>Repository name: {repositoryDetails.name}</p>
                    <p>Repository description: {repositoryDetails.repoDescription}</p>
                    <p>Link to the repository: <a href={repositoryDetails.link} target="_blank">{repositoryDetails.link}</a></p>
                </div>
                 
            :
                <p>This repository does not belong to user</p>
            }
        </>
    );
}