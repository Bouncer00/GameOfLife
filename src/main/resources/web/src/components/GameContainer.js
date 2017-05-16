import React from 'react';
import Websocket from 'react-websocket';

class GameContainer extends React.Component {

  constructor(props) {
    super(props);
    this.state = {};
  }

  componentDidMount(){
    console.log("componentDidMount");
  }

  handleData(data){
    console.log("handleData");
    console.log(data);
  }

  render(){
    return(
      <div>

      </div>
    );
  }

}

export default GameContainer;
