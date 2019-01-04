export default function(state = {}, action) {
  //console.log("reduce cases");
  switch (action.type) {
    case "CITY_LIST":
      return { ...state, cities: action.payload };
    case "SHOP_LIST":
      return { ...state, shops: action.payload };
    default:
      return state;
  }
}
