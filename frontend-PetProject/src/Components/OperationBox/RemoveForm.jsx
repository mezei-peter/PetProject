import {useEffect, useRef} from "react";

function RemoveForm({treeRoot}) {
    const petToRemove = useRef("");
    let petMap = new Map();

    const handleSubmit = () => {
        if (!petToRemove.current) {
            return;
        }
        //TODO
    };

    useEffect(() => {
        async function fetchPetSet() {
            const response = await fetch("/api/tree/test/set");
            if (response.status !== 200) {
                return null;
            }
            const data = await response.json();
            return data;
        }
        fetchPetSet().then(data => {
            if (data) {
                data.forEach(node => petMap.set(node.name, node));
            }
        });

        return () => petMap = new Map();
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
