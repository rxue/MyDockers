import React, { Component } from "react";
import { connect } from "react-redux";
import { citylist, shoplist } from "../actions";
import { bindActionCreators } from "redux";
import CityList from "../components/insertion_citylist";
import ShopList from "../components/insertion_shoplist";

class App extends Component {
  componentDidMount() {
    console.log("mount");
    this.props.citylist();
    this.props.shoplist();
  }

  /* renderShops = shops =>
    shops
      ? shops.map(shop => <option key={shop.id} value={shop.name} />)
      : null; */
  render() {
    console.log("render:" + this.props);
    return (
      <div>
        <CityList {...this.props} />
        <ShopList {...this.props} />
        {/* <input list="shop" placeholder="shop" />
        <datalist id="shop">
          {this.renderShops(this.props.shop_data.shops)}
        </datalist> */}
      </div>
    );
  }
}

const mapStateToProps = state => {
  console.log("map state to props:" + state.shops);
  return { data: state.insertion_data }; //Use of spread operator: https://www.youtube.com/watch?v=NCwa_xi0Uuc&t=1721s
  //return { city_data: state.cities, shop_data: state.shops };
};

const mapDispathToProps = dispatch => {
  console.log("map dispatch to props");
  return bindActionCreators({ citylist, shoplist }, dispatch);
};

export default connect(
  mapStateToProps,
  mapDispathToProps
)(App);
