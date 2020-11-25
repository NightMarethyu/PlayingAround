import React, { useState, useEffect } from 'react';

const url = 'https://api.github.com/users/QuincyLarson';

const MultipleReturns = () => {
  const [isLoading, setIsLoading] = useState(true)
  const [isError, setIsError] = useState(false)
  const [user, setUser] = useState('default user')

  useEffect(() => {
    fetch(url)
      .then((resp) => {
        if (resp.status >= 200 && resp.status <= 299) {
          return resp.json()
        } else {
          setIsLoading(false)
          setIsError(true)
          throw new Error (resp.statusText)
        }
      })
      .then((user) => {
        // console.log(user)
        const {login} = user
        setUser(login)
        setIsLoading(false)})
      .catch((error) => {
        console.log(error)
        setIsError(true)
      });
  }, [])

  if (isLoading) {
    return <h2>Loading...</h2>
  }

  if (isError) {
    return <h2>Error...</h2>
  }

  return (
  <>
  <h1>{user}</h1>
  </>
  );
};

export default MultipleReturns;
