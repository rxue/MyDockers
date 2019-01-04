import React from "react";

const ShopList = ({ data }) => {
  console.log("shops to component:" + data.shops);
  const renderShops = sho =>
    sho
      ? sho.map(shop => (
          <option key={shop.id} value={shop.id}>
            {shop.name}
          </option>
        ))
      : null;
  return (
    <div>
      <select name="shop">{renderShops(data.shops)}</select>
      {/* this.handleChange is just a reference */}
    </div>
  );
};
export default ShopList;
