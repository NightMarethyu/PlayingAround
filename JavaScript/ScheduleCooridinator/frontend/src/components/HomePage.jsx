import React from "react";
import { useAuth } from "./AuthContext";
import { useNavigate } from "react-router-dom";

const HomePage = () => {
  const { user, login, logout } = useAuth();
  const navigate = useNavigate();

  const handleLoginRedirect = () => {
    navigate("/login");
  };

  return (
    <div>
      {user ? (
        <>
          <h1 className="display-1">General {user.username}</h1>
          <div className="row">
            <div className="col-sm">
              <button onClick={logout} className="btn btn-success btn-block">Logout</button>
            </div>
            <div className="col-sm">
              <button onClick={() => navigate("/newActivity")} className="btn btn-success btn-block">New Activity</button>
            </div>
            <div className="col-sm">
              <button onClick={() => navigate("/activities")} className="btn btn-success btn-block">View Activities</button>
            </div>
          </div>
        </>
      ) : (
        <>
          <h1 className="display-1">Hello There</h1>
          <button onClick={handleLoginRedirect} className="btn btn-success">Login</button>
        </>
      )}
    </div>
  );
};

export default HomePage;
