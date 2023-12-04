package seminar4.seminar.spy;

public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(int userId) {
// Логика получения пользователя из репозитория
        return userRepository.getUserById(userId);
    }
}