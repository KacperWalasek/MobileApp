import React from 'react';
import { Button, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import { getMembers } from '../API/PartyApi';
import {panelStyles, viewingStyles} from '../styles';
import UserListEntity from './UserListEntity';

export default function Party({route, navigation}) {
    return (
    <View style={viewingStyles.centerColumn}>
        <View >
            <Text>{route.params.name}</Text>
        </View>
        <View style={viewingStyles.columns}>
            <View style={viewingStyles.centerColumn}>
                <TouchableOpacity style={panelStyles.box}>
                    <Text>Szczegóły</Text>
                </TouchableOpacity>
                <TouchableOpacity onPress={()=>navigation.navigate('UserList', {
                    getList: ()=>getMembers(route.params.party.id),
                    context: {
                        party: route.params.party
                    }
                })} style={panelStyles.box}>
                    <Text>Osoby</Text>
                </TouchableOpacity>
            </View>
            <View style={viewingStyles.centerColumn}>
                <TouchableOpacity style={panelStyles.box}>
                    <Text>Zakupy</Text>
                </TouchableOpacity>
                <TouchableOpacity style={panelStyles.box}>
                    <Text>Transport</Text>
                </TouchableOpacity> 
            </View>
        </View>
    </View>
  );
}
