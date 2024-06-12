<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="마이페이지 메인"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 로그인 세션 설정 시작 -->
<%

%>
<!-- 로그인 세션 설정 끝 -->

<!-- header -->
<c:import url="http://localhost/meonggae_prj/common/My/css/css.jsp"/>
<c:import url="../../../header/header.jsp"/>
<!-- header -->

<!-- CSS -->
<link rel="stylesheet" href="http://localhost/meonggae_prj/common/css/style.css">
<link rel="stylesheet" href="http://localhost/meonggae_prj/My/common/css/style_mypage.css">
<!-- CSS -->

<script type="text/javascript">
	$(function(){
		
	});//ready
</script>

<!-- 내용 시작 -->
<div class="container">
	<div id="mypageMenu" class="mypageMenu">
		<!-- 메뉴목록 -->
		<%
		String pageName = "mypage";
		pageContext.setAttribute("pageName", pageName);
		%>
		<%@ include file="../menuBar/mypageMenu.jsp" %>
		<hr id="menuBottonLine">
		<!-- 메뉴목록 -->
		
		<a href="https://naver.com">
		<div id="dibListTitle" class="dibList">♥ 찜 목록</div>
		</a>
		<div id="dibList" class="dibList">
			<div class="row">
				<div class="tab-content">
					<div class="tab-pane active" id="trending">
						<c:forEach begin="1" end="4" varStatus="i">
						<div class="col-md-3 col-sm-4">
							<div class="single-product">
								<div class="product-block">
									<img src="../../../products-img/product-${ i.index }.jpg" class="thumbnail">
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
		
		<a href="https://naver.com">
		<div id="soldListTitle" class="soldList">판매 완료 목록</div>
		</a>
		<div id="soldList" class="soldList">
			<div class="row">
				<div class="tab-content">
					<div class="tab-pane active" id="trending">
						<c:forEach begin="1" end="4" varStatus="i">
						<div class="col-md-3 col-sm-4">
							<div class="single-product">
								<div class="product-block">
									<img src="../../../products-img/product-${ i.index }.jpg" class="thumbnail">
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
		
		<a href="https://naver.com">
		<div id="boughtListTitle" class="boughtList">구매 완료 목록</div>
		</a>
		<div id="boughtList" class="boughtList">
			<div class="row">
				<div class="tab-content">
					<div class="tab-pane active" id="trending">
						<c:forEach begin="1" end="4" varStatus="i">
						<div class="col-md-3 col-sm-4">
							<div class="single-product">
								<div class="product-block">
									<img src="../../../products-img/product-${ i.index }.jpg" class="thumbnail">
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
		
	</div>
</div>
<!-- 내용 끝 -->

<!-- footer -->
<c:import url="http://localhost/meonggae_prj/footer/footer.jsp"/>
<!-- footer -->