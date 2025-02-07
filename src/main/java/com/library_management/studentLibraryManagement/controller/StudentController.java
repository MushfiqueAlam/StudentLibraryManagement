package com.library_management.studentLibraryManagement.controller;

import com.library_management.studentLibraryManagement.model.Student;
import com.library_management.studentLibraryManagement.repository.StudentRepository;
import com.library_management.studentLibraryManagement.requestDto.StudentRequestDto;
import com.library_management.studentLibraryManagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody StudentRequestDto studentRequestDto){
        String response=studentService.saveStudent(studentRequestDto);
        return response;
    }

    //get student by id
    @GetMapping("/find/{id}")
    public Student findById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @GetMapping("/findAll")
    private List<Student> findAll(){
        return studentService.getAllStudent();
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
    public Student findByEmail(@RequestParam String email){
        Student student=studentService.findStudentByEmail(email);
        return student;
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
