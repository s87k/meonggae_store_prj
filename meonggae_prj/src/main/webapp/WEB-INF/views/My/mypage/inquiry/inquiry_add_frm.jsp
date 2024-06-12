<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="1:1 문의"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 로그인 세션 설정 시작 -->
<%

%>
<!-- 로그인 세션 설정 끝 -->

<!-- header -->
<c:import url="http://localhost/meonggae_prj/My/common/css/css.jsp"/>
<c:import url="http://localhost/meonggae_prj/header/header.jsp"/>
<!-- header -->

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/lang/summernote-ko-KR.min.js"></script>
<!-- include summernote css/js -->

<!-- CSS -->
<link rel="stylesheet" href="http://localhost/meonggae_prj/common/css/style.css">
<link rel="stylesheet" href="http://192.168.10.220/meonggae_prj/My/common/css/style_mypage.css">
<!-- CSS -->


<script type="text/javascript">
	$(function(){
		$('#summernote').summernote({
			height: 500,
			width: 820,
			focus: true,
			lang: 'ko-KR',
			toolbar: [
				// [groupName, [list of button]]
				['style', ['bold', 'italic', 'underline', 'clear']],
				['fontsize', ['fontsize']],
				['color', ['color']],
				['para', ['ul', 'ol']],
				['insert', ['picture']]
			]
		});
	});//ready
</script>

<!-- 내용 시작 -->
<div class="container">
		<!-- 메뉴목록 -->
	<div id="mypageMenu" class="mypageMenu">
		<%
		String pageName = "inquiry";
		pageContext.setAttribute("pageName", pageName);
		%>
		<%@ include file="../menuBar/mypageMenu.jsp" %>
		
		<hr id="menuBottonLine">
	</div>
		<!-- 메뉴목록 -->
		
		<form method="post" id="postFrm">
		<div class="inquiryStyle1">문의 제목<br/>
		<input type="text" id="inquiryStyle2" class="inquiryStyle2" placeholder="제목" maxlength="20"/><br/></div>
		
		<div class="inquiryStyle1">문의 내용</div>
		<textarea id="summernote" class="ta"></textarea>
		
		<input type="button" value="글 작성" id="submitBtn" class="btn btn-primary btn-lg"/>
		</form>
		
</div>
<!-- 내용 끝 -->

<!-- footer -->
<c:import url="http://localhost/meonggae_prj/footer/footer.jsp"/>
<!-- footer -->