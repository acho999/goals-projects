import React from 'react';

const AuthContext = React.createContext({//that is how we create context it is not component but that way it can accept components
    isLoggedIn:false,
    onLogout: ()=>{},//idea here is to initialise property with dummy function in order to have intellysence to this property
    onLogin:(email,password)=>{}
});

export default AuthContext;