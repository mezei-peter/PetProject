
function PetNode({ children, invisible }) {
    if (invisible) {
        return (
            <li>
                <div className="invisible"></div>
            </li>
        );
    }

    return (
        <li>
            <div>
                <img src="https://cdn.pixabay.com/photo/2013/07/13/13/41/pig-161381_960_720.png" alt="animal portrait" />
                <p>name</p>
                <p>10kg</p>
            </div>

            <ul>
                {children.map((child, index) => {
                    if (!child) {
                        return <PetNode key={index} invisible={true}/>;
                    }

                    return <PetNode key={index} invisible={false} children={child.children}/>
                })}
            </ul>
        </li>
    );
}

export default PetNode;