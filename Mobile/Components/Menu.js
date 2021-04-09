import React from 'react';
import { Button, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import MenuHeader from './MenuHeader';
import {panelStyles, viewingStyles} from './../styles';
import {getParties} from './../API/PartyApi';
import PartyListEntity from './PartyListEntity';
import { getMemberships, getOrganized } from '../API/UserApi';

export default function Menu({navigation}) {
    React.useLayoutEffect(() => {
        navigation.setOptions({
            headerRight: () => (
                <MenuHeader navigation={navigation}/>
            ),
        });
    }, [navigation]);
  return (
    <View style={viewingStyles.centerColumn}>
        <TouchableOpacity style={[panelStyles.box, panelStyles.yellowBox]} 
            onPress={()=>navigation.navigate('PartyList', {
            getList: getMemberships
        })}>
            <Text>Twoje imprezy</Text>
        </TouchableOpacity>
        <TouchableOpacity style={panelStyles.box}
            onPress={()=>navigation.navigate('PartyList', {
            getList: getParties
        })}>
            <Text>Przeglądaj</Text>
        </TouchableOpacity>
        <TouchableOpacity style={panelStyles.box}
            onPress={()=>navigation.navigate('PartyList', {
            getList: getOrganized
        })}>
            <Text>Organizator</Text>
        </TouchableOpacity>
    </View>
  );
}
