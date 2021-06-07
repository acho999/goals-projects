import logo from './logo.svg';
import './App.css';
import Hooks from './components/Hooks';
import AnotherCard from './components/UI components/AnotherCard';
import {React,Component,useState,useEffect} from 'react'//here we import useState which allows us to
//use state in function component
//we also import useEffect it is used when we have side effects, we use it also when we have to use
//lifecycle methods like componentDidMount(it is used to do something after component is created) 
//and componentWillUnmount(it is used to clear something just before component is destroyed)
//this useEffect sustitute another lifecycle method which is
// cimponentDidUpdate(it is used when we update our component)
//react hooks starts with 'use'
//useState sets state for the component in which is being called and for every instance of that component separatelly
function App(){
      
  /*const initial = 0;
  const [random, setRandom] = useState(initial);

  useEffect(()=>{ 
    let randomNuber = setInterval(
      ()=>{
        
        setRandom((Math.random()*100).toFixed(0))//here we have not object {random:++random} because setRandom can change only random
        //it points to random variable and it is not necessary
      }
      ,1000);//this is used in componentDidMount

    return () => clearInterval(randomNuber);//here we clearInterval which is done in componentWillUnmount
    //if we do not clear interval this will create memory leack

  });*/
  let random = useRandomNumberOnInterval();//here we subtract all logic from App function
  //and store it in our custom function. That way we can share state between components
  let[name,setName] = useState();//we use state do get data from child component
  let [anotherName,setAnotherName] = useState('pesho');
  let [array,setArray] = useState(['1',2,'3']) ;//these values may come from props or from child component

  const handlerFunc = (passedData)=>{ 
    console.log(passedData);
    setName(passedData.name);//here we set state of the app component which data is from child component
    setAnotherName((prevState)=>{ 
      return prevState + ' ' + passedData.name;
    });//here we will add dynamically another names to older state name

    setArray((prevState)=>{

      return [passedData.name, ...prevState];

    })//here we add element dynamically 

    console.log(name);
    return {name:passedData.name}
  }

  return (
    <div className='App'>
      <h1>{random}</h1>
      <Hooks onSubmitHandler = {handlerFunc} title={'0'*1}/> {/*here we create own listener variable onSubmitHandler
      to which we will add a function in curly brackets which will be deklared here in parent component and it will 
      receive parameter which will be passed from inside Hooks component. By this way we can send information from
      child component to parent component*/}
      <br/>
      <br/>
      <br/>
      <br/>
      <AnotherCard title={name}/>{/*here we take name from parent and parent take name from Hooks that way
      we can pass information from one child component to another using parent information can be passed Only
      from child to parent and from parent to child and parent have to have connection with this two components
      as it returns thees two child components it can not be from child to child without parent*/}
      <br/>
      <br/>
      <br/>
      {array.map((x,index)=><AnotherCard title={x} key={index}/>)} {/*here we have list of same component the key 
      have to be unique for example we have to put some id of object*/}
      <br/>
      <br/>
      <br/>
      <br/>
      <AnotherCard title={anotherName}/>
    </div>
  )

}

function useRandomNumberOnInterval(){

  const initial = 0;
  const [random, setRandom] = useState(initial);

  useEffect(()=>{ 
    let randomNuber = setInterval(
      ()=>{
        
        setRandom((Math.random()*100).toFixed(0))
      }
      ,1000);

    return () => clearInterval(randomNuber);

  })

  return random;//here we change state internally and we return the state but we may want to change
  //it outside then we have to return array [random,setRandom]

}


/*function App(){

  const [counter, setCounter] = useState(0);//here we use destructoring because this setState function
  //returns two things: second is function which change state which initial value we put as parameter
  //in our case is 0; first is variable which is pointer to the value of the state and through it we can access it
  //this hook can be used only in this function App and have to be on top in there
  return (
    <div className='App'>
      <h1>{counter}</h1>
      <br/>
      <button onClick = {() => { setCounter(prevState => ++prevState)}}>Increse</button>
      <br/>
      <br/>
      <button onClick = {() =>{ setCounter(0)}}>Reset</button>
    </div>
  )

}*/

/*class App extends Component {

  constructor(props) {
    super(props);

    this.state = {counter:0};
    this.increment = this.increment.bind(this);
    this.reset = this.reset.bind(this);

  }

  increment(){

    this.setState((prevState)=>{

        return {counter : ++prevState.counter};
    })

  }

  reset(){

    this.setState({counter:0});

  }


  render() {
    return (
      <div className='App'>
        <h1>{this.state.counter}</h1>
        <br/>
        <button onClick={this.increment}>Increse</button>
        <br/>
        <br/>
        <button onClick={this.reset}>Reset</button>
      </div>
    )
  }
  
}*/

export default App;
