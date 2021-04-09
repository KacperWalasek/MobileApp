import React from 'react';
import { Provider } from 'react-redux';
import Login from './Components/Login';
import PartyCreator from './Components/PartyCreator';
import Register from './Components/Register';
import Menu from './Components/Menu';
import User from './Components/User';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import MenuHeader from './Components/MenuHeader';
import Party from './Components/Party';
import PartyList from './Components/PartyList';
import UserList from './Components/UserList';
import { ChoseUser } from './Components/ChoseUsers';
const App = () => {
  const Stack = createStackNavigator();
  
  return (
    <Provider store={store}>
      <NavigationContainer>
        <Stack.Navigator initialRouteName="Menu" >
          <Stack.Screen name="Login" component={Login} />
          <Stack.Screen name="Register" component={Register} />
          <Stack.Screen name="User" component={User} />
          <Stack.Screen name="Menu" component={Menu} options={{ 
            headerRight: () => (<MenuHeader/>)}}/>
          <Stack.Screen name="CreateParty" component={PartyCreator} />
          <Stack.Screen name="Party" component={Party} />
          <Stack.Screen name="PartyList" component={PartyList} />
          <Stack.Screen name="UserList" component={UserList} />
          <Stack.Screen name="ChoseUsers" component={ChoseUser} />
        </Stack.Navigator>
      </NavigationContainer>
    </Provider>
  );
}



export default App;