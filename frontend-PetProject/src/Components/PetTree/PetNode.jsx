function PetNode({invisible, leftChild, rightChild, name, weight, species, portraits}) {
    if (invisible) {
        return (
            <li>
                <div className="invisible"></div>
            </li>
        );
    }

    return (
        <li>
            <div className="pet-node">
                <img src={portraits.get(species.toLowerCase())}
                     alt="animal portrait"/>
                <p>{name}</p>
                <p>{weight}kg</p>
            </div>

            <ul>
                {leftChild ?
                    <PetNode invisible={false} leftChild={leftChild.leftChild} rightChild={leftChild.rightChild}
                             name={leftChild.name} weight={leftChild.weight} species={leftChild.species}
                             portraits={portraits}/> :
                    <PetNode invisible={true}/>}
                {rightChild ?
                    <PetNode invisible={false} leftChild={rightChild.leftChild} rightChild={rightChild.rightChild}
                             name={rightChild.name} weight={rightChild.weight} species={rightChild.species}
                             portraits={portraits}/> :
                    <PetNode invisible={true}/>}
            </ul>
        </li>
    );
}

export default PetNode;