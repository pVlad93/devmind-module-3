import "./table.css";
import { tableHelper } from "../helpers/helpers";
import { useEffect, useState } from "react";
import { getUserRepos } from "../api/ApiCalls";

const ReposComponent = () => {

    const [repos, setRepos] = useState([]);

    useEffect(() => {
        getUserRepos("pVlad93")
            .then(response => {
                if(response.ok) {
                    return response.json();
                }
                throw new Error("Something went wrong");
            })
            .then(result => {
                setRepos(tableHelper(result));
            })
            .catch((error) => {
                console.log(error);
            })
        }
    )

    return (
        <div>
            {repos === undefined && <p>Data not yet loaded</p>}
            {repos && (
                <table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Repo name</th>
                            <th>Owner name</th>
                            <th>Repo link</th>
                            <th>Repo description</th>
                            <th>Default branch</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            repos.map((row) => (
                                <tr key={row.id}>
                                    <td>{row.id}</td>
                                    <td>{row.name}</td>
                                    <td>{row.ownerName}</td>
                                    <td>{row.repoDescription}</td>
                                    <td><a href={row.link} target="_blank">{row.link}</a></td>
                                    <td>{row.defaultBranch}</td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
                )
            }
        </div>
    )
}

export default ReposComponent;
