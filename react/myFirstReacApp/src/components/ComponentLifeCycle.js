import React, {Component} from 'react';

class ComponentLifeCycle extends Component {

    // има 3 цикъла mounting(когато компонента се създава), updating(когато се ъпдейтва компонента)
        // , unmounting (когато компонента се дестройва)
    interval;
    constructor(props){

        super(props);

        this.state = {counter:0};
        this.increment = this.increment.bind(this);
    }

    componentDidMount(){
        //тук слагаме неща които искаме да се извършат когато компонента се 
        //създава извиква се след конструктора тук можем да викнем външно api
       this.interval = setInterval(this.increment,1000)
    }

    componentDidUpdate(prevProps, prevState) {
        //това се изпълнява когато компонента се промени има prevProps и prevState предходните 
        //свойства и стейт на компонента

        if(prevState.counter === 10){
                this.setState({counter:0})
        }


    }

    componentWillUnmount() {
        // това се вика точно преди компонента да се инищожи тук затриваме някакви евенти

        clearInterval(this.interval);


    }

    increment(){

        this.setState((prevState) =>{
            return {counter: ++ prevState.counter}
        });

    }

    render(){
        return (

            <div style={{color:'green'}}>

                <h1>{this.state.counter}</h1>

            </div>

        )
    }

}

export default ComponentLifeCycle