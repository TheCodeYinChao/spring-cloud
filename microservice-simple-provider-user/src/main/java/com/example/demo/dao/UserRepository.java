package com.example.demo.dao;

import com.example.demo.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Admin on 2018/4/29.
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
}
