package com.smart.dao;

import com.smart.entities.Contact;
import com.smart.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactDaoImpl implements IContactDao {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> findAllContacts(int id) {
        return contactRepository.findContactsByUserId(id);
    }

    @Override
    public void deleteById(int id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact addContact(Contact u) {
        contactRepository.save(u);
        return u;
    }
}
