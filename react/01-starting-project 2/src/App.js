import React, { useState, useEffect } from 'react';

import Login from './components/Login/Login';
import Home from './components/Home/Home';
import MainHeader from './components/MainHeader/MainHeader';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  useEffect(()=>{//here we use useEffect to rerender and relog in user
    //useEffect is used for lifecycle hooks when we have to rerender something
    // it is triggered when we have some change

    const isUserLoggedIn = localStorage.getItem('isLoggedIn');
  if(isUserLoggedIn === '1'){
    setIsLoggedIn(true);
  }
  },[]);
  

  const loginHandler = (email, password) => {
    // We should of course check email and password
    // But it's just a dummy/ demo anyways
    localStorage.setItem('isLoggedIn','1');//here we set login to 1 === true in local storage
    setIsLoggedIn(true);
  };

  const logoutHandler = () => {
    localStorage.removeItem('isLoggedIn');//here user is logged out
    setIsLoggedIn(false);
    
  };

  return (
    <React.Fragment>
      <MainHeader isAuthenticated={isLoggedIn} onLogout={logoutHandler} />
      <main>
        {!isLoggedIn && <Login onLogin={loginHandler} />}
        {isLoggedIn && <Home onLogout={logoutHandler} />}
      </main>
    </React.Fragment>
  );
}

export default App;
