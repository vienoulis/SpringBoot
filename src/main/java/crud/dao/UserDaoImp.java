package crud.dao;

import crud.model.User;
        import org.hibernate.SessionFactory;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().createQuery("from User").getResultList();
    }

    @Override
    public void update(User user){
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void addUser(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void delete(long userId) {
        sessionFactory.getCurrentSession().createQuery("delete from User where id = :id")
                .setParameter("id", userId).executeUpdate();
    }

    @Override
    public User getUserById(Long id) {
        User user = (User) sessionFactory.getCurrentSession().createQuery("from User where id = :id")
                .setParameter("id", id).uniqueResult();

        return user;
    }

    @Override
    public User getUserByName(String name) {
        return (User) sessionFactory.getCurrentSession().createQuery("from User where name = :nm")
                .setParameter("nm", name).uniqueResult();
    }

}
