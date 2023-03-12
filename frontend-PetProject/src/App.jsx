import './App.css';

import Header from './Components/Header/Header';
import OperationBox from './Components/OperationBox/OperationBox';
import PetRenderOptions from './Components/PetRenderOptions/PetRenderOptions';
import PetTree from './Components/PetTree/PetTree';
import Footer from './Components/Footer/Footer';
import {useState} from "react";

const emptyTreeRoot = {invisible: true, name: "", weight: -1, leftChild: null, rightChild: null};

function App() {
    const [treeRoot, setTreeRoot] = useState(emptyTreeRoot);

    return (
        <>
            <Header/>
            <OperationBox setTreeRoot={setTreeRoot}/>
            <PetRenderOptions/>
            <PetTree root={treeRoot} emptyRoot={emptyTreeRoot} setRoot={setTreeRoot}/>
            <Footer/>
        </>

    );
}

export default App;
