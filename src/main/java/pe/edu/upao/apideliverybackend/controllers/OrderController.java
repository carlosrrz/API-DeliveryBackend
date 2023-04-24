package pe.edu.upao.apideliverybackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.apideliverybackend.models.Food;
import pe.edu.upao.apideliverybackend.models.Order;
import pe.edu.upao.apideliverybackend.services.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")


public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/foods")
    public List<Food> getFoods() {
        return orderService.getFoods();
    }

    @GetMapping("/getOrders")
    public List<Order> gerOrders(){
        return orderService.getOrders();
    }
    @PostMapping("/addOrder")
    public String createOrder(@RequestBody Order order){
        return orderService.addOrder(order);

    }
    @GetMapping("getOrderId/{id}")
    public Order getOrderById(@PathVariable Integer id){

        return orderService.getOrderById(id);
    }
    @DeleteMapping("deleteOrder/{orderId}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer orderId){
        orderService.deleteOrder(orderId);
        return ResponseEntity.ok("Pedido eliminado");
    }

}
