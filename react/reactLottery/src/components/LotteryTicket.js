import React,{Component} from 'react'

class LotteryTicket extends Component{
  
  render(){

    return (//here in  onClick event in handler function we have to insert arrow function and in his body we call
      //removeTicket with parameter index because of parameter which we have to put in we have to call it in arrow
      //as callback

          <div style={{backgroundColor : this.props.color, width:'60%', padding: 5, margin:'auto'}}>
            <button onClick={()=>{this.props.removeTicket(this.props.index)}}>X</button>
            <small>Това билетче има числото: <b>{this.props.number}</b></small>

          </div>
          
      );

  }
  
}

export default LotteryTicket;