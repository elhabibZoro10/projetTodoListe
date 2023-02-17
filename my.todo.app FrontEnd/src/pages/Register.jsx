import axios from 'axios'
import React, { useContext, useState } from 'react'
import { useNavigate, useNavigation } from 'react-router-dom'
import { UserContext } from '../App'

const Register = () => {
  const [email, setEmail] = useState('')
  const [nom, setNom] = useState('')
  const [password, setPassword] = useState('')
  const {auth, setAuth} = useContext(UserContext)
  const navig = useNavigate()
  const todo = async() => {
    await axios.post("http://localhost:9090/users/signUp",{
      name:nom,
      email,
      password
    })
  }
    return (
    <div>
        <h1>Registration</h1>
        <input required placeholder='Nom'
        style={{width: '30vw', paddingtop: '5px', paddingBottom: '5px', marginBottom: 20}}
        onChange={({target}) => setNom(target.value)}
        />
        <br/>
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
        <button onClick={todo} >Register</button>
    </div>
  )
}

export default Register