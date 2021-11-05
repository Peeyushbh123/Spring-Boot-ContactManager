package com.smart.services;

import com.smart.dto.request.ContactRequestDto;
import com.smart.dto.response.ContactResponseDto;
import com.smart.exceptions.DataNotFoundException;

import java.util.List;

public interface IContactService {

    public List<ContactResponseDto> getAllContacts(int id) throws DataNotFoundException;

    public ContactResponseDto addContact(ContactRequestDto contactRequestDto,int id);

    public ContactResponseDto updateContact(ContactRequestDto contactRequestDto,int cid);

    public void deleteContact(int cid);
}
