package springboot.transaction.service;

import org.apache.rocketmq.client.exception.MQClientException;
import springboot.transaction.model.OrderDTO;

public interface OrderService {

     void createOrder(OrderDTO orderDTO, String transactionId);

     void createOrder(OrderDTO order) throws MQClientException;
}
