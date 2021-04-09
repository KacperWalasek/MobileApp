import React from 'react';
import { Button, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import {listItemStyles, viewingStyles} from '../styles';
import Icon from 'react-native-vector-icons/FontAwesome';

export default function UserListEntity({item, party}) {
  return (
    <View style={[viewingStyles.columns, viewingStyles.space, listItemStyles.container, item.role==='Admin'? listItemStyles.special: undefined]}>
        <View style={listItemStyles.leftSide}>
            <Icon name="user"size={50} color='rgb(200,200,200)'></Icon>
        </View>
        <View>
          <View>
            <Text>{item.userId}</Text>
          </View>
          {item.role==='Admin'?
          <View>
            <Text>Admin</Text>
          </View>
          :null}
        </View>
    </View>
  );
}
