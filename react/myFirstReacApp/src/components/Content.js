import React, {Component} from 'react';

class Content extends Component {

    render() {//този компонент става преизползваем и можем да му подаваме отвън инфо
        return(
//този див има свойство колор което ще дойде отвън а за chidren всичко което се сложи между таговете на копонента се
// зарежда там видж  app.js children може да са компоненти например не само текст
            <div style={{color:this.props.color}}> 

                <h1>Hello another {this.props.name}</h1>
                <br />
                <i>
                    {this.props.children}
                </i>

            </div>


        )
    }


}

export default Content