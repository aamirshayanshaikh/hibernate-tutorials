import entitymanytomany.Category;
import entitymanytomany.Stock;
import entitymanytoone.Employee;
import entitymanytoone.Organization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MyClass {

    public static void main(String[] arg) {
        SessionFactory sessionFactory = HibernateUtil.getInstnce();
        Session session = sessionFactory.openSession();

        Stock stock = new Stock();
        stock.setStockName("ABC Perfume");

        Category category1 = new Category();
        category1.setName("Fragrance");
        Category category2 = new Category();
        category2.setName("Fashion");

        Set<Category> categories = new HashSet<>();
        categories.add(category1);
        categories.add(category2);

        stock.setCategories(categories);


        Transaction transaction = session.beginTransaction();

        session.save(stock);
        transaction.commit();



        /*################################### Retrieving Data ################################################3*/
        /*TypedQuery query = session.createQuery("from Employee e");
        List<Employee> list = query.getResultList();
        Iterator<Employee> itr = list.iterator();
        while (itr.hasNext()) {
            Employee employee = itr.next();
            organization = employee.getOrganization();
            System.out.println("id = "+employee.getId() + " emp_name = " + employee.getEmployeeName()+" org_name "+organization.getOrgName());


        }*/

        session.close();
        sessionFactory.close();
    }
}
