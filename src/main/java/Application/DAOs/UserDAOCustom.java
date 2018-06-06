package Application.DAOs;

import Application.Model.User;

import java.util.List;

public interface UserDAOCustom {
    //Es necesario hacer una custom interface si se quiere agregar comportamiento extra al DAO
    boolean checkLogin(User user);
    List getFirstNamesLike(String firstName);

    Iterable<User> getUsersByDeportesLike(String sport);

    Iterable<User> getUsersByLastName(String lastName);
}
