package com.stackroute.userProfile.repository;


import com.stackroute.userProfile.domain.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<UserProfile,Integer> {

//
//    //This is making a new method other than ones existing in JPA repo
//    //The below query runs internally when the method given below is called
//    @Query(value = "SELECT t FROM Track t where t.trackname=?1")
//    public List<Track> fingBYTrackNAME(String name);
    public UserProfile findByUserContact(int contact);
    public UserProfile findByUserMail(String mail);
    public List<UserProfile> deleteByUserContact(int contact);

}

