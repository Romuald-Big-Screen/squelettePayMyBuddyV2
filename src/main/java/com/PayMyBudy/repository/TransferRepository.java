package com.PayMyBudy.repository;

import com.PayMyBudy.model.Transfer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, Long> {
    public Optional<Transfer> findTransferByDate(String transfer);

    @Query("SELECT c FROM Transfer c WHERE c.from.id= :id")
    List<Transfer> findTransferByUserId(Integer id );

}
