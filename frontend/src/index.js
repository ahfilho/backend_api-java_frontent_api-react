import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

import List from './listagem/List';
import Ssd from './formulario/Ssd';
import Client from './client/Client';
import ListClient from './client/ListClient';
import SsdList from './formulario/SsdList';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/* <App /> */}
    {/* <List></List> */}
    <Ssd/>
    {/* <Client></Client> */}
    {/* <ListClient/> */}
    {/* <SsdList></SsdList> */}
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
