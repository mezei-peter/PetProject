import './OperationBox.css';
import AddForm from "./AddForm.jsx";

function OperationBox({setTreeRoot}) {


    return(
        <div id="component-operation-box">
            <div className="operation-box">
                <nav id="ob-options">
                    <button className="ob-option">Add</button>
                    <button className="ob-option">Remove</button>
                    <button className="ob-option">Find</button>
                    <button className="ob-option">Update</button>
                </nav>
                <div id="ob-selected-option">
                    <button className="ob-side-arrow">&#60;</button>
                    <AddForm setTreeRoot={setTreeRoot}/>
                    <button className="ob-side-arrow">&#62;</button>
                </div>
            </div>
        </div>
    );
}

export default OperationBox;