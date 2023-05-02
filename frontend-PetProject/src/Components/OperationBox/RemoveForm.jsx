function RemoveForm() {

    const handleSubmit = () => {

    }

    return (
        <form id="ob-form" onSubmit={event => {
            event.preventDefault();
            handleSubmit();
        }}>
            <h2>Remove pet</h2>
            <label htmlFor="pets-select">Pet to remove: </label>
            <select id="pet-select">
                <option value="">Select pet</option>
            </select>
            <button>Delete</button>
        </form>
    );
}

export default RemoveForm;
