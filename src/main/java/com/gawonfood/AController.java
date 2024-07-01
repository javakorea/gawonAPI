package com.gawonfood;


import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gawonfood.so.PlazaAcademyApplySO;

@Controller
public class AController {

	@RequestMapping(value = "xhr/mypage/digitalplaza/academy/getMyAcademyList", method = RequestMethod.POST)
	public String getMyAcademyList(PlazaAcademyApplySO so, ModelMap map) throws Exception {
		try {
			System.out.println("타라타라");
			PlazaAcademyApplySO reserveInfo = new PlazaAcademyApplySO();
			
			reserveInfo.setCusGbCd("50");
			map.addAttribute("reserveInfo", reserveInfo);
			
			ArrayList newArr = new ArrayList();
			newArr.add("김길동");
			newArr.add("홍길동");
			newArr.add("홍길동");
			map.addAttribute("newArr", newArr);
			
			ArrayList newMemArr = new ArrayList();
			for(int i=0; i < 3; i++) {
				PlazaAcademyApplySO member = new PlazaAcademyApplySO();
				member.setCusGbCd("코드"+i);
				member.setName("혜진"+i);
				newMemArr.add(member);
			}
			map.addAttribute("memberArr", newMemArr);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "/mypage/plaza/include/myAcademyList"; //servlet-context.xml의 prefix + suffix붙어서 풀url
	}
	
	@ResponseBody
	@RequestMapping(value = "xhr/member/app/loginSuccess", method = RequestMethod.POST)
	public  ModelMap appLogin(HttpServletRequest request,  HttpServletResponse response,
				@RequestParam(value = "token", required = false) String token,
				@RequestParam(value = "userId", required = false) String userId
			){
		ModelMap map = new ModelMap();
	System.out.println("token>>>"+token);
	System.out.println("userId>>>"+userId);
	//postman으로 테스트할경우 body - > x-www-form-urlencoded로 테스트해야함
		return map;
	}

	@RequestMapping(value = "main", method = {RequestMethod.GET,RequestMethod.POST})
	public String main(PlazaAcademyApplySO so, ModelMap map) throws Exception {
		try {
			System.out.println("main GET");
			PlazaAcademyApplySO reserveInfo = new PlazaAcademyApplySO();
			
			reserveInfo.setCusGbCd("50");
			map.addAttribute("reserveInfo", reserveInfo);
			
			ArrayList newArr = new ArrayList();
			newArr.add("김길동");
			newArr.add("홍길동");
			newArr.add("홍길동");
			map.addAttribute("newArr", newArr);
			
			ArrayList newMemArr = new ArrayList();
			for(int i=0; i < 3; i++) {
				PlazaAcademyApplySO member = new PlazaAcademyApplySO();
				member.setCusGbCd("코드"+i);
				member.setName("혜진"+i);
				newMemArr.add(member);
			}
			map.addAttribute("memberArr", newMemArr);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "/mypage/plaza/include/myAcademyList"; //servlet-context.xml의 prefix + suffix붙어서 풀url
	}
}
