import { Route, Routes } from "react-router"
import AboutComponent from "./components/AboutComponent"
import HomeComponent from "./components/HomeComponent"
import ContactComponent from "./components/ContactComponent"
import NavbarComponent from "./components/NavbarComponent/NavbarComponent"
import HomeGitComponent from "./components/HomeGitComponent"
import { myInfo, gitRepoInfo} from "./MyInfo"
import ReposComponent from "./components/ReposComponent"
import { RepositoryDetails } from "./components/RepositoryDetails"

function App() {

  return (
    <>
      <p>App container</p>
      <NavbarComponent />
      <Routes>
        <Route path="/about" element={<AboutComponent message={"This is the about page"}/>}/>
        <Route path="/home/:userName" element={<HomeComponent/>}/>
        <Route path="/contact" element={<ContactComponent/>}/>
        <Route path="/" element={<HomeGitComponent info={myInfo}/>}/>
        <Route path="/homeGit" element={<HomeGitComponent info={myInfo}/>}/>
        <Route path="/repos" element={<ReposComponent info={gitRepoInfo}/>}/>
        <Route path="/repos/:reposId" element={<RepositoryDetails info={gitRepoInfo}/>}/>
      </Routes>
    </>
  )
}

export default App
