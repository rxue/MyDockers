import React from "react";

const CityList = ({ data }) => {
  console.log(data);
  const renderCities = cities =>
    cities
      ? cities.map(city => (
          <option key={city.id} value={city.id}>
            {city.city}
          </option>
        ))
      : null;
  return (
    <div>
      <select name="city">{renderCities(data.cities)}</select>
      {/* this.handleChange is just a reference */}
    </div>
  );
};
export default CityList;
