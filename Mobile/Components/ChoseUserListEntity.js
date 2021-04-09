import React from 'react';
import { Button, StyleSheet, Text, Touchable, TouchableOpacity, View } from 'react-native';
import {listItemStyles, viewingStyles} from '../styles';
import Icon from 'react-native-vector-icons/FontAwesome';

export default function ChoseUserListEntity({item, addUser, chosenUsers, removeUser, isChosen}) {
  console.log(item)
  return (
    <TouchableOpacity 
        style={[viewingStyles.columns, viewingStyles.space, listItemStyles.container,
            isChosen(item)?listItemStyles.special:undefined]}
        onPress={()=>{
            if(isChosen(item))
                removeUser(item);
            else
                addUser(item);
        }}
    >
        <View style={listItemStyles.leftSide}>
            <Icon name="user"size={50} color='rgb(200,200,200)'></Icon>
        </View>
        <View>
            <Text>{item.id}</Text>
        </View>
    </TouchableOpacity>
  );
}
