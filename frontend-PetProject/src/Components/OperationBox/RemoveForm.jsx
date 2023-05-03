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

    useEffect(() => {
        //TODO
        async function fetchPetSet() {
            const response = await fetch("/api/tree/test?convert=set");
        }
        fetchPetSet();
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
