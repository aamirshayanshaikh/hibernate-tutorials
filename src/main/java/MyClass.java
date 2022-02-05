import entityonetomany.Customer;
import entityonetomany.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyClass {

    public static void main(String[] arg) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getInstnce();
            Session session = sessionFactory.openSession();

            Customer customer = new Customer();
            customer.setCustomerName("Aamir");

            List<Orders> orders = new ArrayList<Orders>();

            Orders order1 = new Orders();
            order1.setOrderDetail("One Pasta");
            orders.add(order1);

            Orders order2 = new Orders();
            order2.setOrderDetail("One Rice");
            orders.add(order2);

            customer.setOrders(orders);

            Transaction transaction = session.beginTransaction();
            session.save(customer); // Saving customer and orders

            /*##################### Retrieving Data ################################*/

            TypedQuery query = session.createQuery("from Customer c");  // Retrieving customer and orders from database
            List<Customer> list = query.getResultList();
            Iterator<Customer> itr = list.iterator();
            while (itr.hasNext()) {
                customer = itr.next();
                System.out.println(customer.getCustomerId() + " " + customer.getCustomerName() );
                for (Orders ord:  customer.getOrders()) {
                    System.out.println(ord.getOrderId() + " " + ord.getOrderDetail());
                }
            }

            transaction.commit();
            session.close();
            sessionFactory.close();



        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
