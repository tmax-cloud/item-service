package hello.itemservice.web.itemcontroller;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor
@ResponseBody
@CrossOrigin(origins = "*")
public class ItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public List<Item> items() {
        return itemRepository.findAll();
    }

    @GetMapping("/{itemId}")
    public Item item(@PathVariable long itemId) {
        return itemRepository.findById(itemId);
    }

    @PostMapping
    public List<Item> addItem(@RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam Integer quantity) {

        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);

        return itemRepository.findAll();
    }

    @PatchMapping("/{itemId}")
    public Item edit(@PathVariable Long itemId,
                       @RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam Integer quantity) {
        Item item = itemRepository.findById(itemId);
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.update(itemId, item);
        return item;
    }

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }

}

