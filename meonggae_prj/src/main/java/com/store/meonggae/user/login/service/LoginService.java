package com.store.meonggae.user.login.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.meonggae.user.login.dao.LoginDAO;
import com.store.meonggae.user.login.domain.LoginDomain;
import com.store.meonggae.user.login.vo.LoginVO;

@Service
public class LoginService {
    @Autowired
    private LoginDAO lDAO;

    public LoginDomain selectOneUser(LoginVO lVO) {
        return lDAO.login(lVO);
    }

    public String getKaKaoAccessToken(String code) throws Exception {
        System.out.println("getKaKaoAccessToken method called");  // 메서드 호출 확인

        // 1. 토큰 받아오는 url 설정
        String url = "https://kauth.kakao.com/oauth/token";

        // 2. 필수 파라미터 map으로 값 넣기
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "authorization_code");
        params.put("client_id", "0738d40e4912047a5dbb57d8ca06a869");
        params.put("redirect_uri", "http://localhost/meonggae_prj/login_page/login_page.do");
        params.put("code", code);

        // 3. REST-API 호출
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(url, params, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response);
        
        System.out.println("Kakao Access Token Response: " + jsonNode.toString());  // 응답 확인
        
        return jsonNode.get("access_token").asText();
    }

    public LoginDomain getKaKaoUserInfo(String accessToken) throws Exception {
        System.out.println("getKaKaoUserInfo method called");  // 메서드 호출 확인

        // 1. 카카오 로그인 시 유저 정보를 가져오기 위한 url
        String url = "https://kapi.kakao.com/v2/user/me";
        
        // 2. REST-API 호출
        RestTemplate restTemplate = new RestTemplate();

        // 3. headers 값 설정
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        // 4. response 값 설정
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(response.getBody());
        
        System.out.println("Kakao User Info Response: " + jsonNode.toString());  // 응답 확인

        String id = jsonNode.get("id").asText();
        String nickname = jsonNode.get("properties").get("nickname").asText();

        // 5. LoginDomain에 추가
        LoginDomain user = new LoginDomain();
        user.setId(id);
        user.setNick(nickname);

        return user;
    }
}
