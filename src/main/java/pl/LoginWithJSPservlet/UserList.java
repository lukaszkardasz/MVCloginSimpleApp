package pl.LoginWithJSPservlet;


import pl.Servlets.login.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserList {
    //tworzymy singleton
    private List<User> users;
    private static UserList instance = null;

    public UserList getInstance() {
        if (instance == null){
            instance = new UserList();
        }
        return instance;
    }

    private UserList(){
        users = new ArrayList<>();

        users.add(new User("user", "user123"));
        users.add(new User("admin", "admin1"));
        users.add(new User("test", "test1"));
    }
    public Optional<User> getUserByLoginData(String login, String password){
        //z listy robimy strumień, następnie odfiltrowujemy i porównujemy do naszego loginu i hasła, a potem wyciągamy użytkownika

        return  users.stream()
                .filter(user -> user.getLogin().equals(login)
                        && user.getPassword().equals(password))
                .findFirst();
    }

}
