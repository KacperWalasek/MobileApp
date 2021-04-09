import React from 'react';
import { StyleSheet, Text, View, Button, TouchableOpacity } from 'react-native';
import { TextInput } from 'react-native-gesture-handler';
import {userStyles} from './../stylesExample';
import {connect} from 'react-redux';
function User(props) {
  return (
    <View style={userStyles.container}>
      <Text style={userStyles.name}>{props.name}</Text>
      <TextInput style={userStyles.input}>Tu możesz pisać</TextInput>
      <Button title="Przycisk" onPress={()=>props.navigation.navigate('Menu')}></Button>
      <TouchableOpacity style={userStyles.touchable}>
          <Text>Tu obszar można klikać</Text>
      </TouchableOpacity>
    </View>
  );
}
export default connect(store=>({name: store.username}))(User);