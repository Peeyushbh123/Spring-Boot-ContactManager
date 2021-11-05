package com.smart.dao;

import com.smart.entities.Contact;
import com.smart.entities.User;

import java.util.List;

public interface IContactDao  {
    public List<Contact> findAllContacts(int id);
    public void deleteById(int id);
    Contact addContact(Contact u);
}
