import './card.css'

function Card(props){
//this component will be used to wrap other components to give them a styling
//to do it to be wrapper adding props.children is mandatory this component is reusable wrapper component
//that way we extraxt duplication css code and just reuse code
const classes = 'card ' + props.className;//this way we use card.css and other css classes 
//which can be used in wrapped components and they will be added to card css     ;white space after card is a must
    return(
        
        <div className={classes}>
            {props.children}
        </div>
    );

}

export default Card;