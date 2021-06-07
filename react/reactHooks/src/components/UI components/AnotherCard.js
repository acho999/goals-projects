import {React,useState,useEffect} from 'react';
import './card.css'

function AnotherCard(props){

    return (

        <div className='card'>
            {props.title}
        </div>
    )

}

export default AnotherCard;