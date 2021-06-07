import React,{Component} from 'react'

class Final extends Component{

  winningTicket(){
    const winningTicket = this.props.tickets.filter(x=>x.number === this.props.winningNumber).map((x,index)=>{

      return <h2 key={index}>Печелившия билет е : {x.number}</h2>
    });
    console.log(winningTicket);
    if (winningTicket.length === 0) {
      return <div><h2>Няма печеливш билет!!!!!!!</h2> 
                  <h2>Опитай пак!!!!!!!</h2> 
              </div>
    }
    return winningTicket;
  }

  resetButton(){
    return <button onClick={this.props.actions.reset}> 
              Ново теглене
            </button> 
  }

  render(){

    return (
          <>
          <h1>Край на лотарията</h1>
          <br/>
          {this.winningTicket()}
          <br/>
          {this.resetButton()}
          </>
      );

  }
  
}

export default Final;
