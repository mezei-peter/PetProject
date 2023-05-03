import {useEffect, useRef, useState} from "react";

function RemoveForm({treeRoot}) {
    const petToRemove = useRef("");
    const [petMap, setPetMap] = useState(new Map());

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
                const newPetMap = new Map(petMap);
                data.forEach(node => newPetMap.set(node.uuid, node));
                setPetMap(newPetMap);
            }
        });

        return () => setPetMap(new Map());
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
                {Array.from(petMap.values())
                    .sort((a, b) => a.name.localeCompare(b.name))
                    .map(pet => {
                        return <option key={pet.uuid} value={pet.uuid}>{`${pet.name} (${pet.weight}kg)`}</option>;
                    })}
            </select>
            <button>Delete</button>
        </form>
    );
}

export default RemoveForm;
