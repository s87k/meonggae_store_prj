package com.store.meonggae.my.contorller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@RequestMapping("/My/mypage")
@Controller
public class PersonalIfoController {
	
	/**
	 * 마이페이지 : 개인정보_비밀번호검증
	 * 개인정보 변경페이지로 연결해놓고, 세션 확인 한 다음, 안되어있으면 비밀번호 검증페이지로 연결해야함!!!
	 * @return
	 */
	@GetMapping("/personal/passwordChk_frm.do")
	public String personal() {
		return "/My/mypage/personal/passwordChk_frm";
	}
	
	/**
	 * 마이페이지 : 개인정보_수정
	 * @return
	 */
	@GetMapping("/personal/personalInfo_frm.do")
	public String personalInfo() {
		return "/My/mypage/personal/personalInfo_frm";
	}
	
	
	/**
	 * 마이페이지 : 개인정보_회원탈퇴
	 * @return
	 */
	@GetMapping("/personal/quitMembership_frm.do")
	public String quitMembership() {
		return "/My/mypage/personal/quitMembership_frm";
	}
	
	/**
	 * 개인정보 수정 파일 업로드
	 */
	@PostMapping("/personal/upload_profile_process.do")
	// 1. httpservletRequest 받기
	public String profileUploadProcess(HttpServletRequest request, String temp, Model model) throws IOException {
		
		File saveDir = new File("D:/meonggae_store_prj/meonggae_prj/src/main/webapp/profile-img");
		int tempSize =100*1024*1024;
		
		MultipartRequest mr = new MultipartRequest(request, saveDir.getAbsolutePath(),
				tempSize,"UTF-8", new DefaultFileRenamePolicy());
		
		// 닉네임 (web parameter)
		String nickname = mr.getParameter("nickname");
		String oriName = mr.getOriginalFileName("upfile");
		String fsName = mr.getFilesystemName("upfile");
		
		File tempFile = new File(saveDir.getAbsolutePath() + "/" + fsName);
		int maxSize = 10*1024*1024;
		boolean uploadflag = false;
		
		if(tempFile.length() > maxSize) { //업로드 제한
			tempFile.delete();
			uploadflag = true;
		}//end if
		
		model.addAttribute("nickname", nickname);
		model.addAttribute("fileName", oriName);
		model.addAttribute("uploadflag", !uploadflag);
		
		return "/My/mypage/personal/temp_result";
	}//profileUploadProcess
	
	/**
	 * 마이페이지 : 개인정보_회원탈퇴
	 * @return
	 */
	@GetMapping("/personal/passwordModify.do")
	public String passwordModify() {
		return "/My/mypage/personal/passwordModify";
	}
	
}//class
