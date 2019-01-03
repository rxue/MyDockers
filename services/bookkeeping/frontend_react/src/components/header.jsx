import React, { Component } from "react"; //ES6 syntax

/**
 * Header is a class based component, who knows what is happening.
 *
 * Whenever using a class, you need to use the render method
 */
export default class Header extends Component {
  render() {
    return (
      <header>
        <div className="header">Bookkeeping</div>
      </header>
    );
  }
}
