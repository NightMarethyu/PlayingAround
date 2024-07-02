const express = require("express");
const router = express.Router();

const users_controller = require("../controllers/usersController");
const jwtAuthorize = require("../auth/auth").jwtAuthorize;
const isAdmin = require("../auth/auth").isAdmin;
const isUserorAdmin = require("../auth/auth").isUserorAdmin;

// POST request for creating a User.
router.post("/signup", users_controller.users_create_post);

// POST request for logging in a User.
router.post("/login", users_controller.users_login_post);

// PATCH request to update User password.
router.patch(
  "/:id",
  jwtAuthorize,
  isUserorAdmin,
  users_controller.users_update_patch
);

// DELETE request to delete User.
router.delete(
  "/:id",
  jwtAuthorize,
  isUserorAdmin,
  users_controller.users_delete
);

// GET request for list of all Users.
router.get("/", jwtAuthorize, isAdmin, users_controller.users_list);

// GET request for one User.
router.get("/:id", jwtAuthorize, isUserorAdmin, users_controller.users_detail);

module.exports = router;
