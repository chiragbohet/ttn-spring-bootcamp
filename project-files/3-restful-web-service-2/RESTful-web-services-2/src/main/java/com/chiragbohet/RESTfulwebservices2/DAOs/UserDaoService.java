package com.chiragbohet.RESTfulwebservices2.DAOs;

import com.chiragbohet.RESTfulwebservices2.Entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    //Trying to mock DB behavior with a list
    static List<User> users = new ArrayList<>();

    //Adding some User's to the Users list to simulate Users stored in a DB
    static {
        users.add(new User(1, "Chirag", 24,"123456"));
        users.add(new User(2, "Ajay", 24,"123abc"));
        users.add(new User(3, "Manish", 35,"qwerty"));
        users.add(new User(4, "Elon", 40,"123456"));
    }

    /***
     * Returns list of all Users, currently in the system.
     * @return List of Users
     */
    public List<User> retrieveAllUsers() {
        return users;
    }

    /***
     * Finds and returns a single User Object with given id
     * @param id id of the User
     * @return
     *      User Object, if found with given id
     *      null otherwise
     */
    public User retrieveUserById(int id) {
        for (User User : users)
            if (User.getId() == id)
                return User;
        return null;
    }

    /***
     * Adds a new User Object to the Users list
     * If id field is not set auto set's the id to current Users count + 1
     * @param User  User Object to be added to the list
     * @return Original User Object given as input
     */
    public User addUser(User User) {
        if (User.getId() == null)
            User.setId(users.size() + 1);

        users.add(User);
        return User;
    }

    /***
     * Deletes User with given Id from the Users list.
     * @param id Id of the User to be deleted.
     * @return
     *      User Object of the User which is removed from the list, if found and deleted
     *      null otherwise
     */
    public User deleteUserById(int id) {
        if (id > 0) {
            Iterator<User> iterator = users.iterator();

            while (iterator.hasNext()) {
                User UserToDelete = iterator.next();
                if (UserToDelete.getId() == id) {
                    iterator.remove();
                    return UserToDelete;
                }
            }
        }

        return null;
    }


}


