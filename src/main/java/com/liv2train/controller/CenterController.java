package com.liv2train.controller;

import com.liv2train.entity.Center;
import com.liv2train.service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CenterController {

    @Autowired
    CenterService centerService;

    @PostMapping("/center/save")
    public Center saveCenter(@RequestBody @Valid Center center){
        return centerService.saveCenter(center);
    }

    @GetMapping("/center/page={pageNo}&size={pageSize}")
    public List<Center> getAllCenters(@PathVariable int pageNo,@PathVariable int pageSize){
        return centerService.getAllCenter(pageNo,pageSize);
    }

    @GetMapping("/center/capacity={studentCapacity}")
    public List<Center> findByStudentCapacity(@PathVariable int studentCapacity){
        return centerService.getByStudentCapacity(studentCapacity);
    }

    @GetMapping("/center/capacity/{a}/{b}")
    public List<Center> findByStudentCapacityBetween(@PathVariable int a,@PathVariable int  b){
        return centerService.getByStudentCapacityBetween(a,b);
    }

    @GetMapping("/center/city={city}")
    public List<Center> findByCenterCity(@PathVariable String city){
        return centerService.getByCenterCity(city);
    }

    @GetMapping("/center/course={course}")
    public List<Center> findCenterByCourse(@PathVariable String course){
        return centerService.getCenterByCourse(course);
    }


//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(ConstraintViolationException.class)
//    public Map<String,String> handleConstraintViolation(ConstraintViolationException ex){
//        ConstraintViolationException exception = (ConstraintViolationException) ex;
//        List<FieldError> errors = new ArrayList<>();
//
//    }


}
