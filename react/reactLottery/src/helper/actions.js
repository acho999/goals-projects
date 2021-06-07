//тук ще са функциите които ще ползваме в app.js  за да може чрез тях да се подифицира стейта който се пази там от
//другите компоненти това е файл за функции
import {getRandomNumber, getRandomColor} from './utills'

export function registerTickets(){
    const newTicket = {
        number : getRandomNumber(),
        color : getRandomColor()
    }

    this.setState((prevState)=>{

        prevState.tickets.push(newTicket)

        return {// връщайки този обект със свойствата от state в App компонента те ще се модифицират, 
            //само ако имаме this то трябва да се обвърже със контекста на App.js компонента като байнднем в конструктора 
            // на App компонента ф-ята registerTicket със this 
            tickets : prevState.tickets,
            remainingTickets : --prevState.remainingTickets
        }

    });

   
}

export function checkTicket(tickets){

    this.setState((prevState)=>{

        prevState.finished = true;

        return{
            finished : prevState.finished
        }
    });

}

export function removeTicket(index){

    this.setState((prevState)=>{

        prevState.tickets.splice(index,1);
       

        return {
            tickets: prevState.tickets,
            remainingTickets: ++prevState.remainingTickets,
            
        }
    });

}

export function reset(){

    this.setState( ()=>
        {return {winningNumber    : getRandomNumber(),
        tickets: [],
        remainingTickets        :5,
       finished         : false}}
       )

}


 