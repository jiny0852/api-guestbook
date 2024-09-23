package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.PersonVo;


@Service
public class GuestbookService {

	//필드
	@Autowired
	private GuestbookDao guestbookDao;
	
	
	
	//메서드 일반
	
	public int exePersonDelete (int no, String password) {
		
		System.out.println("GuestbookService.exePersonDelete()");
		
		int count = guestbookDao.deletePerson(no, password);
		
		return count;
	}
	
	

	public PersonVo exeGetPersonOne (int no) {
		
		System.out.println("GuestbookService.exeGetPersonOne()");
		
		PersonVo personVo = guestbookDao.getPersonOne(no);
		
		return personVo;
	}

	
	
	public int exeInsertPerson (PersonVo personVo) {
		
		System.out.println("GuestbookService.exeInsertPerson()");
		
		System.out.println(personVo);
		
		int count = guestbookDao.insertPerson(personVo);
		
		return count;
		
	}
	
	
	public List<PersonVo> exeGetPersonList() {
		
		System.out.println("GuestbookService.exeGetPersonList()");
		
		List<PersonVo> personList = guestbookDao.getPersonList();
		
		return personList;
	}
	
	
	
	
	
}
