import { useState } from "react";

const WelcomeMessage = (props) => {

    const [message, setMessage] = useState('Please wait...');

    setTimeout(() => {
        setMessage("Welcome to Devmind");
    }, 3000);

    return (
        <div>
            <p>{message}</p>
        </div>
    );
}

export default WelcomeMessage;