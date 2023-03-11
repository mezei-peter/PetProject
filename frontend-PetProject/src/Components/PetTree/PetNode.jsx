function PetNode({invisible, leftChild, rightChild, name, weight}) {
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
                <img src="https://cdn.pixabay.com/photo/2013/07/13/13/41/pig-161381_960_720.png" alt="animal portrait"/>
                <p>{name}</p>
                <p>{weight}kg</p>
            </div>

            <ul>
                {leftChild ?
                    <PetNode invisible={false} leftChild={leftChild.leftChild} rightChild={rightChild.rightChild}
                             name={leftChild.name} weight={leftChild.weight}/> :
                    <PetNode invisible={true}/>}
                {rightChild ?
                    <PetNode invisible={false} leftChild={rightChild.leftChild} rightChild={rightChild.rightChild}
                             name={rightChild.name} weight={rightChild.weight}/> :
                    <PetNode invisible={true}/>}
            </ul>
        </li>
    );
}

export default PetNode;