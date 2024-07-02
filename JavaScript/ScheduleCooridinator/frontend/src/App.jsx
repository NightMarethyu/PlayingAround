import React from "react";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { AuthProvider } from "./components/AuthContext";

// Import Custom Components
import Navigation from "./components/Navigation";
import HomePage from "./components/HomePage";
import Login from "./components/Login";
import Signup from "./components/Signup";
import CreateActivity from "./components/CreateActivity";
import ViewActivities from "./components/ViewActivities";
import ActivityDetail from "./components/ActivityDetail";
import AddAvailability from "./components/AddAvailability";
import TestApi from "./components/TestApi";

// Import CSS
import "./App.css";
import "./stylesheets/bootstrap4-neon-glow.css";

function App() {
  return (
    <>
      <AuthProvider>
        <BrowserRouter>
          <Navigation />
          <Routes>
            <Route path="/" element={<HomePage />} />
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
            <Route path="/newActivity" element={<CreateActivity />} />
            <Route path="/testapi" element={<TestApi />} />
            <Route path="/activities" element={<ViewActivities />} />
            <Route path="/activities/:id" element={<ActivityDetail />} />
            <Route path="/addAvailability/:id" element={<AddAvailability />} />
          </Routes>
        </BrowserRouter>
      </AuthProvider>
      <div className="container">
        <span className="hal-9000 mx-auto bottom-0 start-50 d-flex"></span>
      </div>
    </>
  );
}

export default App;
