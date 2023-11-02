package fall2023project;

import java.util.HashSet;
import java.util.Set;

public class RegistrationService {
    private Set<String> registeredUsernames = new HashSet<>();

    public boolean register(User user) {
        if (registeredUsernames.contains(user.getUsername())) {
            return false;
        } else {
            registeredUsernames.add(user.getUsername());
            return true;
        }
    }

    public boolean checkUsernameExists(String username) {
        return registeredUsernames.contains(username);
    }
}
