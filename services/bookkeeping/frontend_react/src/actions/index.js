export function citylist() {
  return dispatch =>
    fetch("http://localhost:8080/masterdata/cities")
      .then(response => response.json())
      .then(json => {
        console.log(json);
        dispatch({ type: "CITY_LIST", payload: json });
      });
}

export function shoplist() {
  return {
    type: "SHOP_LIST",
    payload: [
      { id: 1, name: "Lidl", area: "Sello" },
      { id: 2, name: "K-Citymarket", area: "Sello" }
    ] //data retrieved from server
  };
}

export function localshoplist(city) {
  const cityShops = {
    Helsinki: [
      { id: 1, name: "Lidl", area: "City Center" },
      { id: 2, name: "K-Supermarket", area: "Kamppi" }
    ],
    Beijing: [
      { id: 1, name: "Wang Fujing Store", area: "Wang Fujing Street" },
      { id: 2, name: "Xi Dan", area: "Xi Dan Book Store" }
    ],
    default: [
      { id: 1, name: "Lidl", area: "Sello" },
      { id: 2, name: "Prisma", area: "Sello" }
    ]
  };
  return dispatch =>
    dispatch({
      type: "LOCAL_SHOP_LIST",
      payload: cityShops[city]
    });
}
