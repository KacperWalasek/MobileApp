import React, { useEffect, useState } from 'react';
import { Button, StyleSheet, Text, TouchableOpacity, View } from 'react-native';
import { FlatList } from 'react-native-gesture-handler';
export default function List({navigation, getList, notifyList, Entity, context, reload}) {
  const [list, setList] = useState([]);
  const [loaded, setLoaded] = useState(false);
  function load(){
    setLoaded(false);
    getList()
      .then((data)=>{ 
        setList(data);
        if(notifyList)
          notifyList(data);
        setLoaded(true);
      })
  }
  useEffect(()=>{
    load();
  },[getList])

  if(reload){
    load();
    reload = false;
    console.log('load');
  }
  return ( 
    <View>
      {list? 
        <FlatList
          data={list.slice(0, list.length)}
          renderItem={(item)=><Entity {...item} {...context} navigation={navigation}/>}
        >
        </FlatList>
        :
        <Text>Nie znaleziono żadnej imprezy</Text>}
    </View>
  );
}
