package pe.edu.upao.apideliverybackend.services;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.stereotype.Service;
import pe.edu.upao.apideliverybackend.models.Food;
import pe.edu.upao.apideliverybackend.models.Order;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private List<Order> orders = new ArrayList<>();

    public List<Order> getOrders() {
        return orders;
    }

    public List<Food> getFoods(){

        List<Food> menu = new ArrayList<>();
        menu.add(new Food("Arroz Chaufa", "Un sabroso arroz chaufa", 9.99));
        menu.add(new Food("Tallarines Rojos", "Un delicioso plato de tallarines", 10.99));
        menu.add(new Food("Pollo a la plancha", "Un saludable pollo hecho a la plancha", 11.99));
        return menu;
    }
    public String addOrder(Order order){
        orders.add(order);

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode response = mapper.createObjectNode();
        response.put("Mensaje: ", "Datos guardados");
        response.put("Status: ", "201");
        return response.toString();
    }
    public Order getOrderById(long id) {
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }
    public void deleteOrder(Integer orderId) {
        orders.removeIf(order -> order.getId().equals(orderId));
    }
}
