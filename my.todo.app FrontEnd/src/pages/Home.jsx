import axios from 'axios'
import React, { useEffect, useState } from 'react'

const data = [
    {
        id: 1,
        title: "Task 1",
        completed: false
    },
    {
        id: 2,
        title: "Task 2",
        completed: false
    },
    {
        id: 3,
        title: "Task 3",
        completed: false
    },
    {
        id: 4,
        title: "Task 4",
        completed: true
    },
]

const Home = () => {
    const [title, setTitle] = useState('')
    const [tasks, setTasks] = useState(data)

    const handleAdd = async() => {
        await axios.post("http://localhost:9090/todos/"+title)
        setTasks([...tasks, {
            id: 5,
            task:title,
            completed: false
        }])
    }
    useEffect(() => {
        const getData = async()=> {
            const res = await axios.get("http://localhost:9090/todos")
            setTasks(res.data)
            }
            getData()
    }, [])
  return (
    <div style={{display:'flex', flexDirection: 'column'}} >
        <h2>Tasks</h2>
        <input placeholder='Nouvelle Task' 
        onChange={({target}) => setTitle(target.value)}
        />
        <button
        onClick={handleAdd}
        >Ajouter</button>
        {
            tasks.map(t => (
            <div style={{display: 'flex', flexDirection: 'row', width: '50vw', 
            justifyContent: 'space-between', placeItems: 'center'}}
            key={t.id}
            >
            {
            t.completed ?
            <span style={{textDecoration: 'line-through'}}> {t.task} </span>
            :
            <span> {t.task} </span>    
            }
            <input type='checkbox' checked={t.completed}
            onChange={async() => {
                if(t.completed){
                    await axios.put("http://localhost:9090/todos/uncompleted/"+t.id)
                setTasks(tasks.map(x => (x.id === t.id ? { ...x, completed: false } : x)))
                }
                else{
                    await axios.put("http://localhost:9090/todos/completed/"+t.id)
                setTasks(tasks.map(x => (x.id === t.id ? { ...x, completed: true } : x)))
                } 
            }}
            />
            <button onClick={async () => {
                await axios.delete("http://localhost:9090/todos/"+t.id)
                setTasks(tasks.filter(el => el.id != t.id))
            }} >Supprimer</button>
            </div>
            ))
        }
    </div>
  )
}

export default Home