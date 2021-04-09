import React, {useState} from 'react';
import { Text, View,TouchableOpacity } from 'react-native';
import { TextInput } from 'react-native-gesture-handler';
import { Party } from '../Models/Party';
import {formStyles, viewingStyles} from '../styles';
import {addParty} from '../API/PartyApi'
export default function PartyCreator({navigation}) {
  const [party, setParty] = useState(new Party());
  return (
    <View style={viewingStyles.centerColumn}>
        <View style={formStyles.form}>
            <Text style={formStyles.label}>Nazwa</Text>
            <TextInput style={formStyles.input} onChangeText={value=>setParty({...party, name: value })}></TextInput>
            <Text style={formStyles.label}>Data</Text>
            <TextInput style={formStyles.input} onChangeText={value=>setParty({...party})}></TextInput>
            <Text style={formStyles.label}>Adres</Text>
            <TextInput style={formStyles.input} onChangeText={value=>setParty({...party, address: value })}></TextInput>
            <TouchableOpacity style={formStyles.button} onPress={()=>{
                addParty(party)
                .then(result=>{
                  if(result)
                    navigation.navigate('Party', {...party});
                });
                }}>
                <Text style={formStyles.buttonText}>Dalej</Text> 
            </TouchableOpacity>
        </View>
     </View>
    // {/*<View style={styles.view}>
        
    //     <View style={styles.container}>
    //         <Text style={styles.text}>Nazwa</Text>
    //         <TextInput style={styles.box}></TextInput>
    //         <Text style={styles.text}>Data</Text>
    //         <TextInput style={styles.box}></TextInput>
    //         <Text style={styles.text}>Adres</Text>
    //         <TextInput style={styles.box}></TextInput>
    //         <Button title="Znajdź na mapie"></Button>       
    //          <Switch></Switch>
    //         <Button title="Dodaj gości"></Button>
    //     </View>
    // </View> */}
  );
}