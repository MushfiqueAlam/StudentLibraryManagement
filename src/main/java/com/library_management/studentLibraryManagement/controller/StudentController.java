package com.library_management.studentLibraryManagement.controller;

import com.library_management.studentLibraryManagement.model.Student;
import com.library_management.studentLibraryManagement.repository.StudentRepository;
import com.library_management.studentLibraryManagement.requestDto.StudentRequestDto;
import com.library_management.studentLibraryManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<?> saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        try {

        String response=studentService.saveStudent(studentRequestDto);
        return ResponseEntity.ok(response);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Some exception occured"+e.getMessage());
        }
    }

    //get student by id
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        try {
            Student student=studentService.getStudentById(id);
        return ResponseEntity.ok(student);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("Some error occured "+e.getMessage());
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){
        try {
            List<Student> studentList=studentService.getAllStudent();
            return ResponseEntity.ok(studentList);
        }catch (Exception e){
            return ResponseEntity.internalServerError().body("some error occured"+e.getMessage());
        }
    }

    @GetMapping("/findByPage")
    public List<Student> findByPage(@RequestParam int pageNo,@RequestParam int pageSize){
        List<Student>studentList=studentService.findAllStudentByPagination(pageNo,pageSize);
        return studentList;
    }

    @PutMapping("/update/{id}")
    public String updateById(@PathVariable int id,@RequestBody StudentRequestDto studentRequestDto){
        String response=studentService.updateStudentById(id,studentRequestDto);
        return response;
    }

    @PatchMapping("/update/{id}")
    public String updateSemester(@PathVariable int id, @RequestParam String semester){
        String response=studentService.updateStudentSemester(id,semester);
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudentById(@PathVariable int id){
        String response=studentService.deleteStudent(id);
        return response;
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<?> findByEmail(@RequestParam String email){


        try {
            Student student=studentService.findStudentByEmail(email);
            return ResponseEntity.ok(student);
        }catch (Exception e){
          return  ResponseEntity.internalServerError().body("some error occured "+e.getMessage());
        }

    }

    @GetMapping("/findByDepartment")
    public List<Student> findByDepartment(@RequestParam String department){
        List<Student> studentList=studentService.findByDepartment(department);
        return studentList;
    }

    @GetMapping("/findBySemAndDepart")
    public List<Student> findBySemAndDepart(@RequestParam String semester,@RequestParam String department){
        List<Student> studentList=studentService.findBySemAndDeprt(semester,department);
        return studentList;
    }

    @GetMapping("/findBySemOrDepart")
    public List<Student> findBySemOrDeoart(@RequestParam String semester, @RequestParam String department){
        List<Student>studentList=studentService.findBySemOrEmail(semester,department);
        return studentList;
    }

    @GetMapping("/findByEmailQuery")
    public Student findByEmailQuery(@RequestParam String email){
        Student student=studentService.findByQuery(email);
        return student;
    }
}
