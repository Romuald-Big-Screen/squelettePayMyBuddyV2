package com.PayMyBudy.repository;

import com.PayMyBudy.model.Connection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConnectionRepository  extends CrudRepository<Connection, Integer> {
    @Query("SELECT c FROM Connection c WHERE c.user1.email= :email")
    List<Connection> findConnectionsByUser1Email(String email);
}
