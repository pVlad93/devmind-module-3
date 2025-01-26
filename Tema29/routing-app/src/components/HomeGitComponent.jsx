const HomeGitComponent = (props) => {
    return (
        <div>
            <h1>These are my Git details</h1>
            <p>Name: {props.info.name}</p>
            <p>Public repos: {props.info.public_repos}</p>
            <p>Followers: {props.info.followers}</p>
            <p>Following: {props.info.following}</p>
            <p>Avatar: </p>
            <img 
                src={props.info.avatar_url}
                alt="new"
            />
        </div>
    )
};

export default HomeGitComponent;