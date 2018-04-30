package sb.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sb.org.dao.StudentDAO;
import sb.org.model.Student;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public void deleteStudent(Integer studentId) {
        studentDAO.deleteStudent(studentId);
    }

    public Student updateStudent(Student student) {
        return studentDAO.updateStudent(student);
    }

    public Student getStudent(int studentId) {
        return studentDAO.getStudent(studentId);
    }
}
