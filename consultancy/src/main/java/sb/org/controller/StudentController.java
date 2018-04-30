package sb.org.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sb.org.model.Franchise;
import sb.org.model.Student;
import sb.org.service.StudentService;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    private static final Logger logger = Logger
            .getLogger(FranchiseController.class);

    public StudentController() {
        System.out.println("StudentController()");
    }

    // Get all Student List
    @RequestMapping(value = "allStudents",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students=studentService.getAllStudents();
        return ResponseEntity.ok().body(students);
    }

    // Get a Student based on ID
    @RequestMapping(value = "student/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Student> getStudent(@PathVariable("id") int id){
        Student student = studentService.getStudent(id);
        if (student == null) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Student>(student, HttpStatus.OK);
    }

    //Save and Update the Student
    @RequestMapping(value="/student/add",method = RequestMethod.POST)
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        HttpHeaders headers = new HttpHeaders();
        if (student.getId() == 0) {
            studentService.addStudent(student);
            return new ResponseEntity<Student>(headers, HttpStatus.CREATED);
        } else {
            studentService.updateStudent(student);
            return new ResponseEntity<Student>(headers, HttpStatus.CREATED);
        }
    }

    //Delete Student Record
    @RequestMapping(value = "student/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Student> deleteStudent(@PathVariable("id") int id) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
        }
        studentService.deleteStudent(id);
        return new ResponseEntity<Student>(HttpStatus.OK);
    }

}
