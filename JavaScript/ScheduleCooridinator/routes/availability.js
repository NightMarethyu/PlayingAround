const express = require("express");
const router = express.Router();

const availability_controller = require("../controllers/availabilityController");
const jwtAuthorize = require("../auth/auth").jwtAuthorize;
const isUserorAdmin = require("../auth/auth").isUserorAdmin;

/* POST request for creating a Availability. */
router.post(
  "/:activityId",
  jwtAuthorize,
  availability_controller.availability_create_post
);

/* GET request for all availabilities related to an activity. */
router.get(
  "/:activityId",
  jwtAuthorize,
  availability_controller.availability_list
);

/* PATCH request to update Availability. */
router.patch(
  "/:id",
  jwtAuthorize,
  isUserorAdmin,
  availability_controller.availability_update_patch
);

/* DELETE request to delete Availability. */
router.delete(
  "/:id",
  jwtAuthorize,
  isUserorAdmin,
  availability_controller.availability_delete
);

module.exports = router;
