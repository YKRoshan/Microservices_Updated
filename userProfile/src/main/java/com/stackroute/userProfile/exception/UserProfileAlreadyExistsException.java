package com.stackroute.userProfile.exception;

/**This class extends Exception and is a
 * custom exception handler that handeles exception if the
 * track already exists
 */
public class UserProfileAlreadyExistsException extends Exception {

    String message;//This is message that is showed

    public UserProfileAlreadyExistsException(){
    }

    public UserProfileAlreadyExistsException(String message){
        super(message);//Setting message to string value thrown by Service layer while throwing exception
    }
}
