import {useEffect, useRef, useState} from "react";

function RemoveForm({treeRoot, setTreeRoot, emptyTreeRoot}) {
    const petToRemoveId = useRef("");
    const [petMap, setPetMap] = useState(new Map());

    const fetchPetSet = async () => {
        const response = await fetch("/api/tree/test/set");
        return response;
    }

    const refreshPetMap = () => {
        fetchPetSet().then(res => {
            switch (res.status) {
                case 200:
                    res.json().then(data => {
                        const newPetMap = new Map();
                        data.forEach(node => newPetMap.set(node.uuid, node));
                        setPetMap(newPetMap);
                    });
                    break;
                case 204:
                    setPetMap(new Map());
            }
        });
    }

    const handleSubmit = async () => {
        if (!petToRemoveId.current) {
            return;
        }
        const response = await fetch(`/api/tree/test/${petToRemoveId.current}`, {method: "DELETE"});
        switch (response.status) {
            case 204:
                setTreeRoot(emptyTreeRoot);
                break;
            case 200:
                setTreeRoot(await response.json());
                break;
        }
    };

    useEffect(() => {
        refreshPetMap();
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
