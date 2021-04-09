import React, { useState } from 'react';
import { Button, StyleSheet, Text, Touchable, TouchableOpacity, View } from 'react-native';
import { TextInput } from 'react-native-gesture-handler';
import { connect } from 'react-redux';
import handleError from '../API/ApiFunctions';
import createLoginAction from './../Store/ActionCreators/LoginActionCreator';
import {formStyles, viewingStyles} from './../styles';
function Login({navigation, dispatch}) {
    const [loginData, setLoginData] = useState({username: "", password: ""});
    return (
    <View style={viewingStyles.centerColumn}>
        <View style={formStyles.form}>
            <Text style={formStyles.label}>Login</Text>
            <TextInput style={formStyles.input} onChangeText={(text)=>setLoginData({...loginData, username: text })}></TextInput>
            <Text style={formStyles.label}>Hasło</Text>
            <TextInput style={formStyles.input} onChangeText={(text)=>setLoginData({...loginData, password: text })}></TextInput>
            <TouchableOpacity style={formStyles.button} onPress={()=>{
                dispatch(createLoginAction(loginData))
                    .then(()=>navigation.navigate('Menu'))
                    .catch(error=>{handleError(error); });
                }}>
                <Text style={formStyles.buttonText}>Zaloguj</Text>
            </TouchableOpacity>
        </View>

    </View>
    );
}
export default connect(state=>({...state}))(Login);