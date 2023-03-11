import './PetTree.css';

import PetNode from './PetNode';

function PetTree() {
    return (
        <div id="component-pet-tree">
            <div className="inner-wrapper">
                <ul>
                    <PetNode children={[
                        {
                            children: [
                                {children: [null, null]},
                                {children: [null, null]}]
                        },
                        {children: [null, null]}
                    ]} invisible={false}/>
                </ul>
            </div>
        </div>
    );
}

export default PetTree;