<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="개인정보 수정"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 로그인 세션 설정 시작 -->
<%

%>
<!-- 로그인 세션 설정 끝 -->

<!-- header -->
<c:import url="http://localhost/meonggae_prj/My/common/css/css.jsp"/>
<c:import url="http://localhost/meonggae_prj/header/header.jsp"/>
<!-- header -->

<!-- CSS -->
<link rel="stylesheet" href="http://localhost/meonggae_prj/common/css/style.css">
<link rel="stylesheet" href="http://localhost/meonggae_prj/My/common/css/style_mypage.css">
<!-- CSS -->

<script type="text/javascript">
	$(function(){
		$("#applyBtn").click(function(){
			if(confirm("수정된 정보를 적용하시겠습니까?")){
				alert("적용되었습니다.");
			}//end if
		});
		
		$("#quitBtn").click(function(){
			location.href="http://192.168.10.220/meonggae_prj/My/mypage/personal/QuitMembership_frm.jsp";
		});
		
	});//ready
</script>

<!-- 내용 시작 -->
<div class="container">
	<div id="mypageMenu" class="mypageMenu">
		<!-- 메뉴목록 -->
		<%
		String pageName = "personal";
		pageContext.setAttribute("pageName", pageName);
		%>
		<%@ include file="../menuBar/mypageMenu.jsp" %>
		<hr id="menuBottonLine">
		<!-- 메뉴목록 -->
	</div>
	
	<table class="pTable" id="pTable">
		<tr>
			<td id="tableTitle1" class="tableTitle1">프로필 사진</td>
			<td>
			<img src="http://localhost/meonggae_prj/common/image/profile_temp.png" class="img-circle" style="width: 100px; height: 100px"/><br/><br/>
			<input type="button" value="프로필 변경" id="profileBtn" class="btn btn-info btn-sm"/>
			</td>
		</tr>
		<tr>
			<td id="tableTitle2" class="tableTitle2">닉네임</td>
			<td>
			<input type="text" id="nickName" class="nickName" value="찌비" maxlength="10"/>
			</td>
		</tr>
	</table>
	<br>
	<div id="btnWrap">
	<input type="button" value="적용" id="applyBtn" class="btn btn-danger btn-lg"/>
	<input type="button" value="취소" id="cancleBtn" class="btn btn-secondary btn-lg"/>
	</div>
	<input type="button" value="회원 탈퇴" id="quitBtn" class="btn btn-light btn-sm"/>
	
	
</div>
<!-- 내용 끝 -->

<!-- footer -->
<c:import url="http://localhost/meonggae_prj/footer/footer.jsp"/>
<!-- footer -->