package com.stackroute.userProfile.exception;

public class UserMailNotFoundException extends Exception{

    String message;//This is message that is showed

    public UserMailNotFoundException(){
    }

    public UserMailNotFoundException(String message){
        super(message);//Setting message to string value thrown by Service layer while throwing exception
    }
}
