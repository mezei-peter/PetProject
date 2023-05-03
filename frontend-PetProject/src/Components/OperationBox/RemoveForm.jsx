import {useEffect, useRef, useState} from "react";

function RemoveForm({treeRoot, setTreeRoot}) {
    const petToRemoveId = useRef("");
    const [petMap, setPetMap] = useState(new Map());

    const handleSubmit = async () => {
        if (!petToRemoveId.current) {
            return;
        }
        const response = await fetch(`/api/tree/test/${petToRemoveId.current}`, {method: "DELETE"});
        const data = await response.json();
        setTreeRoot(data);
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
        <form id="ob-form" onSubmit={async (event) => {
            event.preventDefault();
            await handleSubmit();
        }}>
            <h2>Remove pet</h2>
            <label htmlFor="pets-select">Pet to remove: </label>
            <select name="pet-to-remove" id="pet-select"
                    onChange={event => petToRemoveId.current = event.target.value}>
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
