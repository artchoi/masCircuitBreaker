package mascircuitbreaker.domain;

import java.util.*;
import lombok.*;
import mascircuitbreaker.domain.*;
import mascircuitbreaker.infra.AbstractEvent;

@Data
@ToString
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Long productId;
    private Integer qty;
    private Long customerId;

    public OrderPlaced(Order aggregate) {
        super(aggregate);
    }

    public OrderPlaced() {
        super();
    }
}
