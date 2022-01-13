import entity.UserEntity;
import org.hibernate.Transaction;

import javax.persistence.*;

public class MyClass {

    public static void main(String[] arg){

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();
            final TypedQuery<UserEntity> namedQuery = entityManager.createNamedQuery("User.byName", UserEntity.class);
            namedQuery.setParameter(1, "Aamir");
            for (UserEntity user: namedQuery.getResultList()){
                System.out.println(user.getName());
            }
            transaction.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(transaction.isActive()){
                transaction.rollback();
            }
            entityManager.close();
            managerFactory.close();
        }
    }
}
