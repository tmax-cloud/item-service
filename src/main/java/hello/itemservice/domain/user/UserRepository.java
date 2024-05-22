package hello.itemservice.domain.user;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private static final Map<String, User> store = new HashMap<>(); //static
    private static long sequence = 0L; //static

    public User save(User user) {
        user.setId(++sequence);
        store.put(user.getUserName(), user);
        return user;
    }

    public User findByName(String userName) {
        return store.get(userName);
    }

    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }
}
