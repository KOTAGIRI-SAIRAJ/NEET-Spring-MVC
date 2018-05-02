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
import sb.org.service.FranchiseService;
import sb.org.service.StudentService;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RestController
public class FranchiseController {

    @Autowired
    FranchiseService franchiseService;

    @Autowired
    StudentService studentService;

    private static final Logger logger = Logger.getLogger(FranchiseController.class);

    public FranchiseController() {
        System.out.println("FranchiseController()");
    }

    // Get all the Franchise List
    @RequestMapping(value = "allFranchises",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Franchise>> getAllFranchises() {
        List<Franchise> franchiseList = franchiseService.getAllFranchises();
        System.out.println("franchiseService length " +franchiseService.getAllFranchises().size());
        return ResponseEntity.ok().body(franchiseList);
    }

    // Add Or Update a Franchise
    @RequestMapping(value = "/franchise/add",method = RequestMethod.POST)
    public ResponseEntity<Franchise>  addFranchise(@RequestBody Franchise franchise) {
        HttpHeaders headers = new HttpHeaders();
        if (franchise.getId() == 0) {
            franchiseService.addFranchise(franchise);
            return new ResponseEntity<Franchise>(headers, HttpStatus.CREATED);
        } else {
            franchiseService.updateFranchise(franchise);
            return new ResponseEntity<Franchise>(headers, HttpStatus.CREATED);
        }
    }

    // Get a single Franchise
    @RequestMapping(value = "/franchise/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Franchise> getFranchise(@PathVariable("id") int id) {
        Franchise franchise=franchiseService.getFranchise(id);
        if (franchise == null) {
            return new ResponseEntity<Franchise>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Franchise>(franchise, HttpStatus.OK);
    }

    // Delete a Franchise
    @RequestMapping(value = "franchise/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Franchise> deleteFranchise(@PathVariable("id") int franchiseId) {
        Franchise franchise = franchiseService.getFranchise(franchiseId);
        if (franchise == null) {
            return new ResponseEntity<Franchise>(HttpStatus.NOT_FOUND);
        }
        franchiseService.deleteFranchise(franchiseId);
        return new ResponseEntity<Franchise>(HttpStatus.OK);
    }

    // Enroll Student to Franchise
    @RequestMapping(value = "/franchise/{id}/{studentId}",method = RequestMethod.PUT)
    public ResponseEntity<Franchise> approveStudent(@PathVariable("id") int id,@PathVariable("studentId") int studentId) {
        HttpHeaders headers = new HttpHeaders();
        Franchise franchise=franchiseService.getFranchise(id);
        if (franchise == null) {
            return new ResponseEntity<Franchise>(HttpStatus.NOT_FOUND);
        }
        Student student = studentService.getStudent(studentId);
        if (student == null) {
            return new ResponseEntity<Franchise>(HttpStatus.NOT_FOUND);
        }
        if(student.getFranchise() != null){
            return new ResponseEntity<Franchise>(HttpStatus.CONFLICT);
        }
        List<Student> assignedStudents = franchiseService.getFranchise(id).getStudents();
        assignedStudents.add(student);
        franchise.setStudents(assignedStudents);
        student.setFranchise(franchise);
        franchiseService.updateFranchise(franchise);
        return new ResponseEntity<Franchise>(headers, HttpStatus.CREATED);
    }

}
