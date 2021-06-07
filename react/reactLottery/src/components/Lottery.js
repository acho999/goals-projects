import React,{Component} from 'react'
import LotteryTicket from './LotteryTicket'

class Lottery extends Component{

  renderButton (){

    if(this.props.remainingTickets > 0){
      return <button onClick={this.props.actions.registerTickets}>Купи билет</button>//here we return button in which
      //we have defined prop actions which is object we have defined where we use props.actions in App component 
      //here we give handler function to onClick event this function is registerTickets
    }
    return <button onClick={this.props.actions.checkTicket}>Провери билет</button>;
    
  }

  renderTicket(){ // this func is maden because it should receive state from App comp 
    //and they will be needed in LotteryTicket component because of props color and number there
      const renderTickets = this.props.tickets.map((ticket,index) =>{

              return (
                <LotteryTicket color={ticket.color} 
                                removeTicket={this.props.actions.removeTicket} 
                                number={ticket.number} 
                                key={index} 
                                index={index}
                />
                  // here we give key for react and index={index} to know index of th current component in list index
                  //purpose of deletion a particular component
              )

      });//можем да слагаме props и не само в html-а както е долу, техия scope е
      //самия компонент и са достъпни във всички функции които дефинираме

      return renderTickets;
  }

  render(){

    return (

        <>
          <h2>Лотария</h2>
          {this.renderButton()}
          <br/>
          <small>Оставащи билети: {this.props.remainingTickets}</small>
          <br />
          <hr />
          {this.renderTicket()}
          {this.props.children}
        </>
   //with this.props.children we can add child components in Lottery component for example <Lottery> Here we put child components </Lottery>
      );

  }
  
}

export default Lottery;