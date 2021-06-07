import React, { Component} from 'react';

class FormComponent extends Component {
constructor(props){
    super(props);
    this.state = {

        name: '',
        email:'',
        gender:''

    }

    this.onChangeName = this.onChangeName.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
}

onChangeName(event){
//тази функция хендълва евентите от инпутите като в скобите[event.target.id] динамично взимаме Id-то на
// елемента който е и свойство от стейта на компонента и го променяме
    this.setState({[event.target.id]:event.target.value});

}

handleSubmit(event){
// тази функция ще хендълва формата
    event.preventDefault();//това спира дефолтното поведение на браузъра да праща формата
    console.log(this.state)

}

render(){
    return(
        <>
            <hr/>
            <form onSubmit={this.handleSubmit}>
                <input type="text" onChange={this.onChangeName} value={this.state.name} id="name" placeholder="име"/>
                <br/>
                <input type="text" id="email" onChange={this.onChangeName} value={this.state.email} placeholder="мейл"/>
                <br/>
                <select  id="gender" onChange={this.onChangeName} value={this.state.gender} placeholder="пол">
                    <option />
                    <option value="мъж">Мъж</option>
                    <option value="мъж">Жена</option>
                </select>
                
                <br/>
                <button type="submit">Изпрати</button>

                <br/>

            </form>
            <hr/>
                <div>
                    <p>
                       Име: {this.state.name}  &nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp; 
                       Мейл: {this.state.email}&nbsp; &nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;
                       Пол: {this.state.gender}
                    </p>
                </div>
            <hr/>    
        </>
    )
}

}

export default FormComponent