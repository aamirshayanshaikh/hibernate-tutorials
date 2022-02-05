import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class MyClass {

    public static void main(String[] arg) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getInstnce();
            Session session = sessionFactory.openSession();

            Citizen citizen = new Citizen();
            citizen.setName("Aamir");

            Passport passport = new Passport();
            passport.setPassportno("12346856");
            passport.setCitizen(citizen);
            Transaction transaction = session.beginTransaction();
            session.save(citizen);
            session.save(passport);
            transaction.commit();

            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
