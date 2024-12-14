import Badge from './Badge';
import React from 'react';
import './App.css'
import Bio from './Bio';

const badges = [
  {
    firstName: "Johhny",
    lastName: "Depp",
    img: "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRIMJf32XCdIMPR005aLZbkk5TldBubjW2CfA&usqp=CAU",
    dataNasterii: "01.01.1984",
    descriere: "E un pirat",
    hobby: [
      "Pescuit",
      "Glume"
    ]
  },
  {
    firstName: "Tommy",
    lastName: "Williams",
    img: "https://thumbs.dreamstime.com/b/default-avatar-photo-placeholder-profile-icon-eps-file-easy-to-edit-default-avatar-photo-placeholder-profile-icon-124557887.jpg",
    dataNasterii: "22.02.1990",
    descriere: "Un om",
    hobby: [
      "Jocuri de societate",
      "Java",
      "Calatorii"
    ]
  },
  {
    firstName: "Tommy2",
    lastName: "Williams2",
    img: "https://thumbs.dreamstime.com/b/default-avatar-photo-placeholder-profile-icon-eps-file-easy-to-edit-default-avatar-photo-placeholder-profile-icon-124557887.jpg",
    dataNasterii: "31.12.2000",
    descriere: "Doctor",
    hobby: [
      "Sport",
      "Gatit"
    ]
  }
];
 
class App extends React.Component {
  
  render() {
    return (
      <div id="container">
        {badges.map(e => (
          <Badge
            firstName={e.firstName}
            lastName={e.lastName}
            avatarImage={e.img}
            dataNasterii={e.dataNasterii}
            descriere={e.descriere}
            hobby={e.hobby}
        />
        ))}
      </div>
    );
  }
}

export default App
