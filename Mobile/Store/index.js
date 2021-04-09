import {applyMiddleware, createStore} from 'redux';
import thunk from 'redux-thunk';
import reducer from './Reducers';

export default store = createStore(reducer, applyMiddleware(thunk));