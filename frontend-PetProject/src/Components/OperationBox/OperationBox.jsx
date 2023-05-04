import './OperationBox.css';
import AddForm from "./AddForm.jsx";
import RemoveForm from "./RemoveForm";
import {useState} from "react";

class OperationControl {
    constructor(name, form) {
        this.name = name;
        this.form = form;
    }
}

function OperationBox({treeRoot, setTreeRoot, emptyTreeRoot}) {
    const operationControls = [
        new OperationControl("Add", <AddForm setTreeRoot={setTreeRoot}/>),
        new OperationControl("Remove", <RemoveForm treeRoot={treeRoot} setTreeRoot={setTreeRoot}
                                                   emptyTreeRoot={emptyTreeRoot}/>),
    ];
    const [currentFormIndex, setCurrentFormIndex] = useState(0);

    const nextFormIndex = () => {
        setCurrentFormIndex(currentFormIndex + 1 < operationControls.length ? currentFormIndex + 1 : 0);
    };
    const prevFormIndex = () => {
        setCurrentFormIndex(currentFormIndex - 1 >= 0 ? currentFormIndex - 1 : operationControls.length - 1);
    };

    return (
        <div id="component-operation-box">
            <div className="operation-box">
                <nav id="ob-options">
                    {operationControls.map((oc, ocIndex) => {
                        let classList = "ob-option";
                        if (currentFormIndex === ocIndex) {
                            classList = classList.concat(" highlight");
                        }
                        return <button key={oc.name} className={classList}
                                       onClick={() => setCurrentFormIndex(ocIndex)}
                        >{oc.name}</button>
                    })}
                </nav>
                <div id="ob-selected-option">
                    <button className="ob-side-arrow" onClick={prevFormIndex}>&#60;</button>
                    {operationControls[currentFormIndex].form}
                    <button className="ob-side-arrow" onClick={nextFormIndex}>&#62;</button>
                </div>
            </div>
        </div>
    );
}

export default OperationBox;