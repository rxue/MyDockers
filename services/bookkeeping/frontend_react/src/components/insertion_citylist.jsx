import React from "react";

const renderCities = cityList =>
  cityList
    ? cityList.map(city => (
        <option key={city.city} value={city.city}>
          {city.city}
        </option>
      ))
    : null;

const CityList = ({ data }) => {
  console.log("cities into component: " + data.cities);

  return (
    <div>
      <select name="city">{renderCities(data.cities)}</select>
      {/* this.handleChange is just a reference */}
    </div>
  );
};
export default CityList;
