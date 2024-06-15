<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="나의 상점"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 로그인 세션 설정 시작 -->
<%

%>
<!-- 로그인 세션 설정 끝 -->

<!-- header -->
<c:import url="http://localhost/meonggae_prj/common/My/css/css.jsp"/>
<c:import url="/WEB-INF/views/header/header.jsp"/>
<!-- header -->

<!-- CSS -->
<link rel="stylesheet" href="http://localhost/meonggae_prj/common/CSS/style.css">
<link rel="stylesheet" href="http://localhost/meonggae_prj/common/My/css/style_store.css">
<!-- CSS -->

<script type="text/javascript">
	$(function(){
		
	});//ready
</script>

<!-- 내용 시작 -->
<div class="container">
	<div id="storeBanner" class="storeBanner">
		<div id="profileImg" class="profileImg">
		<img src="http://localhost/meonggae_prj/common/images/profile_temp.png" class="img-circle" style="width: 100px; height: 100px"/>
		</div>
		<div id="userInfo" class="userInfo">
			<div id="nick" class="nick">벽돌파는사람님의 상점</div>
			<a href="#void" id="userDeclaration"><img src="http://localhost/meonggae_prj/common/images/declaration.png" style="width:18px; height: 18px;"/>신고</a>
		</div>
	</div>
		<span id="storeMenu" class="storeMenu">
			<a href="http://localhost/meonggae_prj/My/store/store_frm.do" id="selected">상품</a> | 
			<a href="http://localhost/meonggae_prj/My/store/store_review_frm.do" id="unSelected">후기</a>　　　
			<a href="http://localhost/meonggae_prj/My/mypage/main/myPageMain_frm.do" id="unSelected">@@마이페이지진입/임시@@</a>
		</span>
	<hr>
	
	<div class="row">
		<div class="tab-content">
			<div class="tab-pane active" id="trending">
				<c:forEach begin="1" end="5" varStatus="i">
				<div class="col-md-3 col-sm-4">
					<div class="single-product">
						<div class="product-block">
							<img src="../../products-img/product-${ i.index }.jpg" class="thumbnail">
							<div class="product-description text-left">
								<p class="title">여성의류</p>
								<div style="overflow: hidden;">
								<p class="price" style="float: left;">0원</p>
								<p class="time-ago" style="float: right;">0일전</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
	
</div>
<!-- 내용 끝 -->

<!-- footer -->
<c:import url="/WEB-INF/views/footer/footer.jsp"/>
<!-- footer -->