package com.stackroute.userProfile.service;

import com.stackroute.userProfile.domain.UserProfile;
import com.stackroute.userProfile.exception.UserContactNotFoundException;
import com.stackroute.userProfile.exception.UserMailNotFoundException;
import com.stackroute.userProfile.exception.UserProfileAlreadyExistsException;
import com.stackroute.userProfile.exception.UserProfileNotFoundException;
import com.stackroute.userProfile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Track;
import java.util.List;
import java.util.Optional;

    @Service
    public class UserProfileServiceImpl implements UserProfileService {

        //Making variable of Userrepository type
        private UserRepository userRepository;

        //This is setting the userRepository variable by constructor injection
        @Autowired
        public UserProfileServiceImpl(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        //This method saves the Track

        @Override
        public UserProfile saveTheUser(UserProfile userProfile) throws UserProfileAlreadyExistsException {
                if (userRepository.existsById(userProfile.getUserId())) {
                    throw new UserProfileAlreadyExistsException("user already exists");
                }
                userRepository.save(userProfile);
                return userProfile;
            }



        @Override
        public UserProfile getUserByMail(String mail) throws UserMailNotFoundException {
            if(!userRepository.equals(getUserByMail(mail))){

                throw new UserMailNotFoundException("user mail not found exception");
            }
            return userRepository.findByUserMail(mail);
        }

        @Override
        public UserProfile getUserByContact(int contact) throws UserContactNotFoundException {

            if(!userRepository.equals(getUserByContact(contact))){
                throw new  UserContactNotFoundException("user contact not found");
            }

            return userRepository.findByUserContact(contact);
        }

        @Override
        public List<UserProfile> getAllUser() throws UserProfileNotFoundException {
                List<UserProfile> userlist = userRepository.findAll();
                if (userlist.isEmpty() || userlist == null) {
                    throw new UserProfileNotFoundException("Error while returning the tracks");
                }
                return userlist;
            }



        @Override
        public UserProfile updateUser(String Mail, int contact) throws UserProfileNotFoundException {
            if(userRepository.findByUserMail(Mail)==null){
                throw new UserProfileNotFoundException("user mail is not found");
            }
            UserProfile user= new UserProfile();
            user.setUserContact(123456789);
            return user;


        }

        @Override
        public List<UserProfile> deleteUserbyContact(int userContact) throws UserContactNotFoundException {
            if(!userRepository.equals(getUserByContact(userContact))){
                throw new UserContactNotFoundException("user contact is not present");
            }
            userRepository.deleteByUserContact(userContact);
            return userRepository.findAll();
        }

        @Override
        public List<UserProfile> deleteUserbyMail(String userMail) throws UserMailNotFoundException {
            if(!userRepository.equals(getUserByMail(userMail))){
               throw new UserMailNotFoundException("user mail is not present");

            }
             userRepository.delete(getUserByMail(userMail));
            return userRepository.findAll();


    }
    }

