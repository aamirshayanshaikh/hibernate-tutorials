import annotation_relation.Customer;
import annotation_relation.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.*;

public class MyClass2 {

    public static void main(String[] arg) {

        try {
            SessionFactory sessionFactory = HibernateUtil.getInstnce();
            Session session = sessionFactory.openSession();

            Orders order = new Orders();
            order.setPrice("200");
            order.setOrderDetail("1 Pasta");

            Customer customer = new Customer();
            customer.setCustomerName("Aamir");

            Transaction transaction = session.beginTransaction();
            session.save(customer); // Saving customer and orders
            session.save(order);


           // ##################### Retrieving Data ################################

            TypedQuery query = session.createQuery("from Customer c");  // Retrieving customer and orders from database
            List<Customer> list = query.getResultList();
            Iterator<Customer> itr = list.iterator();
            while (itr.hasNext()) {
                customer = itr.next();
                System.out.println(customer.getCustomerId() + " , " + customer.getCustomerName() );
                /*for (Map.Entry entry:  customer.getOrders().entrySet()) {
                    System.out.print(entry.getKey() + " , " );
                    if(entry.getValue() != null && entry.getValue() instanceof Orders){
                        Orders orders = (Orders) entry.getValue();
                        System.out.print(orders.getOrderDetail() );
                    }
                }*/
            }
            transaction.commit();
            session.close();
            sessionFactory.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
