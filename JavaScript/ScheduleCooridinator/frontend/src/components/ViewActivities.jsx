import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';
import PaginationComponent from './helperComponents/Pagination';
import { formatDate } from '../scripts/helpers'

const ViewActivities = () => {
  const [data, setData] = useState([]);
  const [loading, setLoading] = useState(true);
  const [currentPage, setCurrentPage] = useState(1);
  const [activitiesPerPage] = useState(9);
  const [totalPages, setTotalPages] = useState(0);

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      try {
        const response = await axios.get(`${process.env.REACT_APP_API_URL}/activity?page=${currentPage}`, {
          headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`,
          },
        });
        setData(response.data.activities);
        setTotalPages(response.data.totalPages);
        setLoading(false);
      } catch (e) {
        console.error('Error fetching activities:', e);
        setLoading(false);
      }
    };
    fetchData();
  }, [currentPage]);

  const handlePageChange = (newPage) => {
    setCurrentPage(newPage);
    setLoading(true); // Optional: Set loading to true to show a loading state between page changes
  };

  return (
    <>
      <h2 className='display-2'>Available Activities</h2>
      {loading ? (
        <div className='d-flex justify-content-center'>
          <div className='spinner-border' role='status'>
            <span className='sr-only'>Loading...</span>
          </div>
        </div>
      ) : (
        <div className='container'>
          <div className='row justify-content-around'>
            {data.map((activity) => (
              <div className='col-lg-4 mb-4'>
                <div className='card' key={activity._id}>
                  <h3 className='card-body'>{activity.activityName}</h3>
                  <p className='card-text'>Category: {activity.category}</p>
                  {activity.availableUntil && <p>Available Until: {formatDate(activity.availableUntil)}</p>}
                  <Link to={`/activities/${activity._id}`} className='btn btn-success'>Join Activity</Link>
                </div>
              </div>
            ))}
          </div>
        </div>
      )}
      <PaginationComponent
        currentPage={currentPage}
        totalPages={totalPages}
        handlePageChange={handlePageChange} />
    </>
  );
};

export default ViewActivities;