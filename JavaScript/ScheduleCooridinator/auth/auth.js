const jwt = require("jsonwebtoken");
const bcrypt = require("bcryptjs");
const User = require("../models/users");
const Activity = require("../models/activity");

exports.jwtAuthenticate = async (req) => {
  try {
    const { username, password } = req.body;
    const user = await User.findOne({ username });
    if (!user || !(await bcrypt.compare(password, user.password))) {
      return { error: "Authentication failed", status: 401 };
    }
    const token = jwt.sign({ id: user._id }, "secretkey");
    return { token, status: 200 };
  } catch (error) {
    console.error(error);
    return { error: "Internal server error", status: 500 };
  }
};

exports.jwtAuthorize = async (req, res, next) => {
  try {
    const token = req.headers.authorization.split(" ")[1];
    const decoded = jwt.verify(token, "secretkey");
    const user = await User.findById(decoded.id);

    if (!user) {
      console.log("User not found");
      return res.status(401).json({ error: "Unauthorized" });
    }

    req.user = user; // Attach the user document to req.user
    next();
  } catch (error) {
    console.error(error);
    res.status(401).json({ error: "Unauthorized" });
  }
};

exports.isAdmin = (req, res, next) => {
  if (!req.user.isAdmin()) {
    return res.status(403).json({ message: "Access denied. Admins only." });
  }
  next();
};

exports.isUserorAdmin = async (req, res, next) => {
  try {
    const user = await User.findById(req.params.id);
    if (!user) {
      return res.status(404).json({ message: "User not found" });
    }
    if (user._id.equals(req.user._id) || req.user.isAdmin()) {
      next();
    } else {
      return res.status(403).json({ message: "Access denied" });
    }
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: "Internal server error" });
  }
};

exports.isCoordinatorOrAdmin = async (req, res, next) => {
  try {
    const activity = await Activity.findById(req.params.id);
    if (!activity) {
      return res.status(404).json({ message: "Activity not found" });
    }
    if (activity.coordinatorID.equals(req.user._id) || req.user.isAdmin()) {
      next();
    } else {
      return res
        .status(403)
        .json({ message: "Access denied. Coordinator only." });
    }
  } catch (error) {
    console.error(error);
    res.status(500).json({ error: "Internal server error" });
  }
};
