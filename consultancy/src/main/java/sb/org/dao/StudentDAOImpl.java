package sb.org.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sb.org.model.Student;

import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void addStudent(Student student) {
        sessionFactory.getCurrentSession().saveOrUpdate(student);
    }

    public List<Student> getAllStudents() {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return criteria.list();
    }

    public void deleteStudent(Integer studentId) {
        Student student= (Student) sessionFactory.getCurrentSession().load(
                Student.class, studentId);
        if(student != null){
            sessionFactory.getCurrentSession().delete(student);
        }
    }

    public Student updateStudent(Student student) {
        sessionFactory.getCurrentSession().update(student);
        return student;
    }

    public Student getStudent(int studentId) {
        return (Student) sessionFactory.getCurrentSession().get(
                Student.class, studentId);
    }
}
