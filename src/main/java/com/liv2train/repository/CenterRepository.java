package com.liv2train.repository;

import com.liv2train.entity.Center;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CenterRepository extends PagingAndSortingRepository<Center,Integer> {

    @Query("SELECT c FROM Center c WHERE c.studentCapacity >= ?1")
    List<Center> getCenterByStudentCapacity(int capacity);

    @Query("SELECT c FROM Center c WHERE c.studentCapacity BETWEEN ?1 AND ?2")
    List<Center> getByStudentCapacity(int a, int b);

    @Query("SELECT c FROM Center c,Address a where c.id=a.id and a.city = ?1")
    List<Center> getByCenterCity(String city);


    List<Center> getCentersByCourses(String course);

}
