import { StyleSheet} from 'react-native';

export const headerStyles = StyleSheet.create({
    container: {
        flex: 1,
        height: 50,
        justifyContent: 'space-between',
        alignItems: 'center',
        flexDirection: 'row',
    },
    rightItem:{
        flexDirection: 'row',
    },
    headerButton: {
        margin: 10
    }
});
export const panelStyles = StyleSheet.create({
    
    box: {
        width: '90%',
        height: 150,
        alignItems: 'center',
        justifyContent: 'center',
        backgroundColor: 'white',
        margin: 20,
        borderWidth: 8,
        borderRadius: 20,
    },
    yellowBox: {
        backgroundColor: 'yellow',
        borderColor: 'lightblue',
    },
});
export const formStyles = StyleSheet.create({
    form: {
        width: '70%'
    },
    input: {
        marginTop: 10,
        marginBottom: 20,
        height: 40,
        backgroundColor: 'white',
    },
    label: {
        fontSize: 20
    },
    button:{
        backgroundColor: 'blue',
        alignItems: 'center',
        padding: 10,
        borderRadius: 10
    },
    buttonText: {
        fontSize: 20,
        color: 'white'
    },
    smallButton: {
        backgroundColor: 'gray',
        alignItems: 'center',
        padding: 5,
        borderRadius: 10
    },
    smallButtonText: {
        fontSize: 16,
        color: 'white'
    }
});
export const viewingStyles = StyleSheet.create({
    centerColumn: {
        flex: 1,
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center'
    },
    columns: {
        flex: 1,
        flexDirection: 'row',
    },
    space: {
        justifyContent: 'space-between'
    },
});
export const listItemStyles = StyleSheet.create({
    leftSide: {
        padding: 10
    },
    container: {
        backgroundColor: 'white',
        marginBottom: 2,
        height: 100
    },
    special: {
        backgroundColor: 'blue'
    }
});
