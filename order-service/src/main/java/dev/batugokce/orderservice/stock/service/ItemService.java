package dev.batugokce.orderservice.stock.service;

import dev.batugokce.orderservice.stock.entity.Item;
import dev.batugokce.orderservice.stock.exception.InsufficientStockException;
import dev.batugokce.orderservice.stock.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    @Transactional
    public List<Item> checkItemStock(Map<Long, Integer> itemAmountMap) {
        List<Item> items = itemRepository.findAllById(itemAmountMap.keySet());

        if (items.size() != itemAmountMap.size()) {
            throw new InsufficientStockException("Some items does not exist in stock.");
        }

        items.forEach(item -> {
            int amountNeeded = itemAmountMap.get(item.getId());
            if (item.getStock() < amountNeeded) {
                throw new InsufficientStockException(String.format("Item with ID:%s is insufficient.", item.getId()));
            }
        });
        return items;
    }

    @Transactional
    public void updateStock(List<Item> items, Map<Long, Integer> itemAmountMap) {
        itemAmountMap.keySet().forEach(itemId -> {
            int amountNeeded = itemAmountMap.get(itemId);
            items.stream()
                    .filter(item -> item.getId().equals(itemId))
                    .findFirst()
                    .ifPresent(foundItem -> foundItem.setStock(foundItem.getStock()- amountNeeded));
        });

        itemRepository.saveAll(items);
    }

}
