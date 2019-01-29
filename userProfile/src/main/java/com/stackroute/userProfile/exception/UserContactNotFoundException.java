package com.stackroute.userProfile.exception;

public class UserContactNotFoundException extends Throwable {
    String message;//This is message that is showed

    public UserContactNotFoundException() {
    }


    public UserContactNotFoundException(String message) {
        super(message);//Setting message to string value thrown by Service layer while throwing exception
    }
}


