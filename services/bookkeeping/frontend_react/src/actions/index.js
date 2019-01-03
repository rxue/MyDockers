export function citylist() {
  return dispatch =>
    fetch("http://localhost:8080/masterdata/cities")
      .then(response => response.json())
      .then(json => dispatch({ type: "CITY_LIST", payload: json }));
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
