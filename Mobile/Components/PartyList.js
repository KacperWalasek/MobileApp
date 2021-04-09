import React from 'react';
import List from './List';
import PartyListEntity from './PartyListEntity';

export default function PartyList({navigation, route}) {

  return ( 
    <List getList={route.params.getList} Entity={PartyListEntity} navigation={navigation}></List>
  );
}
