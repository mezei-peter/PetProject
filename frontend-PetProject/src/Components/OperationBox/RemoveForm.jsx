import {useEffect, useRef} from "react";

function RemoveForm({treeRoot}) {
    const petToRemove = useRef("");
    const petData = new Set();

    const handleSubmit = () => {
        if (!petToRemove.current) {
            return;
        }
        //TODO
    };

    const breadthFirstSetFromTreeRoot = (root) => {
        //TODO
        const result = new Set();
        result.add(root);
        return result;
    };

    useEffect(() => {
        breadthFirstSetFromTreeRoot(treeRoot).forEach(node => petData.add(node));
        console.log(petData);
    }, [treeRoot]);

    return (
        <form id="ob-form" onSubmit={event => {
            event.preventDefault();
            handleSubmit();
        }}>
            <h2>Remove pet</h2>
            <label htmlFor="pets-select">Pet to remove: </label>
            <select name="pet-to-remove" id="pet-select"
                    onChange={event => petToRemove.current = event.target.value}>
                <option value="">Select pet</option>
                <option value="TEST">TEST</option>
                //TODO: Render all pet names and uuids here
            </select>
            <button>Delete</button>
        </form>
    );
}

export default RemoveForm;
