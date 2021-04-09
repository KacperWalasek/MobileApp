import { StyleSheet} from 'react-native';

export const userStyles = StyleSheet.create({
    container: {
        backgroundColor: "red",
        margin: 10, //margines wokół elementu
        padding: 10 // margines wewnątrz elementu
    },
    name: {
        color: "white", // kolor czcionki
    },
    input: {
        backgroundColor: "yellow"
    },
    touchable: {
        height: 100, //można bezpośrednio ustawić wysokość i szerokość (jeśli tego nie zrobisz dopasują się do wielkości zawartości)
        width: 100,
        backgroundColor: "white",
    }
});
export const mainStyles = StyleSheet.create({
    container: {
        flex: 1, // musi być, żeby można było używać flexDirextion
        flexDirection: 'row', // układ elementów wewnatrz
        alignItems: 'center', // umiejscowienie w pionie
        justifyContent: 'center', // umiejscowienie w poziomie
    },
});