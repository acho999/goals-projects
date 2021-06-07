import React,{Component} from 'react'
import {BrowserRouter,Route,Switch,Link,Redirect} from 'react-router-dom'//this way we add router routes
import './App.css';
import {Lottery,Final,About,Hooks} from './helper/imports'
import {getRandomNumber} from './helper/utills'
import {registerTickets,removeTicket,checkTicket,reset} from './helper/actions'
import 'antd/dist/antd.css';


class App extends Component{
    // тук в този главен компонент трябва да държим стейт който ще се ползва от другите компоненти
    //тук ще се предостави и начина този стейт да се модифицира и от другите деца компоненти това става с функции
    //които ще приемат някакви параметри
    //Значи стейта който ни трябва ще се пази тук в главния компонент и той ще може да се модифицира от другите
    // компоненти чрез функции и ще може да се подава надолу по компонентите като props

  constructor(props) {//from state in constructor all our components are dependant 
    //and all components are reactive because of this state 
    //it is a parent component state and all components depend on it
    //is state is changed then all components are noticed and they will be updated
    //FOR ROUTING WE HAVE TO WRITE NPM INSTALL REACT-ROUTER-DOM IN CMD STARTED FROM FOLDER WHERE OUR PROJECT IS INSTALLED 
    super(props);
    this.state = {
      winningNumber    : getRandomNumber(),
       tickets: [],
       remainingTickets        :5,
      finished         : false
    }
    this.registerTickets = registerTickets.bind(this);
    this.removeTicket = removeTicket.bind(this);
    this.checkTicket = checkTicket.bind(this);
    this.reset = reset.bind(this);
    //this.renderApp = renderApp.bind(this);
    // here we bind this function because ot need for access
    // context of the App component in this function because there have changes in state which is in App component
  }

  renderApp(){  //в тази ф-я на база на условна конструкция ще казваме дали даден компонент ще се зарежда или не
    const actions = {registerTickets : this.registerTickets, 
                      removeTicket : this.removeTicket, 
                      checkTicket : this.checkTicket,
                      reset: this.reset
                    }
    //here we tell to actions to be object and put it to the
    //prop.actions in Lottery component
      if (this.state.finished) {

        return <Final
            actions = {actions}
            tickets = {this.state.tickets}
            winningNumber = {this.state.winningNumber}
        />;
        
      }
   return  <Lottery 
            actions = {actions}// тук слагаме prop actions за да можем да добавяме функции които ще манипулират стейта в App 
            //и тези функции ще ги достъпваме чрез prop actions 
            tickets = {this.state.tickets}
              remainingTickets = {this.state.remainingTickets} 
          >

            <Hooks/>
          </Lottery>
  }

  render(){
    return (
      //  <BrowserRouter> we put it on top because it have to be on top of hierarchy and all other html have to be inside of it
      //Below in Route tag we put in component={this.renderApp()} because this function return our components 
      //it can be achieved also with ()=>{this.renderApp()} because in arrow function this points to class context
      // and we had to bind it in constructor when we go to '/' we will access home page
      //below if firs route which is '/' is included in routes below  we have to put 'exact' in it because React will load only one component
      // and it will be only from renderApp(), to not have this we have to put 'exact' or 'exact match="/some route"'
      //now we go to About.js and import {Link} which is hiperlink to link our component with path '/about'
      //here we add <Link> tag around text in <a> tags to link path with to='/about' attribute with path="/about" in <Route> tag
      <BrowserRouter>
      
      <div className ='App'>
          <div className='topnav'>
            <a className='active' href='#'><Link to='/'>Home</Link></a>
            <a href='#'><Link to='/about'>About</Link></a>
          </div>
          <Switch>
            <Route exact path='/' component={this.renderApp.bind(this)}/>
            <Route path='/about' component={About}/>
            <Redirect from='/info' to='/about'/>
          </Switch>
      </div>

      </BrowserRouter>
      
      );

  }
  
}

export default App;
