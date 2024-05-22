package hello.itemservice.domain.user;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String userName;
    private Integer age;

    public User(String userName, Integer age) {
        this.userName = userName;
        this.age = age;
    }
}
