const Users = require("../models/users");
const bcrypt = require("bcryptjs");
const hashPassword = require("../helpers/hash");
const asyncHandler = require("express-async-handler");
const jwtAuthenticate = require("../auth/auth").jwtAuthenticate;

// get all users with GET request
exports.users_list = asyncHandler(async (req, res, next) => {
  const users = await Users.find();
  res.json(users);
});

// create new user account with POST request
exports.users_create_post = asyncHandler(async (req, res, next) => {
  try {
    var userData = req.body;
    userData.password = await hashPassword(req.body.password);
    const user = new Users(userData);
    await user.save();
    res.status(201).json(user);
  } catch (error) {
    if (error.name === "MongoServerError" && error.code === 11000) {
      return res
        .status(400)
        .json({ error: "Username or email already exists" });
    } else {
      return res.status(500).json({ error: "Internal server error" });
    }
  }
});

// update user account with PATCH request
exports.users_update_patch = asyncHandler(async (req, res, next) => {
  const { oldPassword, newPassword, ...updateData } = req.body;

  const user = await Users.findById(req.params.id);
  if (!user) {
    return res.status(404).json({ error: "User not found" });
  }

  if (updateData.username) {
    return res.status(400).json({ error: "Username cannot be updated" });
  }

  const requestUser = await Users.findById(req.user.id);

  if (newPassword && !requestUser.isAdmin()) {
    const isMatch = await bcrypt.compare(oldPassword, user.password);
    if (!isMatch) {
      return res.status(400).json({ error: "Invalid password" });
    }
  }

  if (newPassword) {
    const hashedPassword = await hashPassword(newPassword);
    updateData.password = hashedPassword;
  }

  updateData.updated = Date.now();

  await Users.findByIdAndUpdate(req.params.id, updateData);

  const updatedUser = await Users.findById(req.params.id);
  res.json(updatedUser);
});

// delete user account with DELETE request
exports.users_delete = asyncHandler(async (req, res, next) => {
  const user = await Users.findByIdAndDelete(req.params.id);
  res.json(user);
});

// login user with POST request
exports.users_login_post = asyncHandler(async (req, res, next) => {
  const result = await jwtAuthenticate(req);
  if (result.error) {
    return res.status(result.status).json({ error: result.error });
  }
  res
    .status(result.status)
    .json({ token: result.token, username: req.body.username });
});

// get one user with GET request
exports.users_detail = asyncHandler(async (req, res, next) => {
  const user = await Users.findById(req.params.id);
  res.json(user);
});
