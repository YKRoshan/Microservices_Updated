package com.stackroute.userProfile.contoller;

import com.stackroute.userProfile.domain.UserProfile;
import com.stackroute.userProfile.exception.UserContactNotFoundException;
import com.stackroute.userProfile.exception.UserMailNotFoundException;
import com.stackroute.userProfile.exception.UserProfileAlreadyExistsException;
import com.stackroute.userProfile.exception.UserProfileNotFoundException;
import com.stackroute.userProfile.service.UserProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("userProfile")
@Api(value = "User Profile", description = "This is user profile implemented in REST")
public class UserProfileController {

    /* UserProfileService instance is created with name as userProfileService. */
    private UserProfileService userProfileService;

    /* Set UserProfileService variable using userProfileController constructor. */
    @Autowired
    public UserProfileController(UserProfileService userProfileService){
        this.userProfileService=userProfileService;
    }

    /* HTTP exception message definition while inserting new user profile into the database. */
    @ApiOperation(value = "addNewUser", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    /* Insert new user profile into the database. */
    @PostMapping("userProfile")
    public ResponseEntity<?> addUserProfile(@RequestBody UserProfile userProfile) throws
            UserProfileAlreadyExistsException {
        ResponseEntity responseEntity;
        UserProfile userProfile1=userProfileService.saveTheUser(userProfile);
        responseEntity=new ResponseEntity<String>("Success: New User profile created.", HttpStatus.CREATED);
        return responseEntity;
    }


    /* HTTP exception message definition for all user profile from the database. */
    @ApiOperation(value = "getAllUserProfile", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    /* Get all user profile from the database. */
    @GetMapping("allUserProfile")
    public ResponseEntity<?> getAllUserProfile() throws UserProfileNotFoundException {
        ResponseEntity responseEntity;
        responseEntity= new ResponseEntity<List<UserProfile>>(userProfileService.getAllUser(),HttpStatus.ACCEPTED);
        return responseEntity;
    }

    /* HTTP exception message definition for all user profile from the database. */
    @ApiOperation(value = "getAllUserProfile", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    /* Get all user profile from the database. */
    @GetMapping("getUserByMail")
    public ResponseEntity<?> getUserByMail(String mail) throws UserMailNotFoundException {
        ResponseEntity responseEntity;
        responseEntity= new ResponseEntity<UserProfile>(userProfileService.getUserByMail(mail),
                HttpStatus.ACCEPTED);
        return responseEntity;
    }


    /* HTTP exception message definition for all user profile from the database. */
    @ApiOperation(value = "getAllUserProfile", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    /* Get all user profile from the database. */
    @GetMapping("getUserByContact")
    public ResponseEntity<?> getUserByContact(int contact) throws UserContactNotFoundException {
        ResponseEntity responseEntity;
        responseEntity= new ResponseEntity<UserProfile>(userProfileService.getUserByContact(contact),
                HttpStatus.ACCEPTED);
        return responseEntity;
    }

//    /* HTTP exception message definition for update user contact if already exists. */
//    @ApiOperation(value = "updateTheTrack", response = Iterable.class)
//    @ApiResponses(value = {
//            @ApiResponse(code = 200, message = "Successfully retrieved list"),
//            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
//            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
//            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
//    })
//
//    /*  Update the user contact if already exists. */
//    @PutMapping("updateUser")
//    public ResponseEntity<?> updateUser(@RequestParam("userMail") String userMail,@RequestParam("userContact") int
//            userContact) throws UserProfileNotFoundException {
//        ResponseEntity responseEntity;
//        UserProfile userProfile1=userProfileService.updateUser(userMail,userContact);
//        responseEntity= new ResponseEntity<String>("Success: User contact updated.",HttpStatus.OK);
//        return responseEntity;
//    }

    /* HTTP exception message definition for deleting the user by contact detail. */
    @ApiOperation(value = "deleteTheUserByContact", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

     /* Delete user profile from the database. */
    @DeleteMapping("deleteUserByContact")
    public ResponseEntity<?> deleteUserbyContact(@RequestParam int userContact) throws UserContactNotFoundException {
        List<UserProfile> user1=userProfileService.deleteUserbyContact(userContact);
        ResponseEntity responseEntity= new ResponseEntity<String>("Success: User profile is deleted",
                HttpStatus.ACCEPTED);
        return responseEntity;
    }

    /* HTTP exception message definition for deleting the user by mail Id. */
    @ApiOperation(value = "deleteTheUserByMail", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })

    /* Delete user profile from the database based on user mail id. */
    @DeleteMapping("deleteUserByMail")
    public ResponseEntity<?> deleteUserbyMail(@RequestParam String userMail) throws UserMailNotFoundException {
        List<UserProfile> user1=userProfileService.deleteUserbyMail(userMail);
        ResponseEntity responseEntity= new ResponseEntity<String>("Success: User profile is deleted",
                HttpStatus.ACCEPTED);
        return responseEntity;
    }
}
