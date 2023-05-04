# PetPro# PetProject

## Intro
My personal fullstack project with React.js and Java Spring. Users can organize their
pets into tree structures and perform various operations on the data. I am planning to
add community features, such as sharing Pet Trees and liking them. Currently it is in a quite early phase.

## Usage
To run the frontend: 
```bash
cd frontend-PetProject/
npm i
npm run dev
```

To run the backend: 
```bash
cd backend-PetProject/
mvn clean package -DskipTests
java -jar target/backend-PetProject-0.0.1-SNAPSHOT.jar
```

#### Early build screenshot
![Screenshot of a pet tree editing page from an early Pet Project version.](/screenshots/pet-project-early.png)

## Used technologies
- Java
  - Spring Boot
- Javascript
  - React.js
The frontend and the backend communicate with each other through HTTP requests.

## Features 
- User has pets.
- The name and weight of pets is stored in a binary tree structure, rendered on the frontend.
- User can add pet to the tree.
  - *The algorithm currently looks for the highest level with an empty space and inserts the new pet into the leftmost position.*
- User can remove pet from the tree.
  - *The algorithm currenty works like this: If the requested node is a leaf node, it gets removed. Otherwise, the node is swapped with its left child (if no left child present, then right child) until the requested node becomes a leaf node.*
- User can drag and zoom into the tree rendering window.
- Responsive frontend.

#### Planned features
- Prettier UI.
- More CRUD operations on pets: update.
- Storing and restructuring trees into more complex structures: *binary search tree* or *red-black tree*.
- Login system.
- Ability to save a pet tree to the user's pet tree library.
- Browsing other users' pet trees.
- Image of pet changes based on its weight (e.g. 4kg - cat, 80kg - pig, 100.000kg+ - whale).

