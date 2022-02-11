package annotation_relation;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Orders  implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private String orderDetail;
    private String price;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    // Getters and Setters


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer id) {
        this.orderId = id;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
