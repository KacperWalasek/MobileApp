import React from 'react';
import {Text, View, StyleSheet} from 'react-native';
import { TouchableOpacity } from 'react-native-gesture-handler';
import Icon from 'react-native-vector-icons/FontAwesome';
import {headerStyles} from './../styles';

export default function MenuHeader({navigation}){
    return (
        <View style={headerStyles.rightItem}>
            <TouchableOpacity style={headerStyles.headerButton} onPress={()=>navigation.navigate('CreateParty')} >
                <Icon name="plus" size={30} color='rgb(200,200,200)'></Icon>
            </TouchableOpacity>
            <TouchableOpacity style={headerStyles.headerButton} onPress={()=>navigation.navigate('Login')}>
                <Icon name="user" size={30} color='rgb(200,200,200)'></Icon>
            </TouchableOpacity>
        </View>
        
    );
}