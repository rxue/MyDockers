import React from "react";

const renderCities = cityList =>
  cityList
    ? cityList.map(city => (
        <option key={city.city} value={city.city}>
          {city.city}
        </option>
      ))
    : null;

const CityList = props => {
  return (
    <div>
      <select name="city" onChange={e => props.findShops(e)}>
        {renderCities(props.cities)}
      </select>
      {/* this.handleChange is just a reference */}
    </div>
  );
};
export default CityList;
