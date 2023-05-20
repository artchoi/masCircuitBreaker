package mascircuitbreaker.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import mascircuitbreaker.OrderApplication;
import mascircuitbreaker.domain.OrderPlaced;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long productId;

    private Integer qty;

    private Long customerId;

    private Integer amount;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();
        // Get request from Order
        //mascircuitbreaker.external.Order order =
        //    Application.applicationContext.getBean(mascircuitbreaker.external.OrderService.class)
        //    .getOrder(/** mapping value needed */);

    }

    public static OrderRepository repository() {
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }
}
