package com.liv2train.service;

import com.liv2train.entity.Center;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CenterService {

    Center saveCenter(Center center);

    List<Center> getAllCenter(int pageNo,int pageSize);

    List<Center> getByStudentCapacity(int capacity);

    List<Center> getByStudentCapacityBetween(int a, int b);

    List<Center> getByCenterCity(String city);

    List<Center> getCenterByCourse(String course);
}
