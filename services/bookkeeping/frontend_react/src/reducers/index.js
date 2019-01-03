import { combineReducers } from "redux";
import cities from "./insertion_reducer";
import shops from "./insertion_reducer";

const rootReducer = combineReducers({ cities, shops });

export default rootReducer;
