package com.store.meonggae.user.contoller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.store.meonggae.user.login.domain.LoginDomain;
import com.store.meonggae.user.login.service.LoginService;
import com.store.meonggae.user.login.vo.LoginVO;

@Controller
@RequestMapping("/index.do")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping("/authenticate.do")
	public String authenticate(@RequestParam("uid") String id, @RequestParam("upw") String pass, HttpSession session) {
		LoginVO loginVO = new LoginVO(id, pass);
		LoginDomain user = loginService.selectOneUser(loginVO);
		if (user != null) {
			session.setAttribute("user", user);
			System.out.println(user);
			return "redirect:/index.do";
		} else {
			return "login_page/login_page";
		}
	}

	@PostMapping("/index.do")
	public String mainPageLogin(/* HttpServletRequest request, Model model */) {
		/*
		 * LoginDomain user = (LoginDomain) model.getAttribute("user");
		 * model.addAttribute("user", user);
		 */ return "main_page/main_contents";
	}

	/*
	 * @PostMapping("/event_page/event_main.do") public String eventPageLogin(
	 * HttpServletRequest request,Model model ) {
	 * 
	 * LoginDomain user = (LoginDomain) model.getAttribute("user");
	 * model.addAttribute("user", user);
	 * 
	 * return "event_page/event_main"; }
	 */

	@PostMapping("/logout")
	public String logout(HttpSession session,SessionStatus ss) {
		session.invalidate();
		ss.setComplete();
		return "index";
	}
}
/*
 * @Value("${kakao.client-id}") private String clientId;
 * 
 * @Value("${kakao.client-secret}") private String clientSecret;
 * 
 * @Value("${kakao.redirect-uri}") private String redirectUri;
 * 
 * @GetMapping(value = "/kakaologin", produces = "application/json") public
 * String kakaoLogin(@RequestParam String code, RedirectAttributes
 * redirectAttributes) { String tokenUrl =
 * "https://kauth.kakao.com/oauth/token";
 * 
 * RestTemplate restTemplate = new RestTemplate();
 * 
 * Map<String, String> params = new HashMap<>(); params.put("grant_type",
 * "authorization_code"); params.put("client_id", clientId);
 * params.put("redirect_uri", redirectUri); params.put("code", code);
 * params.put("client_secret", clientSecret);
 * 
 * HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
 * 
 * HttpEntity<Map<String, String>> entity = new HttpEntity<>(params, headers);
 * 
 * ResponseEntity<String> response = restTemplate.exchange(tokenUrl,
 * HttpMethod.POST, entity, String.class);
 * 
 * String responseBody = response.getBody();
 * 
 * if (responseBody != null) { JSONParser parser = new JSONParser(); try {
 * JSONObject json = (JSONObject) parser.parse(responseBody); String accessToken
 * = (String) json.get("access_token");
 * 
 * // 액세스 토큰을 사용하여 사용자 정보를 가져오는 로직 Map<String, Object> userInfo =
 * getUserInfo(accessToken);
 * 
 * redirectAttributes.addFlashAttribute("userInfo", userInfo); return
 * "redirect:/user/home"; // 리다이렉트할 경로 설정 } catch (ParseException e) {
 * e.printStackTrace(); return "redirect:/login?error"; } } else { // 오류 처리 로직
 * 추가 return "redirect:/login?error"; } }
 * 
 * // 액세스 토큰을 사용하여 사용자 정보를 가져오는 메서드 추가 private Map<String, Object>
 * getUserInfo(String accessToken) { String userInfoUrl =
 * "https://kapi.kakao.com/v2/user/me";
 * 
 * RestTemplate restTemplate = new RestTemplate();
 * 
 * // HTTP 요청 헤더 설정 HttpHeaders headers = new HttpHeaders();
 * headers.add("Authorization", "Bearer " + accessToken);
 * 
 * HttpEntity<String> entity = new HttpEntity<>(headers);
 * 
 * ResponseEntity<String> response = restTemplate.exchange(userInfoUrl,
 * HttpMethod.GET, entity, String.class);
 * 
 * String responseBody = response.getBody();
 * 
 * if (responseBody != null) { JSONParser parser = new JSONParser(); try {
 * JSONObject json = (JSONObject) parser.parse(responseBody); Map<String,
 * Object> userInfo = new HashMap<>(); userInfo.put("id", json.get("id"));
 * userInfo.put("nickname", ((JSONObject)
 * json.get("properties")).get("nickname")); userInfo.put("email", ((JSONObject)
 * json.get("kakao_account")).get("email")); return userInfo; } catch
 * (ParseException e) { e.printStackTrace(); } }
 * 
 * return null; }
 */
