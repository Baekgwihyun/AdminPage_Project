package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController // 어노테이션 선언
@RequestMapping("/api") //localhost:8080/api 주소 맵핑
public class GetController {
    //방식 선언
    @RequestMapping (method = RequestMethod.GET, path = "/getMethod") // //localhost:8080/api/getMethod  주소 맵핑
    public String getRequest() {

        return "GET Method 공부 중입니다."; // 문자열 리턴
    }
    //localhost:8080/api/getParameter?id=qwe123&password=1q2w3e4r 주소 맵핑
    @GetMapping("/getParameter")
    public String getParameter(@RequestParam String id,
                               @RequestParam(name = "password")String pw,//파라미터에 password란 이름을 지정 할 수 있다.
                               @RequestParam String email,
                               @RequestParam String age){
        System.out.println("아이디는"+ id + "패스워드는"+ pw);
        return id + pw;
    }


    //localhost:8080/api/getMultiParameter?id=aaaa&email=aaa@aaa&page=10
    //다중 파리미터 받기
    @GetMapping("/getMultiParameter")
    public SearchParam getMultiParameter(SearchParam searchParam){

        return  searchParam;
        //"아이디는"+searchParam.getId() +
        //"이메일은"+ searchParam.getEmail() +
        //"페이지는"+ searchParam.getPage();
    }

}