import './PetTree.css';

import PetNode from './PetNode';
import {useEffect, useState} from "react";

function PetTree() {
    const [root, setRoot] = useState(null);
    const [wentWrong, setWentWrong] = useState(false);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        fetch("/api/tree/test")
            .then(res => {
                if (res.status !== 200) {
                    setLoading(false);
                    setWentWrong(true);
                } else {
                    return res.json();
                }
            })
            .then(data => {
                setRoot(data);
                setLoading(false);
                setWentWrong(false);
            })
            .catch(ex => {
                console.error(ex);
                setLoading(false);
                setWentWrong(true);
            });
    }, []);

    if (wentWrong) {
        return <div>Something went wrong.</div>;
    }

    if (loading) {
        return <div>Loading...</div>;

    }

    return (
        <div id="component-pet-tree">
            <div className="inner-wrapper">
                <ul>
                    <PetNode invisible={!root} leftChild={root.leftChild} rightChild={root.rightChild} name={root.name}
                             weight={root.weight}/>
                </ul>
            </div>
        </div>
    );
}

export default PetTree;