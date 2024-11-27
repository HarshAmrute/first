import React, { useState, useEffect } from 'react';

function App() {
    const [todos, setTodos] = useState([]);
    const [inputValue, setInputValue] = useState('');
    const [filter, setFilter] = useState('all');

    // Load todos from local storage when the component mounts
    useEffect(() => {
        const storedTodos = JSON.parse(localStorage.getItem('todos'));
        if (storedTodos) {
            setTodos(storedTodos);
        }
    }, []);

    // Save todos to local storage whenever the todos change
    useEffect(() => {
        localStorage.setItem('todos', JSON.stringify(todos));
    }, [todos]);

    const addTodo = (e) => {
        e.preventDefault();
        if (inputValue.trim() === '') return;

        const newTodo = {
            id: Date.now(),
            text: inputValue,
            completed: false,
        };

        setTodos((prevTodos) => [...prevTodos, newTodo]); // Use functional state update
        setInputValue('');
    };

    const toggleTodo = (id) => {
        setTodos((prevTodos) =>
            prevTodos.map(todo => 
                todo.id === id ? { ...todo, completed: !todo.completed } : todo
            )
        );
    };

    const deleteTodo = (id) => {
        setTodos((prevTodos) => prevTodos.filter(todo => todo.id !== id));
    };

    // Filter todos based on the selected filter
    const filteredTodos = todos.filter(todo => {
        if (filter === 'completed') return todo.completed;
        if (filter === 'active') return !todo.completed;
        return true; // 'all' case
    });

    return (
        <div style={{ maxWidth: '500px', margin: '0 auto', padding: '20px', fontFamily: 'Arial, sans-serif' }}>
            <h1>To-Do List</h1>
            <form onSubmit={addTodo} style={{ display: 'flex', marginBottom: '20px' }}>
                <input
                    type="text"
                    value={inputValue}
                    onChange={(e) => setInputValue(e.target.value)}
                    placeholder="Add a new task"
                    style={{ flexGrow: 1, padding: '10px', borderRadius: '5px', border: '1px solid #ccc' }}
                />
                <button type="submit" style={{ padding: '10px', borderRadius: '5px', marginLeft: '10px' }}>Add</button>
            </form>

            <div>
                <label style={{ marginRight: '10px' }}>Filter: </label>
                <select onChange={(e) => setFilter(e.target.value)} value={filter}>
                    <option value="all">All</option>
                    <option value="active">Active</option>
                    <option value="completed">Completed</option>
                </select>
            </div>

            <div style={{ marginTop: '20px' }}>
                {filteredTodos.map(todo => (
                    <div key={todo.id} style={{ display: 'flex', alignItems: 'center', margin: '5px 0' }}>
                        <input
                            type="checkbox"
                            checked={todo.completed}
                            onChange={() => toggleTodo(todo.id)}
                        />
                        <span style={{
                            textDecoration: todo.completed ? 'line-through' : 'none',
                            marginLeft: '10px',
                            flexGrow: 1,
                        }}>
                            {todo.text}
                        </span>
                        <button onClick={() => deleteTodo(todo.id)} style={{ marginLeft: '10px', borderRadius: '5px' }}>
                            Delete
                        </button>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default App;
