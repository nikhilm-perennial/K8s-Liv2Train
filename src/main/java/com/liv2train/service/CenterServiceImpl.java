package com.liv2train.service;

import com.liv2train.entity.Center;
import com.liv2train.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class CenterServiceImpl implements CenterService{

    @Autowired
    private CenterRepository centerRepository;
    @Autowired
    private Validator validator;

    @Override
    public Center saveCenter(Center center) {
        Set<ConstraintViolation<Center>> violations = validator.validate(center);
        if (!violations.isEmpty()){
            StringBuilder stringBuilder = new StringBuilder();
            for (ConstraintViolation<Center> constraintViolation:violations){
                stringBuilder.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException(stringBuilder.toString(),violations);
        }
        return centerRepository.save(center);
    }

    @Override
    public List<Center> getAllCenter(int pageNo,int pageSize) {
        Pageable paging = PageRequest.of(pageNo,pageSize);
        Page<Center> pageResult = centerRepository.findAll(paging);
        return pageResult.toList();
    }

    @Override
    public List<Center> getByStudentCapacity(int capacity){
        return centerRepository.getCenterByStudentCapacity(capacity);
    }

    @Override
    public List<Center> getByStudentCapacityBetween(int a, int b) {
        return centerRepository.getByStudentCapacity(a,b);
    }

    @Override
    public List<Center> getByCenterCity(String city) {
        return centerRepository.getByCenterCity(city);
    }

    @Override
    public List<Center> getCenterByCourse(String course) {
        return centerRepository.getCentersByCourses(course);
    }
}
