export default function(state = {}, action) {
  switch (action.type) {
    case "CITY_LIST":
      return { ...state, cities: action.payload };
    case "SHOP_LIST":
      return { ...state, shops: action.payload };
    default:
      return state;
  }
}
