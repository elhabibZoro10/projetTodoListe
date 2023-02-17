import { createContext, useState } from 'react'
import reactLogo from './assets/react.svg'
import './App.css'
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import Login from './pages/Login';
import Home from './pages/Home';
import Register from './pages/Register';


export const UserContext = createContext();


function App() {
  const [count, setCount] = useState(0)
  const [auth, setAuth] = useState(false)

  const router = createBrowserRouter([
    {
      path: "/",
      element: <div>Hello world!</div>,
    },
    {
      path: '/register',
      element: <Register />
    },
    {
      path: "/login",
      element: <Login />
    },
    {
      path: "Home",
      element: auth ? <Home /> : <Login/>
    }
  ]);

  return (
    <UserContext.Provider value={{auth, setAuth}} >
    <div className="App">
       <RouterProvider router={router} />
    </div>
    </UserContext.Provider>
  )
}

export default App
