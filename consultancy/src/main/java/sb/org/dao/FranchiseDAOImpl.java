package sb.org.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sb.org.model.Franchise;
import sb.org.model.Student;

import java.util.Iterator;
import java.util.List;

@Repository
public class FranchiseDAOImpl implements FranchiseDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addFranchise(Franchise franchise) {
        //franchise = setFranchiseToStudents(franchise);
        sessionFactory.getCurrentSession().saveOrUpdate(franchise);
    }

    @Override
    public List<Franchise> getAllFranchises() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Franchise.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    @Override
    public void deleteFranchise(Integer franchiseId) {
        Franchise franchise= (Franchise) sessionFactory.getCurrentSession().load(
                Franchise.class, franchiseId);
        this.sessionFactory.getCurrentSession().delete(franchise);
    }

    @Override
    public Franchise updateFranchise(Franchise franchise) {
        //franchise = setFranchiseToStudents(franchise);
        sessionFactory.getCurrentSession().update(franchise);
        return franchise;
    }

    @Override
    public Franchise getFranchise(int franchiseId) {
        return (Franchise) sessionFactory.getCurrentSession().get(
                Franchise.class, franchiseId);
    }

    /*public Franchise setFranchiseToStudents(Franchise franchise) {
        List<Student> students = franchise.getStudents();
        Iterator<Student> studentIterator= students.iterator();
        while (studentIterator.hasNext()){
            Student student= studentIterator.next();
            student.setFranchise(franchise);
        }
        return franchise;
    }*/
}
