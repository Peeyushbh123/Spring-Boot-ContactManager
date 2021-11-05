package com.smart.controller;

import com.smart.dto.request.ContactRequestDto;
import com.smart.dto.response.APIResponseDto;
import com.smart.dto.response.ContactResponseDto;
import com.smart.entities.Contact;
import com.smart.enums.MessageEnum;
import com.smart.exceptions.DataNotFoundException;
import com.smart.services.IContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private IContactService icontactService;

    @GetMapping("/all/{userId}")
    public ResponseEntity<?> getAllContacts(@PathVariable("userId") int id) throws DataNotFoundException {
        APIResponseDto<List<ContactResponseDto>> response=new APIResponseDto<>();
        List<ContactResponseDto> list=icontactService.getAllContacts(id);
        response.setData(list);
        response.setMessage(MessageEnum.FOUND_ALL_CONTACTS.toString());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<?> addContact(
            @Valid @RequestBody ContactRequestDto contactRequestDto, @PathVariable("userId") int id
    ){
        APIResponseDto<ContactResponseDto> response=new APIResponseDto<>();
        ContactResponseDto contactResponseDto=icontactService.addContact(contactRequestDto,id);
        response.setData(contactResponseDto);
        response.setMessage(MessageEnum.SUCCESS_ADD_CONTACT.toString());
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PutMapping("/update/{cId}")
    public ResponseEntity<?> updateContact(
            @Valid @RequestBody ContactRequestDto contactRequestDto,
            @PathVariable("cId") int cid
    ){
        APIResponseDto<ContactResponseDto> response=new APIResponseDto<>();
        ContactResponseDto responseDto=icontactService.updateContact(contactRequestDto,cid);
        response.setData(responseDto);
        response.setMessage(MessageEnum.SUCCESS_UPDATED.toString());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cId}")
    public ResponseEntity<?> deleteContact(
            @PathVariable("cId") int cid
    ){
        APIResponseDto<String> response=new APIResponseDto<>();
        icontactService.deleteContact(cid);
        response.setMessage(MessageEnum.SUCCESS_DELETE.toString());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
