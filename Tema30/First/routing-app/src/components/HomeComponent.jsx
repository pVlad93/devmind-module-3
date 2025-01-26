import { useNavigate, useParams } from "react-router";

const HomeComponent = (props) => {

    const navigate = useNavigate();
    const params = useParams();

    const userName = params.userName ?? "Default user";

    return (
        <>
            <h3>{`Hello, ${userName}!`}</h3>
            <h1>Welcome to my page!</h1>
            <h2>This is my personal portofolio website!</h2>
            <button onClick={() => navigate("/about?userName=" + userName)}>Navigate to about section</button>
        </>
    )
}

export default HomeComponent;