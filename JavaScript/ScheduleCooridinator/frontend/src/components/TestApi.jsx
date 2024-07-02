import React, { useEffect, useState } from 'react';
import axios from 'axios';

const TestApi = () => {
  const [apiResponse, setApiResponse] = useState('');

  useEffect(() => {
    axios.get('http://localhost:3000/testapi').then(response => {
      setApiResponse(response.data);
    })
    .catch(e => {
      console.error('Error fetching data:', e);
    });
  }, []);

  return(
    <>
    {apiResponse}
    </>
  )
};

export default TestApi;