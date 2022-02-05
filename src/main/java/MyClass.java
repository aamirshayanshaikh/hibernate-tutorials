import entitymanytoone.Employee;
import entitymanytoone.Organization;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;

public class MyClass {

    public static void main(String[] arg) {
        SessionFactory sessionFactory = HibernateUtil.getInstnce();
        Session session = sessionFactory.openSession();

        Organization organization = new Organization();
        organization.setOrgName("Javakar");

        Employee employee1 = new Employee();
        employee1.setEmployeeName("Aamir");

        Employee employee2 = new Employee();
        employee2.setEmployeeName("Shayan");

        employee1.setOrganization(organization);
        employee2.setOrganization(organization);

        Transaction transaction = session.beginTransaction();

        session.save(employee1);
        session.save(employee2);
        transaction.commit();



        /*################################### Retrieving Data ################################################3*/
        TypedQuery query = session.createQuery("from Employee e");
        List<Employee> list = query.getResultList();
        Iterator<Employee> itr = list.iterator();
        while (itr.hasNext()) {
            Employee employee = itr.next();
            organization = employee.getOrganization();
            System.out.println("id = "+employee.getId() + " emp_name = " + employee.getEmployeeName()+" org_name "+organization.getOrgName());


        }

        session.close();
        sessionFactory.close();
    }
}
