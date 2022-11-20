import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';

import List from './listagem/List';
import AddSsd from './formulario/AddSsd';
import Upload from './formulario/Upload';
import Client from './client/Client';
import ListClient from './client/ListClient';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/* <App /> */}
    {/* <List></List> */}
    {/* <AddSsd/> */}
    {/* <Upload></Upload> */}
    {/* <Client></Client> */}
    <ListClient/>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
