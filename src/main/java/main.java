import plan.Professions;
import plan.Users;
import Service.UserService;

import java.sql.SQLException;

public class main {
    public static void main(String[] args) throws SQLException {

        UserService userService = new UserService();
        Users user = new Users("Roza",21);
        userService.saveUser(user);
        Professions ferrari = new Professions("Sword", "Dragon");
        ferrari.setUser(user);
        user.addProfessions(ferrari);
        Professions ford = new Professions("Shield ", "Roza");
        ford.setUser(user);
        user.addProfessions(ford);
        userService.updateUser(user);
    }
}