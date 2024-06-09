package com.gawonfood;


import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gawonfood.so.PlazaAcademyApplySO;

@Component
public class AController {

	@RequestMapping(value = "/sec/xhr/mypage/digitalplaza/academy/getMyAcademyList", method = RequestMethod.POST)
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
}
