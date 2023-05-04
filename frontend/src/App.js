import "./App.css";
import React, { Fragment } from "react";
import "./index.css";
import {
  BrowserRouter,
  Switch,
  Route,
  Link
} from "react-router-dom";import Home from "./home/Home";
import Ssd from "./pages/ssd/Ssd";
import SsdList from "./pages/ssd/SsdList";
import Ram from "./pages/Ram";
import RamList from "./pages/RamList";
import Cpu from "./pages/Cpu";
import CpuList from "./pages/CpuList";
import SsdEdit from "./pages/ssd/SsdEdit";
import LoginPage from "./pages/LoginPage";
import { Dashboard } from './pages/dashboard/dashboard';
import NavBar from "./navbar/NavBar";
function App() {
  return (
    <BrowserRouter>
      <Switch> 
        {/* exact faz renderizar aquele determinado component */}

        {/* <div className="opcoes"> */}
          {/* <header> */}
          <Switch>
          <Route path="/navbar" exact component={NavBar} />

          <Route path="/" exact component={LoginPage} />
          <Route path="/dashboard" exact component={Dashboard} />

          <Route path="/home" exact component={Home} />
          <Route path="/ssd" exact component={Ssd} />
          <Route path="/ssdlist" exact component={SsdList} />
          <Route path="/ssdEdit/:id" exact component={SsdEdit} />

          <Route path="/ram" exact component={Ram} />
          <Route path="/ramlist" exact component={RamList} />

          <Route path="/cpu" exact component={Cpu} />
          <Route path="/cpulist" exact component={CpuList} />
          </Switch>
          {/* /</header>
           */}
        {/* </div> */}
      </Switch>
    </BrowserRouter>
    );
}
export default App;