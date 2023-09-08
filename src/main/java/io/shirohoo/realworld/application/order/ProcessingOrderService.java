package io.shirohoo.realworld.application.order;
import io.shirohoo.realworld.domain.order.OrderRepository;
import io.shirohoo.realworld.domain.order.Order;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class ProcessingOrderService {
    OrderRepository orderRepository;
    public ProcessingOrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    void processOrder(Order order) throws InterruptedException{
        System.out.println("Sent email with orderId: " + order.getId());

        order.setProcessed(true);
        orderRepository.save(order);

        if (order.getSnailMailAddress().length() > 1){
            System.out.println("Sending order " + order.getId() + " to " + order.getSnailMailAddress());
        } else if (order.getSnailMailAddress() == null) {
            System.out.println("Sending order " + order.getId() + " to " + order.getSnailMailAddress());
        }
    }

    @Scheduled (cron = " */3 * * * * *")
    public void processOrders() throws InterruptedException {
        System.out.println("Processing all unprocessed orders");


        ArrayList<Order> orders = (ArrayList<Order>) orderRepository.getUnprocessedOrders();

        for (Order order : orders) {
            processOrder(order);
            sendArticleBySnailMail(order);
        }
    }

    private void sendArticleBySnailMail(Order order) {
        System.out.println("Sending article " + order.getId() + " to " + order.getSnailMailAddress());
    }
}
