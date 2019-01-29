package com.stackroute.userProfile.service;

import java.util.List;
import com.stackroute.userProfile.domain.UserProfile;
import com.stackroute.userProfile.exception.UserContactNotFoundException;
import com.stackroute.userProfile.exception.UserMailNotFoundException;
import com.stackroute.userProfile.exception.UserProfileAlreadyExistsException;
import com.stackroute.userProfile.exception.UserProfileNotFoundException;

public interface UserProfileService {

    public UserProfile saveTheUser(UserProfile userProfile) throws UserProfileAlreadyExistsException;
    public List<UserProfile> getAllUser() throws UserProfileNotFoundException;
    public UserProfile getUserByMail(String userMail) throws UserMailNotFoundException;
    public UserProfile getUserByContact(int userContact) throws UserContactNotFoundException;
    public UserProfile updateUser(String mail, int userContact) throws UserProfileNotFoundException;
    public List<UserProfile> deleteUserbyContact(int userContact) throws UserContactNotFoundException;
    public List<UserProfile> deleteUserbyMail(String userMail) throws UserMailNotFoundException;
}
