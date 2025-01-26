import { Link } from "react-router";
import "./navbar.css";

const NavbarComponent = () => {
    return (
        <div class="nav-container">
            <Link class="nav-link" to={"/home/anonymous"}>Home</Link>
            <Link class="nav-link" to={"/about?username=anonymous"}>About</Link>
            <Link class="nav-link" to={"/contact"}>Contact</Link>
        </div>
    )
}

export default NavbarComponent;