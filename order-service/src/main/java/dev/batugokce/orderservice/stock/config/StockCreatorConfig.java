package dev.batugokce.orderservice.stock.config;

import dev.batugokce.orderservice.stock.entity.Item;
import dev.batugokce.orderservice.stock.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@ConditionalOnProperty(value = "create-mock-stock", havingValue = "true")
@Configuration
@RequiredArgsConstructor
public class StockCreatorConfig {

    private final ItemRepository itemRepository;

    @PostConstruct
    public void createStockInfo() {
        var builder = Item.builder();
        var itemList = List.of(
                builder.price(BigDecimal.valueOf(5L)).stock(100).build(),
                builder.price(BigDecimal.valueOf(5L)).stock(100).build(),
                builder.price(BigDecimal.valueOf(10L)).stock(100).build(),
                builder.price(BigDecimal.valueOf(10L)).stock(100).build(),
                builder.price(BigDecimal.valueOf(10L)).stock(100).build()
        );
        itemRepository.saveAll(itemList);
    }
}
