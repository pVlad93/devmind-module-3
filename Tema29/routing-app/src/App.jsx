import { Route, Routes } from "react-router"
import AboutComponent from "./components/AboutComponent"
import HomeComponent from "./components/HomeComponent"
import ContactComponent from "./components/ContactComponent"
import NavbarComponent from "./components/NavbarComponent/NavbarComponent"

function App() {

  const myInfo = {
    "login": "pVlad93",
    "id": 57827161,
    "node_id": "MDQ6VXNlcjU3ODI3MTYx",
    "avatar_url": "https://avatars.githubusercontent.com/u/57827161?v=4",
    "gravatar_id": "",
    "url": "https://api.github.com/users/pVlad93",
    "html_url": "https://github.com/pVlad93",
    "followers_url": "https://api.github.com/users/pVlad93/followers",
    "following_url": "https://api.github.com/users/pVlad93/following{/other_user}",
    "gists_url": "https://api.github.com/users/pVlad93/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/pVlad93/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/pVlad93/subscriptions",
    "organizations_url": "https://api.github.com/users/pVlad93/orgs",
    "repos_url": "https://api.github.com/users/pVlad93/repos",
    "events_url": "https://api.github.com/users/pVlad93/events{/privacy}",
    "received_events_url": "https://api.github.com/users/pVlad93/received_events",
    "type": "User",
    "user_view_type": "public",
    "site_admin": false,
    "name": null,
    "company": null,
    "blog": "",
    "location": null,
    "email": null,
    "hireable": null,
    "bio": null,
    "twitter_username": null,
    "public_repos": 0,
    "public_gists": 0,
    "followers": 0,
    "following": 1,
    "created_at": "2019-11-16T08:03:18Z",
    "updated_at": "2024-12-14T23:35:52Z"
  }
  
  return (
    <>
      <p>App container</p>
      <NavbarComponent />
      <Routes>
        <Route path="/about" element={<AboutComponent message={"This is the about page"}/>}/>
        <Route path="/home/:userName" element={<HomeComponent/>}/>
        <Route path="/contact" element={<ContactComponent/>}/>
      </Routes>
    </>
  )
}

export default App
