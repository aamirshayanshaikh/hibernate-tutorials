import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.persistence.TypedQuery;
import java.util.Iterator;
import java.util.List;

public class MyClass {

    public static void main(String[] arg) {
        try {


            SessionFactory sessionFactory = HibernateUtil.getInstnce();
            Session session = sessionFactory.openSession();

            Citizen citizen = new Citizen();
            citizen.setName("Aamir Shayan");
            citizen.setEmail("aamir@gmail.com");
            citizen.setAddress("A-34,DHA Phase 1, Karachi");

            Passport passport = new Passport();
            passport.setPassportNo(201301);

            citizen.setPassport(passport); // Setting citizen to passport
            passport.setCitizen(citizen); // Setting passport to citizen

            Transaction transaction = session.beginTransaction();
            session.save(citizen); // saving citizen will also save passport
            transaction.commit();



            /*##################### Retrieving Data ################################*/

            TypedQuery query = session.createQuery("from Passport e");
            List<Passport> list = query.getResultList();

            Iterator<Passport> itr = list.iterator();
            while (itr.hasNext()) {
                passport = itr.next();

                citizen = passport.getCitizen(); // Retrieving citizen from database
                System.out.println(citizen.getCitizenId() + " " + citizen.getName() + " " + citizen.getEmail());

                System.out.println(passport.getPassportId() + " " + passport.getPassportNo());
            }


            session.close();
            sessionFactory.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
