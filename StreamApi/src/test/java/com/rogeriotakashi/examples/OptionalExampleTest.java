package com.rogeriotakashi.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class OptionalExampleTest {

    @Test
    public void getPriceWithoutUsingIfConditionals() {
        Optional<Order> orderOptional = getOrder(true); // do not change

        Double price = null;

        assertThat(price).isEqualTo(10.0);
    }

    @Test
    public void getDefaultPrice5WhenOptionalEmptyWithoutUsingIfConditionals() {
        Optional<Order> orderOptional = getOrder(false); // do not change

        Double price = null; // answer here

        assertThat(price).isEqualTo(5.0);
    }

    @Test
    public void getIfOrderTypeIsPixWithoutUsingIfConditionals() {
        Optional<Order> orderOptional = getOrder(true); // do not change
        boolean result = false; // answer here

        // Tip: use the methods .filter() and .isPresent()

        assertThat(result).isTrue();
    }

    // Challenge!
    @Test
    public void findAnyLetterNOptional() {
        List<String> listWithN = Arrays.asList("M", "M", "M", "M", "M", "M", "N", "M", "M", "M", "M", "M", "M", "M");

        // Find any letter 'N' in the list
        // use .stream() and the methods .filter with .findAny() to find (or not) the 'N'

        Predicate<String> predicate = null;// Solution here
        Optional<String> letterNOptional = listWithN.stream()
                                                    .filter(predicate)
                                                    .findAny();


        assertThat(letterNOptional.get()).isEqualTo("N");
    }

    private Optional<Order> getOrder(boolean shouldGetOrder){
        if(shouldGetOrder) {
            return Optional.of(new Order(new OrderType("Pix"), 10.0));
        }
        return Optional.empty();
    }
}



class Order{
    OrderType orderType;
    Double price;

    public Order(final OrderType orderType, final Double price) {
        this.orderType = orderType;
        this.price = price;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public Double getPrice() {
        return price;
    }
}

class OrderType {
    private String type;

    public OrderType(final String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
