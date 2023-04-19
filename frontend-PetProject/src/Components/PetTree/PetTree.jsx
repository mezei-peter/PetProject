import './PetTree.css';

import PetNode from './PetNode';
import {useEffect, useRef, useState} from "react";

function PetTree({root, setRoot, emptyRoot}) {
    const [wentWrong, setWentWrong] = useState(false);
    const [loading, setLoading] = useState(true);
    const mouseDown = useRef(false);
    const mousePosition = useRef({x: 0, y: 0});
    const topElement = document.getElementById("component-pet-tree");
    const [zoomValue, setZoomValue] = useState(100);

    const handleMouseMove = (mouseX, mouseY, element) => {
        if (!element) {
            return;
        }
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

    const calculateInnerWrapperWidth = () => {
        const outermostDivWidth = document.getElementById("root").clientWidth;
        if (root.invisible) {
            return outermostDivWidth;
        }
        let petNodeWidth = document.querySelector(".pet-node")?.clientWidth ?? 0;
        const petNodeCount = document.getElementsByClassName("pet-node").length;
        const widthRatioWithExtraSpace = 1.5;
        petNodeWidth = petNodeWidth * widthRatioWithExtraSpace * petNodeCount;
        if (outermostDivWidth > petNodeWidth) {
            return outermostDivWidth;
        }
        return petNodeWidth;
    }

    return (
        <>
            <input type="range" min="1" max="120" defaultValue={zoomValue} id="tree-size-controller"
                   onChange={event => {
                       console.log(event.target.value)
                       setZoomValue(event.target.value)
                   }}/>
            <div id="component-pet-tree"
                 onMouseDown={() => mouseDown.current = true}
                 onMouseUp={() => mouseDown.current = false}
                 onMouseLeave={() => mouseDown.current = false}
                 onMouseMove={event => handleMouseMove(event.clientX, event.clientY, topElement)}>
                <div className="inner-wrapper"
                     style={{
                         width: calculateInnerWrapperWidth(),
                         zoom: zoomValue + "%"
                     }}
                     onMouseDown={() => mouseDown.current = true}
                     onMouseUp={() => mouseDown.current = false}
                     onMouseLeave={() => mouseDown.current = false}
                     onMouseMove={event => handleMouseMove(event.clientX, event.clientY, topElement)}>
                    <ul>
                        <PetNode invisible={root.invisible} leftChild={root.leftChild} rightChild={root.rightChild}
                                 name={root.name} weight={root.weight}/>
                    </ul>
                </div>
            </div>
        </>
    );
}

export default PetTree;