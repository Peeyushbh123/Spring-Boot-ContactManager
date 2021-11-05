package com.smart.services;

import com.smart.dao.IContactDao;
import com.smart.dao.IUserDao;
import com.smart.dto.request.ContactRequestDto;
import com.smart.dto.response.ContactResponseDto;
import com.smart.dto.response.UserResponseDto;
import com.smart.entities.Contact;
import com.smart.entities.User;
import com.smart.enums.MessageEnum;
import com.smart.exceptions.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactServiceImpl implements IContactService{

    @Autowired
    private IContactDao iContactDao;

    @Autowired
    private IUserDao iUserDao;

    @Override
    public List<ContactResponseDto> getAllContacts(int id) throws DataNotFoundException {
        List<Contact> list= iContactDao.findAllContacts(id);
        if(CollectionUtils.isEmpty(list)){
            throw new DataNotFoundException(MessageEnum.DATA_NOT_FOUND.toString());
        }
        List<ContactResponseDto> response=new ArrayList<>();
        for(Contact contact:list){
            ContactResponseDto contactResponseDto=new ContactResponseDto();
            contactResponseDto.convertToConResponse(contact);
            response.add(contactResponseDto);
        }

        return response;
    }

    @Override
    public ContactResponseDto addContact(ContactRequestDto contactRequestDto, int id) {
        try {
            Contact contact = new Contact();
            contact.setSecondname(contactRequestDto.getSecondname());
            contact.setWork(contact.getWork());
            contact.setPhone(contactRequestDto.getPhone());
            contact.setImage(contactRequestDto.getImage());
            contact.setDescription(contactRequestDto.getDescription());
            contact.setEmail(contactRequestDto.getEmail());
            contact.setUsr(iUserDao.findUserById(id).get());
            contact.setName(contactRequestDto.getName());

            ContactResponseDto contactResponseDto = new ContactResponseDto();
            contactResponseDto.convertToConResponse(iContactDao.addContact(contact));

            return contactResponseDto;
        } catch (Exception ex){
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public ContactResponseDto updateContact(ContactRequestDto contactRequestDto, int cid) {
        return null;
    }

    @Override
    public void deleteContact(int cid) {
        iContactDao.deleteById(cid);
    }
}
