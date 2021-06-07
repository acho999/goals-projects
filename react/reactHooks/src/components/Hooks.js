import {React,useState,useEffect }from 'react';
import './hooks.css';
import Card from './UI components/Card';

function Hooks(props){// components from function type can have state can have props but to add state we have to use hooks
    //they can be used only for presentation with returning some html, but they can have state and can receive props
    //here we have not extend React.Component
    //here we have not this keyword we will be able to access component state without 'this'
    //here we have not lifecycle methods
    //it can be by two ways setTitle(()=>++title) or setTitle(++tistle)
    //when state is set in title if component rerenders it will save its value
    
    let [title,setTitle] = useState(props.title);//here we set initial value trough props.title

    const handler = ()=>{console.log('pesho')}//two ways for hadler arrow anonymous function

    function handlerFunction(){console.log('gosho')}

    //we can use useState several times for handling diferrent state variables but we can use one useState and one
    //variable in all inputs for example this is better than below
                            /*
                                let [name,setName] = useState();

                                let [age,setAge] = useState();

                                const inputNameHandler = (event)=>{setName(event.target.value);}

                                const inputAgeHandler = (event)=>{setAge(event.target.value);}

                            */

    
    //second variant ...inputs is spread operator and gets the hole object from useState and then in
                //the separate functions we give values of the two variables
            /*
                const [inputs,setInputs] = useState({name:'',age:''});
                //we can get age and name as inputs.age, inputs.name

                const inputNameHandler = (event)=>{setInputs({...inputs, name:event.target.value});}

                const inputAgeHandler = (event)=>{setInputs({...inputs, age:event.target.value});}
            */

    //third variant is to use prevState because by this way we work with last state snapshot

                const [inputs,setInputs] = useState({name:'',age:''});

                const inputNameHandler = (event)=>{
                    setInputs((prevState)=>
                    {
                        return {...prevState, name:event.target.value}
                    });
                }

                const inputAgeHandler = (event)=>{
                    setInputs((prevState)=>{
                        return {...prevState, age:event.target.value}
                    });
                }

                const submitHandler = (event) => {
                    event.preventDefault();
                    console.log({name:inputs.name,age:inputs.age});
                    //if we invoke inputAgeHandler and inputNameHandler with empty strings
                    //this will reset value because age and name will be empty strings because of two way binding
                    //inputAgeHandler('');
                    //inputNameHandler('');
                    console.log(event.target[0].value);
                    props.onSubmitHandler({name:event.target[0].value});//here we use component props in which we will
                    //access onSubmitHandler variable which hold function handler in App.js component which is parent of
                    //Hooks and we can pass data in our case is object that is how we pass data to parent component
                    //through onSubmitHandler variable we call handlerFunc from App.js
                    return {name:event.target[0].value, age:event.target[1].value}
                }

               

    return(
        <Card className='hookcomponent'>
            <h2>Hook Component</h2>
            <button onClick={handler}>Click</button>
            <br/>
            <button onClick={()=>{setTitle(()=>++title)}}>Click</button>
            <br/>
            <button onClick={handlerFunction}>Click</button>
            <br/>
            <h2>{title}</h2>
          
            <form onSubmit={submitHandler}>
                <div>
                    <title>Name</title>
                    <input type="text" value={inputs.name} onChange={inputNameHandler} placeholder="enter name"/>
                      {/*adding two way binding with value={variable} attribute*/}
                </div>
                <div>
                    <title>age</title>
                    <input onChange={inputAgeHandler} value={inputs.age} type="number" placeholder="enter age"/>
                </div>
                <button type="submit" >Submit</button>
            </form>

            <div>{inputs.name}</div>
            {inputs.age!==''?<div>{inputs.age}</div>:<p>Enter age!!!</p>}{/*here is conditional statement */}
        </Card>
    )
}

//functions could be written by this way
const App = (props) => { 
    return(
        <Card className='hookcomponent'>
            <h2>Hook Component</h2>
        </Card>
    );
}

export default Hooks