package seminar3.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    // Тут можно хранить аутентифицированных пользователей
    List<User> data = new ArrayList<>();
    public void addUser(User user) {
       this.data.add(user);
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

    /** Добавьте функцию в класс UserRepository,
     * которая разлогинивает всех пользователей, кроме администраторов.
     * Для этого, вам потребуется расширить класс User новым свойством,
     * указывающим, обладает ли пользователь админскими правами.
     * Протестируйте данную функцию. */

    public boolean isAdmin(User user){
        return user.isAdmin();
    }


}