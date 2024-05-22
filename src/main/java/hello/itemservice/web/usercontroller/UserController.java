package hello.itemservice.web.usercontroller;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.user.User;
import hello.itemservice.domain.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
@ResponseBody
@CrossOrigin(origins = "*")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public List<User> users() {
        return userRepository.findAll();
    }

    @GetMapping("/{userName}")
    public User user(@PathVariable String userName) {
        return userRepository.findByName(userName);
    }

    @PostMapping
    public List<User> addUser(@RequestParam String userName,
                                @RequestParam int age) {

        User user = new User(userName, age);
        userRepository.save(user);

        return userRepository.findAll();
    }

    @PostConstruct
    public void init() {
        userRepository.save(new User("userA", 30));
        userRepository.save(new User("userB", 20));
    }
}
