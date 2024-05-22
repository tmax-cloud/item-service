package hello.itemservice.web.ordercontroller;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import hello.itemservice.domain.order.Order;
import hello.itemservice.domain.order.OrderRepository;
import hello.itemservice.domain.user.User;
import hello.itemservice.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
@ResponseBody
@CrossOrigin(origins = "*")
public class OrderController {
    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @GetMapping
    public List<Order> orders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{orderId}")
    public Order order(@PathVariable long orderId) {
        return orderRepository.findById(orderId);
    }

    @PostMapping
    public List<Order> addOrder(@RequestParam String userName,
                              @RequestParam Long itemId) {

        User user = userRepository.findByName(userName);
        Item item = itemRepository.findById(itemId);

        Order order = new Order();
        order.setUser(user);
        order.setItem(item);

        orderRepository.save(order);

        return orderRepository.findAll();
    }


}
