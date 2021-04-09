import React, { useState } from 'react';
import List from './List';
import PartyMembersHeader from './PartyMembersHeader';
import UserListEntity from './UserListEntity';

export default function UserList({navigation, route}) {
  const [users, setUsers] = useState([]);
  const [reload, setReload] = useState([false]);
  React.useLayoutEffect(() => {
      navigation.setOptions({
          headerRight: () => (
              <PartyMembersHeader navigation={navigation} users={users} party={route.params.context.party} onGoBack={()=>setReload(true)}/>
          ),
      });
  }, [navigation, users]);
  return ( 
    <List getList={route.params.getList} notifyList={setUsers} Entity={UserListEntity} navigation={navigation} context={route.params.context} reload={reload}></List>
  );
}
