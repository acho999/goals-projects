import React, {Component} from 'react'
import './App.css'
import {Header,Content,StateForComponentExample,ComponentLifeCycle,FormComponent,Footer,SpisaciComponent} from './components/ImportsModule'

class App extends Component {

  render() {

    const name = 'pesho';

    return (
        
      <div className="App">

        <Header name = {name}/>

        <Content color='red'>

          Това което е тук отива в children където е дефиниран този компонент.

        </Content>

        <StateForComponentExample/>

        <br />

        <ComponentLifeCycle/>
        <br />
        <FormComponent/>
        <br />
        <br />
        <SpisaciComponent />
        <br />
        <br />


        <Footer/>

      </div>
    )
  }

}

export default App;
