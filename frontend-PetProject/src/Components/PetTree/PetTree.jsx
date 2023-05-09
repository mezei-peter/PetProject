import RabbitPortrait from '../../assets/petportraits/rabbit.png';
import CatPortrait from '../../assets/petportraits/cat.png';
import PugPortrait from '../../assets/petportraits/pug.png';
import BeaglePortrait from '../../assets/petportraits/beagle.png';
import HuskyPortrait from '../../assets/petportraits/husky.png';
import GoldenRetrieverPortrait from '../../assets/petportraits/golden_retriever.png';
import GermanShepherdPortrait from '../../assets/petportraits/german_shepherd.png';
import GoatPortrait from '../../assets/petportraits/goat.png';
import SheepPortrait from '../../assets/petportraits/sheep.png';
import PigPortrait from '../../assets/petportraits/pig.png';
import DonkeyPortrait from '../../assets/petportraits/donkey.png';
import HorsePortrait from '../../assets/petportraits/horse.png';
import CowPortrait from '../../assets/petportraits/cow.png';
import HippopotamusPortrait from '../../assets/petportraits/hippopotamus.png';
import RhinocerosPortrait from '../../assets/petportraits/rhinoceros.png';
import ElephantPortrait from '../../assets/petportraits/elephant.png';
import SpermWhalePortrait from '../../assets/petportraits/sperm_whale.png';
import FinWhalePortrait from '../../assets/petportraits/fin_whale.png';
import BlueWhalePortrait from '../../assets/petportraits/blue_whale.png';
import GreatOldOnePortrait from '../../assets/petportraits/great_old_one.png';

import './PetTree.css';

import PetNode from './PetNode';
import {useEffect, useRef, useState} from "react";

const petPortraitMap = new Map();

function fillPetPortraitMap() {
    petPortraitMap.set("rabbit", RabbitPortrait);
    petPortraitMap.set("cat", CatPortrait);
    petPortraitMap.set("pug", PugPortrait);
    petPortraitMap.set("beagle", BeaglePortrait);
    petPortraitMap.set("husky", HuskyPortrait);
    petPortraitMap.set("golden_retriever", GoldenRetrieverPortrait);
    petPortraitMap.set("german_shepherd", GermanShepherdPortrait);
    petPortraitMap.set("goat", GoatPortrait);
    petPortraitMap.set("sheep", SheepPortrait);
    petPortraitMap.set("pig", PigPortrait);
    petPortraitMap.set("donkey", DonkeyPortrait);
    petPortraitMap.set("horse", HorsePortrait);
    petPortraitMap.set("cow", CowPortrait);
    petPortraitMap.set("hippopotamus", HippopotamusPortrait);
    petPortraitMap.set("rhinoceros", RhinocerosPortrait);
    petPortraitMap.set("elephant", ElephantPortrait);
    petPortraitMap.set("sperm_whale", SpermWhalePortrait);
    petPortraitMap.set("fin_whale", FinWhalePortrait);
    petPortraitMap.set("blue_whale", BlueWhalePortrait);
    petPortraitMap.set("great_old_one", GreatOldOnePortrait);
}

function PetTree({root, setRoot, emptyRoot}) {
    const [wentWrong, setWentWrong] = useState(false);
    const [loading, setLoading] = useState(true);
    const mouseDown = useRef(false);
    const mousePosition = useRef({x: 0, y: 0});
    const topElement = document.getElementById("component-pet-tree");

    const MAX_ZOOM = 120;
    const MIN_ZOOM = 1;
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

        fillPetPortraitMap();
    }, []);

    const handleWheel = event => {
        const zoomChange = event.deltaY <= 0 ? 5 : -5;
        const result = Number(zoomValue) + Number(zoomChange);
        if (result <= MIN_ZOOM) {
            setZoomValue(MIN_ZOOM);
            return;
        }
        if (result >= MAX_ZOOM) {
            setZoomValue(MAX_ZOOM);
            return;
        }
        setZoomValue(result);
    }


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
            <input type="range" min={MIN_ZOOM} max={MAX_ZOOM} value={zoomValue} id="tree-size-controller"
                   onChange={event => {
                       setZoomValue(event.target.value)
                   }}/>
            <div id="component-pet-tree"
                 onMouseDown={() => mouseDown.current = true}
                 onMouseUp={() => mouseDown.current = false}
                 onMouseLeave={() => mouseDown.current = false}
                 onMouseMove={event => handleMouseMove(event.clientX, event.clientY, topElement)}
                 onWheel={event => handleWheel(event)}>
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
                                 name={root.name} weight={root.weight} species={root.species}
                                 portraits={petPortraitMap}/>
                    </ul>
                </div>
            </div>
        </>
    );
}

export default PetTree;