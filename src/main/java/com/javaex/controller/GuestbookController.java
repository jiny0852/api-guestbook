package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaex.service.GuestbookService;
import com.javaex.util.JsonResult;
import com.javaex.vo.PersonVo;


@RestController
public class GuestbookController {
	

	@Autowired
	private GuestbookService guestbookService;
	

	
	/* 삭제 */
	@DeleteMapping ( value="/api/persons" )
	public String delete ( @RequestParam(value="no") int no , 
						   @RequestParam(value="password") String password  ) {
		
		System.out.println("guestbookController.deleteform()");
		
		int count = guestbookService.exePersonDelete(no, password);
		System.out.println(count);

		
		return "redirect:/list";
	} 
	
	
	/* 삭제폼 */
	@RequestMapping ( value="deleteform", method={RequestMethod.GET, RequestMethod.POST}  )
	public String deleteForm( @RequestParam(value="no") int no , Model model ) {
		
		System.out.println("guestbookController.deleteForm()");
		
		//System.out.println(no);
		
		PersonVo personVo = guestbookService.exeGetPersonOne(no);
		/*
		//메소드를 이용해서 저장한다
		PersonVo personVo = guestbookDao.getPersonOne(no);
		System.out.println("deleteform : " + personVo);
				*/
		model.addAttribute("personVo", personVo);
		
		return "deleteForm";
		
	}
	
	
	/* 등록 */
	@PostMapping ( value="/api/persons" )
	public JsonResult addPerson(@RequestBody PersonVo personVo) {
		
		System.out.println("guestbookController.insert()");
		
		System.out.println(personVo);
		
		int count = guestbookService.exeInsertPerson(personVo);

		if ( count != 1 ) { 
			return JsonResult.fail("등록 안되었습니다");
			
		} else { 
			return JsonResult.success(count);
		}
		
	}
	
	
	/* 리스트-등록폼 */
	@GetMapping ( value="/api/persons"  )
	public List<PersonVo> list () {
		
		System.out.println("guestbookController.list()");
	
		List<PersonVo> personList = guestbookService.exeGetPersonList();
		
		System.out.println("&&&&"+personList);
		
		return personList;
		
	}
	
	


	


}

