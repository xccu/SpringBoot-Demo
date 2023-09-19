package com.example.springdata.demo.repository;

import com.example.springdata.demo.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;

/**
 * @author : S K Y
 * @version :0.0.1
 */
//操作数据表
//继承JpaRepository来实现对数据库的操作
//其泛型表示<当前操作的实体类,主键的类型>
@Service
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.race =  ?1")
    List<User> findByRaceQuery(String race);

    @Query("select u from User u where u.name like %?1%")
    List<User> findByNameQuery(String name);

    List<User> findByRaceOrderByAgeAsc(String race);
    List<User> findByRaceOrderByAgeDesc(String race);

    @Lock(LockModeType.READ)
    Page<User> findBySex(String gender, Pageable pageable);

    @Transactional(readOnly = true)
    @Query("select u from User u")
    Stream<User> findAllAsStream();

    @Transactional(readOnly = true)
    Stream<User> findAllByRace(String race);

    @Async
    Future<User> findByName(String name);

    @Query("select u from User u where u.name like %?1%")
    List<User> findByAndSort(String name, Sort sort);

    @Query("select u from User u where u.age > :age")
    List<User> findByAgeLarger(@Param("age") int age);

    @Transactional
    @Modifying
    @Query("update User u set u.age = ?1 where u.name = ?2")
    int setFixedAgeFor(int age, String name);

    @Transactional
    void deleteByName(String name);

    @Transactional
    @Modifying
    @Query("delete from User u where u.id = ?1")
    void deleteByIdQuery(int id);

}