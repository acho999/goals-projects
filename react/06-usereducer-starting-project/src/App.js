import React, { useState, useEffect } from 'react';

import Login from './components/Login/Login';
import Home from './components/Home/Home';
import MainHeader from './components/MainHeader/MainHeader';
import AuthContext from './context/auth-context'

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);//we use this state here because it will be used in all app

  useEffect(() => {
    const storedUserLoggedInInformation = localStorage.getItem('isLoggedIn');

    if (storedUserLoggedInInformation === '1') {
      setIsLoggedIn(true);
    }
  }, []);

  const loginHandler = (email, password) => {
    // We should of course check email and password
    // But it's just a dummy/ demo anyways
    localStorage.setItem('isLoggedIn', '1');
    setIsLoggedIn(true);
  };

  const logoutHandler = () => {
    localStorage.removeItem('isLoggedIn');
    setIsLoggedIn(false);
  };

  return (
       //<React.Fragment> here we comment this tag because we have wrapper component already */}
      <AuthContext.Provider value={{isLoggedIn:isLoggedIn, onLogout:onLogout={logoutHandler}}}>{/*here we wrap component which have to access isLogIn property from AuthContext we use .Provider
      to tell to react AuthContext is used like component event it is not;     also we added object value which is body from AuthContext
      the idea is to change it here; that way we can use info from App component. When value is changed inside this info will be provided 
      to all listening coponents down to chain*/}
       {/* <MainHeader isAuthenticated={isLoggedIn} onLogout={logoutHandler} />  here we comment this*/}
       <MainHeader/>{/*here we ramove some attributes in order to use context in navigation component*/}
        <main>
          {!isLoggedIn && <Login onLogin={loginHandler} />}
          {isLoggedIn && <Home onLogout={logoutHandler} />}
        </main>
      </AuthContext.Provider>
       //</React.Fragment>
  );
}

export default App;
