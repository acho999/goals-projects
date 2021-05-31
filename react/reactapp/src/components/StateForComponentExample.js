import React, {Component} from 'react';


class StateForComponentExample extends Component {// за да пазим стейт на компонент 
    //ни трябва конструктор който винаги получава props и стейта е винаги
    //обект също така тряябва да викаме parent constructor-a стейта се променя със setState() функция
    // можем да this.state да присвояваме стойност само в конструктора навсякъде другаде е със setState()
    // правим callback функция за бутона в която ще модифицираме стейта.Стейта се модифицира чрез свойството prevState 
    //което пази предходния стейт. С this.increment.bind(this) байндваме this на компонента за да може вътрешното this 
    //във функцията да сочи към контекста на класа а не към контекста на бутона другия начин рътрешното this  да сочи 
    // към контекста на класа е със arrow фукция increment = () => {this.setState()}...kakto e dolu 
    //или да байнднем в конструктора

    constructor(props){
        super(props);
        this.state = { counter: 0 };
        // this.increment = this.increment.bind(this);
        // this.reset = this.reset.bind(this);
    }


    increment(){

        this.setState((prevState) =>{
            return {counter: ++ prevState.counter}
        });

    }

    reset(){

        this.setState((prevState) => {// или направо можем да кажем this.setState( {counter :0}) 
                                       //защото нямаме нужда от prevState

            return {counter : 0}
            
        });
    
    }

 render(){

    return(

        <> 
            <h1>Стейта на counter e {this.state.counter}</h1>
            <button  onClick={this.increment.bind(this)} >Increment</button>
            <br />
            <button  onClick={this.reset.bind(this)} >Reset</button>
        </>
    )

 }

}

export default StateForComponentExample