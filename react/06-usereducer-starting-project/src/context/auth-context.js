import React from 'react';

const AuthContext = React.createContext({//that is how we create context it is not component but that way it can accept components
    isLoggedIn:false
});

export default AuthContext;