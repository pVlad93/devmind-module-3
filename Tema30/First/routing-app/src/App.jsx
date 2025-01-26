import { Route, Routes } from "react-router"
import AboutComponent from "./components/AboutComponent"
import HomeComponent from "./components/HomeComponent"
import ContactComponent from "./components/ContactComponent"
import NavbarComponent from "./components/NavbarComponent/NavbarComponent"
import HomeGitComponent from "./components/HomeGitComponent"
import ReposComponent from "./components/ReposComponent"

function App() {

  return (
    <>
      <p>App container</p>
      <NavbarComponent />
      <Routes>
        <Route path="/about" element={<AboutComponent message={"This is the about page"}/>}/>
        <Route path="/home/:userName" element={<HomeComponent/>}/>
        <Route path="/contact" element={<ContactComponent/>}/>
        <Route path="/homeGit" element={<HomeGitComponent />}/>
        <Route path="/repos" element={<ReposComponent />}/>
      </Routes>
    </>
  )
}

export default App
