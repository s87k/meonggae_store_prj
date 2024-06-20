<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멍게장터</title>
<link rel="icon" href="../common/tamcatIcon.ico"/>

<!-- jQuery CDN -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
<!-- Google Font -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700|Raleway:400,300,500,700,600' rel='stylesheet' type='text/css'>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css" type="text/css">
<!-- Theme Stylesheet -->

<script src ="http://localhost/meonggae_prj/common/JS/script.js"></script>
<link rel="stylesheet" href="http://localhost/meonggae_prj/common/CSS/style.css">
<link rel="stylesheet" href="http://localhost/meonggae_prj/common/CSS/responsive.css">
</head>
<body>
<!-- header 시작 -->
<jsp:include page="../header/header.jsp" />
<!-- header 끝 -->
<div class="container">
<c:if test="${not empty list}">
	<div class="row">
		<div class="search_categoryNavigation">
			<div class="p-css">
				<p>카테고리</p>
				<div class="category-fav">
					<c:forEach var="entry" items="${requestScope.cateCnt}" varStatus="i">
        				<c:if test="${i.index < 3}">
						<div class="category-fav-item">
						 <c:set var="categoryName" value="" />
            			 <c:forEach var="item" items="${requestScope.list}">
                			<c:if test="${entry.key == item.categoryNum}">
                    			<c:set var="categoryName" value="${item.categoryName}" />
                			</c:if>
            			 </c:forEach>
							<a href="http://localhost/meonggae_prj/main_page/search_contents.do?kw=${requestScope.keyword}&cn=${entry.key}" class="category-one2">
								> ${categoryName} +${entry.value}
							</a>
						</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
			<div class="category-nomal">
				<c:forEach var="entry" items="${requestScope.cateCnt}" varStatus="i">
					<c:if test="${i.index >= 3}">
					<div class="category-item">
					<c:set var="categoryName" value="" />
            			 <c:forEach var="item" items="${requestScope.list}">
                			<c:if test="${entry.key == item.categoryNum}">
                    			<c:set var="categoryName" value="${item.categoryName}" />
                			</c:if>
            			 </c:forEach>
						<a href="http://localhost/meonggae_prj/main_page/search_contents.do?kw=${requestScope.keyword}&cn=${entry.key}" class="category-one">
							${categoryName} +${entry.value}
						</a>
					</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

    <div class="featured-items">

        <div class="container">

            <div class="row" style="padding: 0 15px">

                <div class="tab-content">

                    <div class="tab-pane active" id="trending">

                    	<div class="single-products">
							<c:forEach var="pd" items="${requestScope.list}" varStatus="i">
                            	<div class="single-product">
                            		<div class="product-block">
                            			<a href="http://localhost//meonggae_prj/main_page/products_detail.do?goodsNum=${ pd.goodsNum }">
                            			<!-- 상세페이지로 이동 -->
											<img src="http://localhost/meonggae_prj/products-img/${ pd.imgName }" alt="" class="thumbnail">
											<div class="product-description ">
												<p class="title">${ pd.goodsName }</p>
												<div style="overflow: hidden;">
													<p class="price" style="float: left;">${ pd.priceFm }원</p>
													<p class="location" style="float: left;"><i class="fa fa-map-marker" aria-hidden="true"></i>${ pd.locationStr }</p>
													<p class="time-ago" style="float: right;">${ pd.timeAgo }</p>
												</div>
											</div>
                            			</a>
									</div>
								</div>
							</c:forEach>
						</div>
                   	</div>

				</div>

			</div>

		</div>

	</div>
</c:if>
<c:if test="${empty list}">
	<div class="empty-list">
        <h1> ${requestScope.keyword } </h1>
        <h1> ${categoryName } </h1>
        <h3>에 대한 검색 결과가 없습니다.</h3>
	</div>
</c:if>
<!-- footer include 시작 -->
	<jsp:include page="../footer/footer.jsp" />
<!-- footer include 끝 -->