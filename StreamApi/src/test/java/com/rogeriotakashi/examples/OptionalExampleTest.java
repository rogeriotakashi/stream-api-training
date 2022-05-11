package com.rogeriotakashi.examples;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class OptionalExampleTest {

    @Test
    public void getOrderTypeWithoutUsingIfConditionals() {
        Optional<Order> orderOptional = getOrder(true); // do not change

        String result = null; // answer here

        assertThat(result).isEqualTo("Pix");
    }

    @Test
    public void getDefaultOrderTypeWithoutUsingIfConditionals() {
        Optional<Order> orderOptional = getOrder(false); // do not change

        String result = null; // answer here

        assertThat(result).isEqualTo("Default");
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

        Optional<String> letterNOptional = null; // Solution here

        
        assertThat(letterNOptional.get()).isEqualTo("N");
    }

    private Optional<Order> getOrder(boolean shouldGetOrder){
        if(shouldGetOrder) {
            return Optional.of(new Order(new OrderType("Pix")));
        }
        return Optional.empty();
    }
}



class Order{
    OrderType orderType;

    public Order(final OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderType getOrderType() {
        return orderType;
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
