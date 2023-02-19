package com.texhnolyze.orderservicemicroservice.service;

import com.texhnolyze.orderservicemicroservice.dto.OrderListItemsDto;
import com.texhnolyze.orderservicemicroservice.dto.OrderRequest;
import com.texhnolyze.orderservicemicroservice.model.Order;
import com.texhnolyze.orderservicemicroservice.model.OrderListItems;
import com.texhnolyze.orderservicemicroservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List <OrderListItems> orderListItems = orderRequest.getOrderListItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderListItemsList(orderListItems);

        orderRepository.save(order);
    }

    private OrderListItems mapToDto(OrderListItemsDto orderListItemsDto) {
        OrderListItems orderListItems = new OrderListItems();
        orderListItems.setPrice(orderListItemsDto.getPrice());
        orderListItems.setQuantity(orderListItemsDto.getQuantity());
        orderListItems.setSkuCode(orderListItemsDto.getSkuCode());
        return orderListItems;
    }
}
