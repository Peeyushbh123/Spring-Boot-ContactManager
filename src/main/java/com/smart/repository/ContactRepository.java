package com.smart.repository;

import com.smart.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {

    @Query(value = "select * from contact where user_id= :id")
    public List<Contact> findContactsByUserId(int id);
}
