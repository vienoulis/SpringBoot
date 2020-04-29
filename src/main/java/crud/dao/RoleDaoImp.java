package crud.dao;

import crud.model.Role;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getRoleByName(String role) {
        return (Role) sessionFactory.getCurrentSession().createQuery("from Role where role = :rl")
                .setParameter("rl", role).uniqueResult();
    }

    @Override
    public List<Role> getAllRoles() {
        return sessionFactory.getCurrentSession().createQuery("from Role ").getResultList();
    }


}
