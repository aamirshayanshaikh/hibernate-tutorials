import entity.PostEntity;
import entity.UserEntity;
import org.hibernate.Transaction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class MyClass {

    public static void main(String[] arg) {

        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            UserEntity user = createUser("Shaikh");
            entityManager.persist(user);
            user = entityManager.find(UserEntity.class, 3L);
            PostEntity post = createPosts(user, "details 1", "desc 1");
            entityManager.persist(post);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            managerFactory.close();
        }
    }

    private static UserEntity createUser(String name) {
        UserEntity user = new UserEntity();
        user.setName(name);
        return user;
    }

    private static PostEntity createPosts(UserEntity user, String details, String desc) {
        PostEntity postEntity = new PostEntity();
        postEntity.setDetails(details);
        postEntity.setShortDes(desc);
        postEntity.setUserId(user);
        return postEntity;

    }
}
