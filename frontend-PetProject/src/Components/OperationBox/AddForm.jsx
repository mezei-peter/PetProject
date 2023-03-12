import {useEffect, useState} from "react";

function AddForm({setTreeRoot}) {
    const [name, setName] = useState("");
    const [weight, setWeight] = useState(0);
    const handleSubmit = () => {
        if (!name || weight <= 0) {
            return;
        }

        fetch("/api/tree/test", {
            method: "PUT",
            headers: {"Content-type": "application/json"},
            body: JSON.stringify({"petName": name, "petWeight": weight})
        })
            .then(response => {
                if (response.status !== 200) {
                    throw new Error("Server responded with: " + response.status);
                }
                return response.json();
            })
            .then(data => setTreeRoot(data))
            .catch(ex => {
                console.error(ex);
            });
    };

    return (
        <form id="ob-form" onSubmit={event => {
            event.preventDefault();
            handleSubmit();
        }}>
            <h2>Add pet</h2>
            <input type="text" name="ob-form-name" id="ob-form-name" placeholder="name" required
                   onChange={event => setName(event.target.value)}/>
            <input type="number" min="1" step="1" name="ob-form-weight" id="ob-form-weight" placeholder="weight"
                   required
                   onChange={event => setWeight(parseInt(event.target.value))}/>
            <button>Add</button>
        </form>
    );
}

export default AddForm;