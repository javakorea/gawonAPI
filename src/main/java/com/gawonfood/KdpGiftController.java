package com.gawonfood;


import java.util.ArrayList;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gawonfood.so.Gift521Request;
import com.gawonfood.so.GiftCommonResponse;
import com.gawonfood.so.PlazaAcademyApplySO;

@RestController
@RequestMapping("api")
public class KdpGiftController {

	@RequestMapping(value = "/gift/521", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> kdpGift521(
			@RequestHeader Map<String,String> headers,
			@RequestBody Gift521Request gift521Request) throws Exception {
		GiftCommonResponse response = new GiftCommonResponse();
		try {
			System.out.println("@RequestHeader->"+headers);
			System.out.println("@RequestBody->"+gift521Request);
			response.setMessage("테스트성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(response,HttpStatus.OK);
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
