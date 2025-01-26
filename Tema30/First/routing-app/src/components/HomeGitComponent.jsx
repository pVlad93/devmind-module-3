import { useEffect, useState } from "react";
import { getUser } from "../api/ApiCalls";

const HomeGitComponent = (props) => {

    const [gitInfo, setGitInfo] = useState(undefined);
    
    useEffect(() => {
        getUser("pVlad93")
            .then(response => {
                if (response.ok) {
                    return response.json();
                }
                throw new Error('Something went wrong');
            })
            .then(result => setGitInfo(result))
            .catch((error) => {
                console.log(error);
            })
    }, [])

    let myGitData = gitInfo;

    return (
        <div>
            {gitInfo === undefined && <p>Data not loaded yet</p>}
            {gitInfo && (
                <div>
                <h1>These are my Git details</h1>
                <p>Name: {gitInfo.name}</p>
                <p>Public repos: {gitInfo.public_repos}</p>
                <p>Followers: {gitInfo.followers}</p>
                <p>Following: {gitInfo.following}</p>
                <p>Avatar: </p>
                <img 
                    src={gitInfo.avatar_url}
                    alt="new"
                />
                </div>
            )}
        </div>
    )
};

export default HomeGitComponent;