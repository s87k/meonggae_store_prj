<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="나의 상점_리뷰"%>
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
<link rel="stylesheet" href="http://localhost/meonggae_prj/My/common/css/style_store.css">
<!-- CSS -->

<script type="text/javascript">
	$(function(){
		
	});//ready
</script>

<div class="container">
	<div id="storeBanner" class="storeBanner">
		<div id="profileImg" class="profileImg">
		<img src="http://localhost/meonggae_prj/common/image/profile_temp.png" class="img-circle" style="width: 100px; height: 100px"/>
		</div>
		<div id="userInfo" class="userInfo">
			<div id="nick" class="nick">벽돌파는사람님의 상점</div>
			<a href="#void" id="userDeclaration"><img src="http://localhost/meonggae_prj/common/image/declaration.png" style="width:18px; height: 18px;"/>신고</a>
		</div>
	</div>
	<div id="storeMenu" class="storeMenu">
		<a href="http://192.168.10.220/meonggae_prj/My/store/store_frm.jsp" id="unSelected">상품</a> | <a href="http://192.168.10.220/meonggae_prj/My/store/review_frm.jsp" id="selected">후기</a>
	</div>
		
	<div class="totalStarScore">
	5<br>
	<div class="stars">★★★★★</div>
	</div>
	<hr style="color: #606060;">
	<div class="review">
		<div class="reviewerName">집에가고싶은사람</div>
		<div class="stars">★★★★★</div>
		<div class="reviewContent">너무졸려요!!</div>
	</div>
	<hr>
	<div class="moreReviewWrap">
	<input type="button" value="더보기" class="moreReviewBtn"/>
	</div>
</div>

<!-- footer -->
<c:import url="http://localhost/meonggae_prj/footer/footer.jsp"/>
<!-- footer -->