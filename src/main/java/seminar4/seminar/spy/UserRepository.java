package seminar4.seminar.spy;

public class UserRepository {
    public User getUserById(int userId) {
        return new User(userId, "johnDoe");
    }
}
