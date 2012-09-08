package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.validation.*;

@Entity
public class User extends Model {
    @Required public String 
        name;
    @Email public String 
        email;
    @Required public String 
        password;
        
    public static final User UserNotFound = new Object[0];

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    public static User authenticate(String email, String password) {
        User user = find("byEmailAndPassword", email, password).first();
        if (null == user) {
            return UserNotFound;
        } else {
            return user;
        }
    }
    
    public String toString() {
        return email;
    }
}
