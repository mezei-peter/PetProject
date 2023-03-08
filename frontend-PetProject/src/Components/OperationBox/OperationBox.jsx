import './OperationBox.css';

function OperationBox() {
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
                    <form id="ob-form" onSubmit={event => {
                        event.preventDefault();
                    }}>
                        <h2>Add pet</h2>
                        <input type="text" name="ob-form-name" id="ob-form-name" placeholder="name"/>
                        <input type="text" name="ob-form-weight" id="ob-form-weight" placeholder="weight"/>
                        <button>Add</button>
                    </form>
                    <button className="ob-side-arrow">&#62;</button>
                </div>
            </div>
        </div>
    );
}

export default OperationBox;