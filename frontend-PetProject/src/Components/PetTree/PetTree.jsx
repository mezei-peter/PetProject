import './PetTree.css';

import PetNode from './PetNode';
import {useEffect, useRef, useState} from "react";

function PetTree({root, setRoot, emptyRoot}) {
    const [wentWrong, setWentWrong] = useState(false);
    const [loading, setLoading] = useState(true);
    const mouseDown = useRef(false);
    const mousePosition = useRef({x: 0, y: 0});
    const topElement = document.getElementById("component-pet-tree");

    const handleMouseMove = (mouseX, mouseY, element) => {
        if (!mouseDown.current) {
            mousePosition.current = {x: mouseX, y: mouseY};
            return;
        }

        const currentX = mousePosition.current.x;
        const currentY = mousePosition.current.y;
        element.scrollLeft += currentX - mouseX;
        element.scrollTop += currentY - mouseY;
        mousePosition.current = {x: mouseX, y: mouseY};
    };

    useEffect(() => {
        fetch("/api/tree/test")
            .then(res => {
                if (res.status !== 200) {
                    if (res.status === 204) {
                        setRoot(emptyRoot);
                        setLoading(false);
                        setWentWrong(false);
                        return null;
                    }
                    setLoading(false);
                    setWentWrong(true);
                    return null;
                } else {
                    return res.json();
                }
            })
            .then(data => {
                if (!data) {
                    return;
                }
                setRoot({...data, invisible: false});
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
        <div id="component-pet-tree"
             onMouseDown={() => mouseDown.current = true}
             onMouseUp={() => mouseDown.current = false}
             onMouseLeave={() => mouseDown.current = false}
             onMouseMove={event => handleMouseMove(event.clientX, event.clientY, topElement)}>
            <div className="inner-wrapper"
                 onMouseDown={() => mouseDown.current = true}
                 onMouseUp={() => mouseDown.current = false}
                 onMouseLeave={() => mouseDown.current = false}
                 onMouseMove={event => handleMouseMove(event.clientX, event.clientY, topElement)}>
                <ul>
                    <PetNode invisible={root.invisible} leftChild={root.leftChild} rightChild={root.rightChild}
                             name={root.name}
                             weight={root.weight}/>
                </ul>
            </div>
        </div>
    );
}

export default PetTree;