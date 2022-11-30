import React from "react";
import axios from "axios";

export default class List extends React.Component {
  state = {
    clients: [],
  };
  // state = {
  //   categories: []
  // }

  componentDidMount() {
    axios.get("http://localhost:9090/client/list/client").then((res) => {
      const clients = res.data;
      this.setState({ clients });

      // const categories = res.data;
      // this.setCategories ({ categories});
    });
  }
  render() {
    return (
      <ul>
        {this.state.clients.map((client) => (
          <li>
            <div className="Todos"></div>
            <label></label>
            <li>
              key{client.id}
              {client.name}
              {client.contact}
              {client.email}
              {client.cpf}
            </li>
            ------------- TESTE AQUI -------------------
          </li>
        ))}
      </ul>
    );
  }
}
