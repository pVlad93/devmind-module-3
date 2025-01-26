import React from "react";
import { Navigate } from "react-router";

class ContactComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            shouldNavigate: false
        }
    }

    render() {
        return (
            <>
                {this.state.shouldNavigate && 
                    <Navigate to="/about" replace={false} />
                }
                <button onClick={() => this.setState({shouldNavigate: true})}>
                    Go to about section
                </button>
            </>
        )
    }
}

export default ContactComponent;