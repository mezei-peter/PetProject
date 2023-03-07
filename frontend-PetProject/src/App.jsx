import './App.css';

import Header from './Components/Header/Header';
import OperationBox from './Components/OperationBox/OperationBox';
import PetRenderOptions from './Components/PetRenderOptions/PetRenderOptions';
import PetTree from './Components/PetTree/PetTree';
import Footer from './Components/Footer/Footer';

function App() {
  return (
    <>
      <Header/>
      <OperationBox/>
      <PetRenderOptions/>
      <PetTree/>
      <Footer/>
    </>
    
  );
}

export default App;
