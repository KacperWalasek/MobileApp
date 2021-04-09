import React, { useState } from 'react';
import List from './List';
import { getAllUsers } from "../API/UserApi";
import { Button, View, Text } from 'react-native';
import ChoseUserListEntity from './ChoseUserListEntity';
import { TouchableOpacity } from 'react-native-gesture-handler';
import { formStyles } from "../styles";
import { postMembers } from '../API/PartyApi';
import { PartyMemberDTO } from '../Models/dto/PartyMemberDTO';
export function ChoseUser({navigation, route}){

    const [chosenUsers, setChosenUsers] = useState([]);
    const isChosen = (user)=>chosenUsers.includes(user.id);
    const addUser = (user)=>setChosenUsers([...chosenUsers, user.id]);
    const removeUser = (user)=>setChosenUsers(chosenUsers.filter(chosen=>chosen!=user.id));

    return(
        <View>
            <List getList={()=>getAllUsers().then(data=>
                data.filter(user=>!route.params.users.find(member=>member.userId==user.id)))} 
                Entity={ChoseUserListEntity} 
                context={{chosenUsers, addUser, removeUser, isChosen}}></List>
            <TouchableOpacity style={formStyles.button} onPress={()=>{
                postMembers(chosenUsers.map(userId=>new PartyMemberDTO(route.params.party.id,userId)))
                    .then(response=>{
                        route.params.onGoBack();
                        navigation.goBack();
                    });
                }}>
                <Text style={formStyles.buttonText}>Dodaj {chosenUsers.length} osób</Text>
            </TouchableOpacity>
        </View>
    );
}