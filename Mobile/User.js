import React from 'react';
import { StyleSheet, Text, View, Button, TouchableOpacity } from 'react-native';
import { TextInput } from 'react-native-gesture-handler';
import {userStyles} from './styles';

export default function User(props) {
  return (
    <View style={userStyles.container}>
      <Text style={userStyles.name}>{props.name} {props.surname}</Text>
      <TextInput style={userStyles.input}>Tu możesz pisać</TextInput>
      <Button title="Przycisk"></Button>
      <TouchableOpacity style={userStyles.touchable}>
          <Text>Tu obszar można klikać</Text>
      </TouchableOpacity>
    </View>
  );
}