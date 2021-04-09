import React from 'react';
import { Button, StyleSheet, Text, View } from 'react-native';
import { TextInput } from 'react-native-gesture-handler';
import Icon from 'react-native-vector-icons/FontAwesome';

export default function Register() {
  return (
    <View style={styles.view}>
        <View style={styles.container}>
            <Text style={styles.text}>Login</Text>
            <TextInput style={styles.box}></TextInput>
            <Text style={styles.text}>Email</Text>
            <TextInput style={styles.box}></TextInput>
            <Text style={styles.text}>Hasło</Text>
            <TextInput style={styles.box}></TextInput>
            <Button title="Zarejestruj się"></Button>
            
        </View>
    
    </View>
  );
}
const styles = StyleSheet.create({
    text: {
        color: 'red',
        fontSize: 24
    },
    container: {
        backgroundColor: 'rgb(220,220,220)',
        width: 300,
        padding: 50
    },
    view: {
        flex: 1,
        flexDirection: 'row',
        alignItems: 'center',
        justifyContent: 'center'
    },
    box: {
        margin: 20,
        backgroundColor: 'white'
    }
})
