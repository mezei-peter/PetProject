import './PetTree.css';

import PetNode from './PetNode';
import {useEffect, useState} from "react";

function PetTree() {
    const [tree, setTree] = useState(null);
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
                console.log(data);
                setTree(data);
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