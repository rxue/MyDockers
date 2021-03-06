import React, { Component } from "react";
import { connect } from "react-redux";
import { citylist, shoplist, localshoplist } from "../actions";
import { bindActionCreators } from "redux";
import CityList from "../components/insertion_citylist";
import ShopList from "../components/insertion_shoplist";

class App extends Component {
  componentDidMount() {
    console.log("mount");
    this.props.citylist();
  }

  componentDidUpdate(prevProps, prevState) {
    console.log("Component did update");
  }

  findShops(event) {
    console.log("find shops", this.props);
    this.props.localshoplist(event.target.value);
  }

  render() {
    console.log("render:", this.props);
    return (
      <div>
        <CityList
          findShops={this.findShops.bind(this)}
          cities={this.props.data.cities}
        />
        <ShopList {...this.props} />
        {/* Use of spread operator: https://www.youtube.com/watch?v=NCwa_xi0Uuc&t=1721s*/}
      </div>
    );
  }
}

const mapStateToProps = state => {
  console.log("map state to props", state);
  return { data: state.insertion_data };
};

const mapDispathToProps = dispatch => {
  console.log("map dispatch to props");
  return bindActionCreators({ citylist, shoplist, localshoplist }, dispatch);
};

export default connect(
  mapStateToProps,
  mapDispathToProps
)(App);
