import React, {Component} from 'react';
import '../css/header.css';

class Header extends Component {

    render() {

        return (
                //така задаваме възможност да се взимат външни данни и да се слагат където са props
            <h1>Hello {this.props.name}</h1>
            
        )

    }

}

export default Header;
