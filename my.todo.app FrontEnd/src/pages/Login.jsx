import axios from 'axios'
import React, { useContext, useState } from 'react'
import { useNavigate, useNavigation } from 'react-router-dom'
import { UserContext } from '../App'

const Login = () => {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const {auth, setAuth} = useContext(UserContext)
  const navig = useNavigate()
  const todo = async() => {
    const ros = await axios.post("http://localhost:9090/users/login",{
      email,
      password
    })
    if(ros.data){
      setAuth(true)
      navig("/home")
    }
  }
    return (
    <div>
        <h1>Login</h1>
        <input required placeholder='Email'
        style={{width: '30vw', paddingtop: '5px', paddingBottom: '5px', marginBottom: 20}}
        onChange={({target}) => setEmail(target.value)}
        />
        <br/>
        <input required type="password" placeholder='Mot de passe' 
        style={{width: '30vw', paddingtop: '5px', paddingBottom: '5px', marginBottom: 20}}
        onChange={({target}) => setPassword(target.value)}
        />
        <br/>
        <button onClick={todo} >Connexion</button>
    </div>
  )
}

export default Login