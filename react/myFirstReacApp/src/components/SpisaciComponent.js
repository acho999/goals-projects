import React, {Component} from 'react';


class SpisaciComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            messages: [
                {name:'pesho', message:'Здрастиии Пешо!'},
                {name:'gosho', message:'Здрастиии Гошо!'},
                {name:'ceco', message:'Здрастиии Цецо!'}
            ]
        }
    }

    renderMessages(){

        const messages = this.state.messages.map((obj, index) => {
            return <p key={index}>{obj.name}:&nbsp;{obj.message}</p>
        })
        return messages;
    }

    render() {

        return (
            
            <>
                {this.renderMessages()}

            </>


        )
    }

}

export default SpisaciComponent