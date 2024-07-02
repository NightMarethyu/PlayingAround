const express = require("express");
const router = express.Router();

const activity_controller = require("../controllers/activityController");
const jwtAuthorize = require("../auth/auth").jwtAuthorize;
const isAdmin = require("../auth/auth").isAdmin;
const checkCoordinator = require("../auth/auth").checkCoordinator;
const isCoordinatorOrAdmin = require("../auth/auth").isCoordinatorOrAdmin;

/* GET activity listing. */
router.get("/", jwtAuthorize, activity_controller.activity_list);

/* GET request for creating a Activity. */
router.get("/:id", jwtAuthorize, activity_controller.activity_detail);

/* POST request for creating Activity. */
router.post("/", jwtAuthorize, activity_controller.activity_create_post);

/* PATCH request to update Activity. */
router.patch(
  "/:id",
  jwtAuthorize,
  isCoordinatorOrAdmin,
  activity_controller.activity_update_patch
);

/* DELETE request to delete Activity. */
router.delete(
  "/:id",
  jwtAuthorize,
  isCoordinatorOrAdmin,
  activity_controller.activity_delete
);

module.exports = router;
