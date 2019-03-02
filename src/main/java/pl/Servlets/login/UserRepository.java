package pl.Servlets.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    private List<User> users;

    public UserRepository(){
        users = new ArrayList<>();

        users.add(new User("user", "user123"));
        users.add(new User("admin", "admin1"));
        users.add(new User("test", "test1"));
    }

    public Optional<User> getUserByLoginData(String login, String password){
        //z listy robimy strumień, nasstępnie odfiltrowujemy i porównujemy do naszego loginu i hasła, a potem wyciągamy użytkownika

        return  users.stream()
                .filter(user -> user.getLogin().equals(login)
                        && user.getPassword().equals(password))
                .findFirst();
    }
}
