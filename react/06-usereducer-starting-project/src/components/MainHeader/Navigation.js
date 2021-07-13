import {React,useContext}from 'react';

import classes from './Navigation.module.css';
import AuthContext from '../../context/auth-context'

const Navigation = (props) => {
  const context = useContext(AuthContext);//that way we take context
  return (//here we have consumer this consumer provides subscription to the context and that way AuthContext.Consumer listen AuthContext.Provider
  //<AuthContext.Consumer>{(context)=>{ the other way to use context is with hook useContext()
        <nav className={classes.nav}>
        <ul>
          {context.isLoggedIn && (
            <li>
              <a href="/">Users</a>
            </li>
          )}
          {context.isLoggedIn && (//here we will change props with context
            <li>
              <a href="/">Admin</a>
            </li>
          )}
          {context.isLoggedIn && (
            <li>
              <button onClick={context.onLogout}>Logout</button>
            </li>
          )}
        </ul>
      </nav>
         
       // }}</AuthContext.Consumer> 
        
  );
};

export default Navigation;
