package com.stackroute.userProfile.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "UserProfile")// This annotation is used to set this as document for swagger.
@Data//It will implicitly add getters and setters.
@NoArgsConstructor//It will implicitly add no args constructor.
@AllArgsConstructor//It will implicitly add all args constructor.
/*
 * This is class declaration for user profile defining all required parameter for
 * user profile setup.
 */
public class UserProfile {

    @Id//userId is et as the primary key for this class.
    private int userId;

    /* userAge is used to store the user Age. */
    private int userAge;

    /* userContact is used to store the user contact details. */
    private int userContact;

    /* userName is used to store the user name. */
    private String userName;

    /* userMail is used to store the user email address. */
    private String userMail;

    @Override
    public String toString() {
        return "UserProfile{" +
                "userId=" + userId +
                ", userAge=" + userAge +
                ", userContact=" + userContact +
                ", userName='" + userName + '\'' +
                ", useremail='" + userMail + '\'' +
                '}';
    }
}
