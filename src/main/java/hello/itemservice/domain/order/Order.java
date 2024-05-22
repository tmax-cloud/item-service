package hello.itemservice.domain.order;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.user.User;
import lombok.Data;

import java.util.List;

@Data
public class Order {
    private Long id;
    private User user;
    private Item item;

    public Order() {}

}
