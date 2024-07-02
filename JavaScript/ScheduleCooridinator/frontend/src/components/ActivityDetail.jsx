import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";
import { useState, useEffect } from "react";
import { formatDate } from "../scripts/helpers";

const ActivityDetail = () => {
  const [details, setDetails] = useState(null);
  const [availability, setAvailability] = useState([]);
  const { id } = useParams();
  const navigate = useNavigate();

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(`${process.env.REACT_APP_API_URL}/activity/${id}`, {
          headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`,
          }
        });
        const result = await response.data;
        setDetails(result);

        const availabilityResponse = await axios.get(`${process.env.REACT_APP_API_URL}/availability/${id}`, {
          headers: {
            Authorization: `Bearer ${localStorage.getItem('token')}`,
          }
        });
        const availabilityResult = await availabilityResponse.data;
        setAvailability(availabilityResult);
      } catch (e) {
        console.error('Error fetching activity details:', e);
      }
    };
    fetchData();
  }, [id]);

  return (
    <>
      <h2 className="display-2">Activity Details</h2>
      {details ? (
        <><div>
          <h3 className="display-3">{details.activityName}</h3>
          <p>Category: {details.category}</p>
          {details.availableUntil && <p>Available Until: {formatDate(details.availableUntil)}</p>}
          <h4 className="display-4">Availability:</h4>
          <div className="container w-100">
            <div className="row justify-content-around">
              {availability.map((avail, index) => (
                <div className='col-12 col-sm-6 col-md-4 col-lg-3 mb-4 d-flex align-items-stretch'>
                  <div key={index} className="card w-100">
                    <div className="card-header w-100">Particpant: {avail.participantName}</div>
                    <p className="card-text">Monday:</p>
                    <ul className="list-group">
                      {avail.monday.map((timeRange, timeIndex) => (
                        <li key={timeIndex} className="card-text list-group-item">{timeRange.start} - {timeRange.end}</li>
                      ))}
                    </ul>
                    <p className="card-text">Tuesday:</p>
                    <ul className="list-group">
                      {avail.tuesday.map((timeRange, timeIndex) => (
                        <li key={timeIndex} className="card-text list-group-item">{timeRange.start} - {timeRange.end}</li>
                      ))}
                    </ul>
                    <p className="card-text">Wednesday:</p>
                    <ul className="list-group">
                      {avail.wednesday.map((timeRange, timeIndex) => (
                        <li key={timeIndex} className="card-text list-group-item">{timeRange.start} - {timeRange.end}</li>
                      ))}
                    </ul>
                    <p className="card-text">Thursday:</p>
                    <ul className="list-group">
                      {avail.thursday.map((timeRange, timeIndex) => (
                        <li key={timeIndex} className="card-text list-group-item">{timeRange.start} - {timeRange.end}</li>
                      ))}
                    </ul>
                    <p className="card-text">Friday:</p>
                    <ul className="list-group">
                      {avail.friday.map((timeRange, timeIndex) => (
                        <li key={timeIndex} className="card-text list-group-item">{timeRange.start} - {timeRange.end}</li>
                      ))}
                    </ul>
                    <p className="card-text">Saturday:</p>
                    <ul className="list-group">
                      {avail.saturday.map((timeRange, timeIndex) => (
                        <li key={timeIndex} className="card-text list-group-item">{timeRange.start} - {timeRange.end}</li>
                      ))}
                    </ul>
                    <p className="card-text">Sunday:</p>
                    <ul className="list-group">
                      {avail.sunday.map((timeRange, timeIndex) => (
                        <li key={timeIndex} className="card-text list-group-item">{timeRange.start} - {timeRange.end}</li>
                      ))}
                    </ul>
                  </div>
                </div>
              ))}
            </div>
          </div>
        </div><button className="btn btn-success btn-shadow" onClick={() => navigate(`/addAvailability/${id}`)}>Set Availability</button></>
      ) : (
        <p>Loading...</p>
      )}
    </>
  );

};

export default ActivityDetail;