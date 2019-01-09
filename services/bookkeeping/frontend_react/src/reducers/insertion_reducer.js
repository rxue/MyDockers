export default function(state = {}, action) {
  switch (action.type) {
    case "CITY_LIST":
      return { ...state, cities: action.payload };
    case "SHOP_LIST":
      return { ...state, shops: action.payload };
    case "LOCAL_SHOP_LIST":
      return { ...state, localshops: action.payload };
    default:
      return state;
  }
}
