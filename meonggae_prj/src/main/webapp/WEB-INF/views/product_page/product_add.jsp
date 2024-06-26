<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멍게장터</title>
<link rel="icon" href="../common/tamcatIcon.ico" />

<!-- jQuery CDN -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
	integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
	crossorigin="anonymous"></script>
<!-- Google Font -->
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700|Raleway:400,300,500,700,600'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.css"
	type="text/css">
<!-- Theme Stylesheet -->
<script src="../common/JS/script.js"></script>
<script src="../common/JS/tab.js"></script>
<script src="../common/JS/product_add.js"></script>
<link rel="stylesheet"
	href="http://localhost/meonggae_prj/common/CSS/style.css?v=1.0">
<link rel="stylesheet"
	href="http://localhost/meonggae_prj/common/CSS/tab.css?v=1.0">
<link rel="stylesheet"
	href="http://localhost/meonggae_prj/common/CSS/product_add.css?v=1.0">
</head>

<body>
    <!-- header 시작 -->
    <jsp:include page="../header/header.jsp" />
    <!-- header 끝 -->
    <div class="container" style="height: 100%">
        <div class="tab">
            <ul class="tabnav">
                <li><a href="#tab01">상품등록</a></li>
                <li><a href="#tab02">판매상태</a></li>
            </ul>
            <div class="tabcontent">
                <div id="tab01">
                    <form name="newProduct" action="" class="form-horizontal" method="post">
                        <div class="form-section">
                 <div class="form-group">
                    <label for="image">상품이미지</label>
                    <img id="image-preview" class="image-preview" src="">
                    <input type="file" id="image" name="image" accept="image/*" onchange="previewImage(event)">
                </div>
                <div class="form-group">
                    <label for="product-name">상품명</label>
                    <input type="text" id="product-name" name="product-name">
                </div>
                <div class="form-group">
                    <label for="category">카테고리</label>
                    <select id="category" name="category">
                        <option value="여성의류">여성의류</option>
                        <option value="남성의류">남성의류</option>
                        <option value="신발">신발</option>
                        <option value="가방/지갑">가방/지갑</option>
                        <option value="시계">시계</option>
                        <option value="쥬얼리">쥬얼리</option>
                        <option value="패션 악세서리">패션 악세서리</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="product-name">가격</label>
                    <input type="text" id="product-price" name="product-price">
                </div>
            </div>
            <div class="form-section">
                <div class="form-group">
                    <label>물품 상태</label>
                    <div class="radio-group">
                        <label><input type="radio" name="condition" value="미개봉"> 미개봉</label>
                        <label><input type="radio" name="condition" value="거의 새 것"> 거의 새 것</label>
                        <label><input type="radio" name="condition" value="사용감 있음"> 사용감 있음</label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                    <label for="product-name">직거래 장소</label>
                    <input type="text" id="trade-addr" name="trade-addr">
                </div>
            <div class="form-section">
                <div class="form-group">
                    <label for="description">설명</label>
                    <textarea id="description" name="description" rows="5"></textarea>
                </div>
            </div>
            <div class="form-actions">
                <button type="submit" class="btn">등록하기</button>
                <button type="button" class="btn btn-secondary">임시저장</button>
            </div>
                    </form>
                </div>
                <div id="tab02">
                    <form>
                        <!-- <input type="search" placeholder="검색어를 입력하세요"> -->
                        <table class="table table-hover" style="width: 100%;">
                            <thead>
                                <tr>
                                    <th style="width: 150px;">물품</th>
                                    <th style="width: 100px;">상태</th>
                                    <th style="width: 100px;">카테고리</th>
                                    <th style="width: 150px;">상품명</th>
                                    <th style="width: 100px;">가격</th>
                                    <th style="width: 150px;">물품 상태</th>
                                    <th style="width: 150px;">직거래 장소</th>
                                    <th style="width: 50px;">찜</th>
                                    <th style="width: 50px;">수정</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="product" items="${productList}">
                                    <tr>
                                        <td><img alt="상품 정보" src="http://localhost/meonggae_prj/products-img/${product.img}"></td>
                                        <td>
                                            <select>
                                                <option value="판매중" <c:if test="${product.sell_status_code == 'N'}">selected</c:if>>판매중</option>
                                                <option value="판매완료" <c:if test="${product.sell_status_code == 'S'}">selected</c:if>>판매완료</option>
                                            </select>
                                        </td>
                                        <td>${product.category_num}</td>
                                        <td>${product.name}</td>
                                        <td>${product.price}</td>
                                        <td>
                                        <c:if test="${product.quality_code == '1'}">미개봉</c:if>
                                        <c:if test="${product.quality_code == '2'}">거의 새 것</c:if>
                                        <c:if test="${product.quality_code == '3'}">사용감 있음</c:if>
                                        </td>
                                        <td>${product.location}</td>
                                        <td>${product.cnt}</td>
                                        <td><input type="button" class="btn btn-success btn-sm" value="수정"></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </form>
                </div>
            </div>
        </div>
        <!--tab-->
    </div>
    <!-- footer 시작 -->
    <jsp:include page="../footer/footer.jsp" />
    <!-- footer 끝 -->
</body>
</html>
