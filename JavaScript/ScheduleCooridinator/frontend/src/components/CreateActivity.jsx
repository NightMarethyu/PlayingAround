import React, { useState } from 'react';
import axios from 'axios';
import ActivityCategories from '../activityCategories';

const CreateActivity = () => {
  const [activityName, setActivityName] = useState('');
  const [category, setCategory] = useState('');

  const handleCreate = async () => {
    try {
      const token = localStorage.getItem('token');
      await axios.post(`${process.env.REACT_APP_API_URL}/activity`, { activityName, category }, {
        headers: {
          Authorization: `Bearer ${token}`,
        }
      });
      alert('Activity created successfully');
    } catch (e) {
      console.error('Error creating activity:', e);
    }
  };

  return (
    <>
      <h2 className='display-2'>Create New Activity</h2>
      <input
        type="text"
        value={activityName}
        onChange={(e) => setActivityName(e.target.value)}
        className='form-control'
      /><br />
      <select
        value={category}
        onChange={(e) => setCategory(e.target.value)}
        className='custom-select'
      >
        {ActivityCategories.map((category) => (
          <option key={category} value={category}>{category}</option>
        ))}
      </select><br />
      <button onClick={handleCreate} className='btn btn-success btn-shadow'>Create</button>
    </>
  );
};

export default CreateActivity;