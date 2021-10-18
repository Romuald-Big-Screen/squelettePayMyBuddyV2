package com.PayMyBudy.repository;

import com.PayMyBudy.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
@Query("SELECT a FROM Account a WHERE a.id= :id")
    Account findAccountByUserId(Integer id );
}