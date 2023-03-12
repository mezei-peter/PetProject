import {useEffect, useState} from "react";

function AddForm({setTreeRoot}) {
    const [name, setName] = useState("");
    const [weight, setWeight] = useState("");
    const [loading, setLoading] = useState(false);
    const handleSubmit = () => {
        if (!name || weight <= 0) {
            return;
        }
        setLoading(true);

        fetch("/api/tree/test", {
            method: "PUT",
            headers: {"Content-type": "application/json"},
            body: JSON.stringify({"petName": name, "petWeight": parseInt(weight)})
        })
            .then(response => {
                if (response.status !== 200) {
                    throw new Error("Server responded with: " + response.status);
                }
                return response.json();
            })
            .then(data => {
                setTreeRoot(data);
                setName("");
                setWeight("");
                setLoading(false);
            })
            .catch(ex => {
                console.error(ex);
            });
    };

    if (loading) {
        return <div>Loading...</div>;
    }

    return (
        <form id="ob-form" onSubmit={event => {
            event.preventDefault();
            handleSubmit();
        }}>
            <h2>Add pet</h2>
            <input type="text" name="ob-form-name" id="ob-form-name" placeholder="name" required value={name}
                   onChange={event => setName(event.target.value)}/>
            <input type="number" min="1" step="1" name="ob-form-weight" id="ob-form-weight" placeholder="weight"
                   value={weight}
                   required
                   onChange={event => setWeight(event.target.value)}/>
            <button>Add</button>
        </form>
    );
}

export default AddForm;