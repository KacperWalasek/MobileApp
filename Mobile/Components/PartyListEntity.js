import React from 'react';
import { Button, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import {listItemStyles, viewingStyles} from '../styles';
import Icon from 'react-native-vector-icons/FontAwesome';

export default function PartyListEntity({navigation, item}) {
  return (
    <TouchableOpacity  onPress={()=>navigation.navigate('Party',{party: item})}>
        <View style={[viewingStyles.columns, viewingStyles.space, listItemStyles.container]}>
            <View style={listItemStyles.leftSide}>
                <Text>{item.name}</Text>
            </View>
            <View>
                <Text>{item.address}</Text>
            </View>
        </View>
    </TouchableOpacity>
  );
}
