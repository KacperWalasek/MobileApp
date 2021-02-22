import React from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';
import { Switch } from "react-native";
import { TextInput } from 'react-native-gesture-handler';
import Icon from 'react-native-vector-icons/FontAwesome';

export default function Login() {
  return (
      
    <View style={styles.view}>
        
        <View style={styles.container}>
            <Text style={styles.text}>Nazwa</Text>
            <TextInput style={styles.box}></TextInput>
            <Text style={styles.text}>Data</Text>
            <TextInput style={styles.box}></TextInput>
            <Text style={styles.text}>Adres</Text>
            <TextInput style={styles.box}></TextInput>
            <Button title="Znajdź na mapie"></Button>       
             <Switch></Switch>
            <Button title="Dodaj gości"></Button>
             </View>
    
    </View>
  );
}
const styles = StyleSheet.create({
    text: {
        color: 'black',
        fontSize: 24
    },
    container: {
        backgroundColor: 'rgb(220,220,220)',
        width: 300,
        padding: 10
    },
    view: {
        flex: 2,
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center'
    },
    box: {
        margin: 20,
        backgroundColor: 'white'
    },
    

})
