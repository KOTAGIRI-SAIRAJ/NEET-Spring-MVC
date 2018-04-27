package sb.org.service;

import sb.org.model.Student;

import java.util.List;

public interface StudentService {

    public void addStudent(Student student);

    public List<Student> getAllStudents();

    public void deleteStudent(Integer studentId);

    public Student updateStudent(Student student);

    public Student getStudent(int studentId);
}
