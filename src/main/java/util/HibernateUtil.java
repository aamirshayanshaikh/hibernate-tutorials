package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {
    private HibernateUtil() {

    }

    private static SessionFactory sessionFactory;

    public static synchronized SessionFactory getInstnce() {

        if (sessionFactory == null) {
            StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
            Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();

            sessionFactory = meta.getSessionFactoryBuilder().build();
        }
        return sessionFactory;

    }
}
