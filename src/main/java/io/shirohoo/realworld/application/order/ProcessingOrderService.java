package io.shirohoo.realworld.application.order;
import io.shirohoo.realworld.domain.order.OrderRepository;
import io.shirohoo.realworld.domain.order.Orders;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.ArrayList;

@Component
public class ProcessingOrderService {
    OrderRepository orderRepository;
    public ProcessingOrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    void processOrder(Orders order) throws InterruptedException{
        System.out.println("Sent email with orderId: " + order.getId());

        order.setProcessed(true);
        orderRepository.save(order);

        if (order.getSnailMailAddress().length() > 1){
            System.out.println("Sending order " + order.getId() + " to " + order.getSnailMailAddress());
        } else if (order.getSnailMailAddress() == null) {
            System.out.println("Sending order " + order.getId() + " to " + order.getSnailMailAddress());
        }
    }

    @Scheduled (cron = " * * /10 * * * *")
    public void processOrders() throws InterruptedException {

        ArrayList<Orders> orders = (ArrayList<Orders>) orderRepository.getUnprocessedOrders();

        for (Orders order : orders) {
            processOrder(order);
            sendArticleBySnailMail(order);
        }
    }

    private void sendArticleBySnailMail(Orders order) {
        System.out.println("Sending article " + order.getId() + " to " + order.getSnailMailAddress());
    }
}
