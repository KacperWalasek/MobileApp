import { StatusBar } from 'expo-status-bar';
import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import User from './User';
import {mainStyles} from './styles';

export default function App() {
  return (
    <View style={mainStyles.container}>
      <View>
        <User name="Andrzej" surname="Wasek"></User>
        <User name="Stefan" surname="Wasek"></User>
      </View>
      <View>
        <User name="Marek" surname="Wasek"></User>
        <User name="Kacper" surname="Wasek"></User>
      </View>
    </View>
  );
}

