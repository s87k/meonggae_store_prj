<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	info="관리자 - 대시보드"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("UTF-8");%>
<%/*
작성자: 김동섭
작성일: 2024-06-01
*/%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멍게장터 관리자</title>
<link rel="icon" href="http://192.168.10.214${pageContext.request.contextPath}/mgr_common/images/favicon.png"/>
<!--bootstrap 시작-->
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous"> -->
<!-- <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script> -->
<!--bootstrap 끝-->

<!-- dashlite css 시작-->
<link rel="stylesheet" href="http://192.168.10.214${pageContext.request.contextPath}/mgr_common/assets/css/dashlite.css?ver=3.2.3">
<!--dashlite css 끝-->

<!-- <link rel="stylesheet" href="http://192.168.10.214${pageContext.request.contextPath}/common/css/board.css" type="text/css" media="all" /> -->
<!-- <link rel="stylesheet" href="http://192.168.10.214${pageContext.request.contextPath}/common/css/main.css" type="text/css" media="all" /> -->

<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<!--jQuery CDN 끝-->

<style type="text/css">
	
	
	
</style>

<script type="text/javascript">

	$(function() {

	}); // $(document).ready(function() { })

</script>

</head>
<body class="nk-body bg-lighter npc-general has-sidebar no-touch nk-nio-theme">
<div class="nk-app-root">
<div class="nk-main ">
<!-- 사이드바 시작 -->
<c:import url="/WEB-INF/views/mgr/common/jsp/sidebar.jsp"/>
<!-- 사이드바 끝 -->
<div class="nk-wrap ">
<!-- 헤더 시작 -->
<c:import url="/WEB-INF/views/mgr/common/jsp/header.jsp"/>
<!-- 헤더 끝 -->
<!-- 본문 시작 -->
<div class="nk-content ">
<div class="container-fluid">
<div class="nk-content-inner">
<div class="nk-content-body">

<div class="nk-block-head nk-block-head-sm">
	<div class="nk-block-between">
		<div class="nk-block-head-content">
			<h3 class="nk-block-title page-title">대시보드</h3>
		</div>
	</div>
</div>
<div class="nk-block">
	<div class="row g-gs">
		<!-- 상위거래 카테고리 시작 -->
		<div class="col-xxl-6">
			<div class="card card-bordered h-100">
				<div class="card-inner">
					<div class="card-title-group pb-3 g-2">
						<div class="card-title card-title-sm">
							<h6 class="title">상위거래 카테고리</h6>
						</div>
						<div class="card-tools">
							<div class="drodown">
								<a href="#" class="dropdown-toggle dropdown-indicator btn btn-sm btn-outline-light btn-white" data-bs-toggle="dropdown" aria-expanded="false">30 일</a>
								<div class="dropdown-menu dropdown-menu-end dropdown-menu-xs" style="">
									<ul class="link-list-opt no-bdr">
										<li>
											<a href="#">
												<span>1 일</span>
											</a>
										</li>
										<li>
											<a href="#">
												<span>7 일</span>
											</a>
										</li>
										<li>
											<a href="#">
												<span>30 일</span>
											</a>
										</li>
									</ul>
								</div>
							</div>
						</div>						
					</div>
					<div class="traffic-channel">
						<div class="analytic-data analytic-ov-data">
							<div class="title">총 거래수</div>
							<div class="amount">7000</div>
						</div>					
						<div class="traffic-channel-doughnut-ck">
							<!-- 상위 거래 카테고리 그래프 시작 -->
							<canvas class="analytics-doughnut" id="TrafficChannelDoughnutData" style="display: block; box-sizing: border-box; height: 160px; width: 436px;" width="872" height="320"></canvas>
							<!-- 상위 거래 카테고리 그래프 끝 -->
						</div>
						<div class="traffic-channel-group g-2">
							<div class="traffic-channel-data">
								<div class="title">
									<span class="dot dot-lg sq" data-bg="#9cabff" style="background: rgb(156, 171, 255);"></span>
									<span>의류</span>
								</div>
								<div class="amount">4,305 <small>58.63%</small>
								</div>
							</div>
							<div class="traffic-channel-data">
								<div class="title">
									<span class="dot dot-lg sq" data-bg="#b8acff" style="background: rgb(184, 172, 255);"></span>
									<span>신발</span>
								</div>
								<div class="amount">859 <small>23.94%</small>
								</div>
							</div>
							<div class="traffic-channel-data">
								<div class="title">
									<span class="dot dot-lg sq" data-bg="#ffa9ce" style="background: rgb(255, 169, 206);"></span>
									<span>가방</span>
								</div>
								<div class="amount">482 <small>12.94%</small>
								</div>
							</div>
							<div class="traffic-channel-data">
								<div class="title">
									<span class="dot dot-lg sq" data-bg="#f9db7b" style="background: rgb(249, 219, 123);"></span>
									<span>기타</span>
								</div>
								<div class="amount">138 <small>4.49%</small>
								</div>
							</div>
						</div>
					</div>					
				</div>
			</div>
		</div>
		<!-- 상위거래 카테고리 끝 -->
		<!-- 사용자수 요약 시작 -->
		<div class="col-xxl-6">
			<div class="card card-bordered h-100">
				<div class="card-inner mb-n2">
					<div class="card-title-group">
						<div class="card-title card-title-sm">
							<h6 class="title">사용자수 요약</h6>
						</div>
						<div class="card-tools">
							<div class="drodown">
								<a href="#" class="dropdown-toggle dropdown-indicator btn btn-sm btn-outline-light btn-white" data-bs-toggle="dropdown" aria-expanded="false">30 일</a>
								<div class="dropdown-menu dropdown-menu-end dropdown-menu-xs" style="">
									<ul class="link-list-opt no-bdr">
										<li>
											<a href="#">
												<span>1 일</span>
											</a>
										</li>
										<li>
											<a href="#">
												<span>7 일</span>
											</a>
										</li>
										<li>
											<a href="#">
												<span>30 Days</span>
											</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="nk-tb-list is-loose traffic-channel-table">
					<div class="nk-tb-item nk-tb-head">
						<div class="nk-tb-col nk-tb-channel">
							<span>항목</span>
						</div>
						<div class="nk-tb-col nk-tb-sessions">
							<span>오늘</span>
						</div>
						<div class="nk-tb-col nk-tb-prev-sessions">
							<span>어제</span>
						</div>
						<div class="nk-tb-col nk-tb-change">
							<span>전일 대비</span>
						</div>
						<div class="nk-tb-col nk-tb-trend tb-col-sm text-end">
							<span>추이</span>
						</div>
					</div>
					<div class="nk-tb-item">
						<div class="nk-tb-col nk-tb-channel">
							<span class="tb-lead">방문자수</span>
						</div>
						<div class="nk-tb-col nk-tb-sessions">
							<span class="tb-sub tb-amount">
								<span>4,305</span>
							</span>
						</div>
						<div class="nk-tb-col nk-tb-prev-sessions">
							<span class="tb-sub tb-amount">
								<span>4,129</span>
							</span>
						</div>
						<div class="nk-tb-col nk-tb-change">
							<span class="tb-sub">
								<span>4.29%</span>
								<span class="change up">
									<em class="icon ni ni-arrow-long-up"></em>
								</span>
							</span>
						</div>
						<div class="nk-tb-col nk-tb-trend text-end">
							<div class="traffic-channel-ck ms-auto">
								<canvas class="analytics-line-small" id="OrganicSearchData" style="display: block; box-sizing: border-box; height: 44px; width: 130px;" width="260" height="88"></canvas>
							</div>
						</div>
					</div>
					<div class="nk-tb-item">
						<div class="nk-tb-col nk-tb-channel">
							<span class="tb-lead">회원수</span>
						</div>
						<div class="nk-tb-col nk-tb-sessions">
							<span class="tb-sub tb-amount">
								<span>859</span>
							</span>
						</div>
						<div class="nk-tb-col nk-tb-prev-sessions">
							<span class="tb-sub tb-amount">
								<span>936</span>
							</span>
						</div>
						<div class="nk-tb-col nk-tb-change">
							<span class="tb-sub">
								<span>15.8%</span>
								<span class="change down">
									<em class="icon ni ni-arrow-long-down"></em>
								</span>
							</span>
						</div>
						<div class="nk-tb-col nk-tb-trend text-end">
							<div class="traffic-channel-ck ms-auto">
								<canvas class="analytics-line-small" id="SocialMediaData" style="display: block; box-sizing: border-box; height: 44px; width: 130px;" width="260" height="88"></canvas>
							</div>
						</div>
					</div>
					<div class="nk-tb-item">
						<div class="nk-tb-col nk-tb-channel">
							<span class="tb-lead">가입자수</span>
						</div>
						<div class="nk-tb-col nk-tb-sessions">
							<span class="tb-sub tb-amount">
								<span>482</span>
							</span>
						</div>
						<div class="nk-tb-col nk-tb-prev-sessions">
							<span class="tb-sub tb-amount">
								<span>793</span>
							</span>
						</div>
						<div class="nk-tb-col nk-tb-change">
							<span class="tb-sub">
								<span>41.3%</span>
								<span class="change down">
									<em class="icon ni ni-arrow-long-down"></em>
								</span>
							</span>
						</div>
						<div class="nk-tb-col nk-tb-trend text-end">
							<div class="traffic-channel-ck ms-auto">
								<canvas class="analytics-line-small" id="ReferralsData" style="display: block; box-sizing: border-box; height: 44px; width: 130px;" width="260" height="88"></canvas>
							</div>
						</div>
					</div>
					<div class="nk-tb-item">
						<div class="nk-tb-col nk-tb-channel">
							<span class="tb-lead">탈퇴자수</span>
						</div>
						<div class="nk-tb-col nk-tb-sessions">
							<span class="tb-sub tb-amount">
								<span>138</span>
							</span>
						</div>
						<div class="nk-tb-col nk-tb-prev-sessions">
							<span class="tb-sub tb-amount">
								<span>97</span>
							</span>
						</div>
						<div class="nk-tb-col nk-tb-change">
							<span class="tb-sub">
								<span>12.6%</span>
								<span class="change up">
									<em class="icon ni ni-arrow-long-up"></em>
								</span>
							</span>
						</div>
						<div class="nk-tb-col nk-tb-trend text-end">
							<div class="traffic-channel-ck ms-auto">
								<canvas class="analytics-line-small" id="OthersData" style="display: block; box-sizing: border-box; height: 44px; width: 130px;" width="260" height="88"></canvas>
							</div>
						</div>
					</div>
				</div>
			</div>		
		</div>
		<!-- 사용자수 요약 끝 -->
		<!-- 이벤트 조회수 현황 시작 -->
		<div class="col-xxl-6">
			<div class="card card-bordered h-100">
				<div class="card-inner mb-n2">
					<div class="card-title-group">
						<div class="card-title card-title-sm">
							<h6 class="title">이벤트 조회수 현황</h6>
						</div>
						<div class="card-tools">
							<div class="drodown">
								<a href="#" class="dropdown-toggle dropdown-indicator btn btn-sm btn-outline-light btn-white" data-bs-toggle="dropdown" aria-expanded="false">진행중</a>
								<div class="dropdown-menu dropdown-menu-end dropdown-menu-xs" style="">
									<ul class="link-list-opt no-bdr">
										<li>
											<a href="#">
												<span>진행중</span>
											</a>
										</li>
										<li>
											<a href="#">
												<span>종료됨</span>
											</a>
										</li>
										<li>
											<a href="#">
												<span>전체</span>
											</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<table class="table">
					<thead class="table">
						<tr>
							<th scope="col">번호</th>
							<th scope="col" colspan="2">제목</th>
							<th scope="col">시작일</th>
							<th scope="col">종료일</th>
							<th scope="col">조회수</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td colspan="2">이벤트 제목 1</td>
							<td>2024.06.02</td>
							<td>2024.07.15</td>
							<td>7777</td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td colspan="2">이벤트 제목 2</td>
							<td>2024.06.02</td>
							<td>2024.07.15</td>
							<td>5555</td>
						</tr>
						<tr>
							<th scope="row">3</th>
							<td colspan="2">이벤트 제목 3</td>
							<td>2024.06.02</td>
							<td>2024.07.15</td>
							<td>3333</td>
						</tr>
						<tr>
							<th scope="row">4</th>
							<td colspan="2">이벤트 제목 4</td>
							<td>2024.06.02</td>
							<td>2024.07.15</td>
							<td>1111</td>
						</tr>
					</tbody>
				</table>
			</div>		
		</div>
		<!-- 이벤트 조회수 현황 끝 -->
		<!-- 신고 현황 시작 -->
		<div class="col-xxl-6">
			<div class="card card-bordered h-100">
				<div class="card-inner mb-n2">
					<div class="card-title-group">
						<div class="card-title card-title-sm">
							<h6 class="title">신고 현황</h6>
						</div>
					</div>
				</div>
				<table class="table">
					<thead class="table">
						<tr>
							<th scope="col" colspan="2" class="text-center">상점명</th>
							<th scope="col">총 신고 수</th>
							<th scope="col">최근 신고일</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row"><div class="user-avatar sm"><em class="icon ni ni-user-alt"></em></div></th>
							<td>가나다라 상점</td>
							<td>5</td>
							<td>2024.06.02 15:23</td>
						</tr>
						<tr>
							<th scope="row"><div class="user-avatar sm"><em class="icon ni ni-user-alt"></em></div></th>
							<td>ABCD 상점</td>
							<td>4</td>
							<td>2024.06.01 14:23</td>
						</tr>
						<tr>
							<th scope="row"><div class="user-avatar sm"><em class="icon ni ni-user-alt"></em></div></th>
							<td>테스트 상점</td>
							<td>3</td>
							<td>2024.06.01 12:23</td>
						</tr>
					</tbody>
				</table>
			</div>		
		</div>
		<!-- 신고 현황 끝 -->
		<!-- 사이트 방문자수 시작 -->

		<div class="col-xxl-12">
			<div class="card card-bordered h-100">
				<div class="card-inner">
					<div class="card-title-group pb-3 g-2">
						<div class="card-title card-title-sm">
							<h6 class="title">사이트 방문자수</h6>
						</div>
						<div class="card-tools shrink-0 d-none d-sm-block">
							<ul class="nav nav-switch-s2 nav-tabs bg-white">
								<li class="nav-item">
									<div class="form-group">
										<div class="form-control-wrap">
											<div class="input-daterange date-picker-range input-group" style="float:left; width:300px;">
										
												<div class="input-group-addon">시작일</div>
												<div class="form-control-wrap">
													<div class="form-icon form-icon-left"><em class="icon ni ni-calendar"></em></div>
													<input type="text" class="form-control date-picker" data-date-format="yyyy-mm-dd" maxlength="10"/>
												</div>
											
											</div>
											<div class="input-daterange date-picker-range input-group" style="float:left;width:300px;">
										
												<div class="input-group-addon">종료일</div>
												<div class="form-control-wrap">
													<div class="form-icon form-icon-left"><em class="icon ni ni-calendar"></em></div>
													<input type="text" class="form-control date-picker" data-date-format="yyyy-mm-dd" maxlength="10"/>
												</div>
											
											</div>
										</div>
									</div>
								</li>
								<li class="nav-item">
									<div class="card-title-group pb-3 g-2">
										<div class="card-title card-title-sm">
											<h6 class="title">간격</h6>
										</div>
										<div class="card-tools">
											<div class="drodown">
												<a href="#" class="dropdown-toggle dropdown-indicator btn btn-sm btn-outline-light btn-white" data-bs-toggle="dropdown" aria-expanded="false">일</a>
												<div class="dropdown-menu dropdown-menu-end dropdown-menu-xs" style="">
													<ul class="link-list-opt no-bdr">
														<li>
															<a href="#">
																<span>일</span>
															</a>
														</li>
														<li>
															<a href="#">
																<span>주</span>
															</a>
														</li>
														<li>
															<a href="#">
																<span>월</span>
															</a>
														</li>
													</ul>
												</div>
											</div>
										</div>						
									</div>								
								</li>
							</ul>
						</div>
					</div>
					<div class="analytic-ov">
						<div class="analytic-data-group analytic-ov-group g-3">
							<div class="analytic-data analytic-ov-data">
								<div class="title">총 방문자수</div>
								<div class="amount">2.57K</div>
								<div class="change up">
									<em class="icon ni ni-arrow-long-up"></em>12.37%
								</div>
							</div>
							<div class="analytic-data analytic-ov-data">
								<div class="title">회원 방문자</div>
								<div class="amount">1.01K</div>
								<div class="change up">
									<em class="icon ni ni-arrow-long-up"></em>17.74%
								</div>
							</div>
							<div class="analytic-data analytic-ov-data">
								<div class="title">비회원 방문자</div>
								<div class="amount">1.56K</div>
								<div class="change down">
									<em class="icon ni ni-arrow-long-down"></em>2.37%
								</div>
							</div>
						</div>
						<div class="analytic-ov-ck">
							<canvas class="analytics-line-large" id="analyticOvData" style="display: block; box-sizing: border-box; height: 175px; width: 521px;" width="1043" height="350"></canvas>
						</div>
						<div class="chart-label-group ms-5">
							<div class="chart-label">01 Jan, 2020</div>
							<div class="chart-label d-none d-sm-block">15 Jan, 2020</div>
							<div class="chart-label">30 Jan, 2020</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- 사이트 방문자수 끝 -->
	</div>
</div>

</div>
</div>
</div>
</div>
<!-- 본문 끝 -->
<!-- 푸터 시작 -->
<c:import url="/WEB-INF/views/mgr/common/jsp/footer.jsp"/>
<!-- 푸터 끝 -->
</div>
</div>
</div>
<!-- dashlite 시작-->
<script src="http://192.168.10.214${pageContext.request.contextPath}/mgr_common/assets/js/bundle_beauty_my.js?ver=3.2.3"></script>
<script src="http://192.168.10.214${pageContext.request.contextPath}/mgr_common/assets/js/scripts.js?ver=3.2.3"></script>
<!-- <script src="http://192.168.10.214${pageContext.request.contextPath}/mgr_common/assets/js/demo-settings.js?ver=3.2.3"></script> -->
<script src="http://192.168.10.214${pageContext.request.contextPath}/mgr_common/assets/js/charts/gd-analytics.js?ver=3.2.3"></script>
<script src="http://192.168.10.214${pageContext.request.contextPath}/mgr_common/assets/js/libs/jqvmap.js?ver=3.2.3"></script>
<div class="ui-timepicker-container ui-timepicker-hidden ui-helper-hidden" style="display: none;"><div class="ui-timepicker ui-widget ui-widget-content ui-menu ui-corner-all"><ul class="ui-timepicker-viewport"></ul></div></div>
<!-- dashlite 끝-->
<script type="text/javascript">
	$(function() {
		$("#sidebar-dashboard").addClass("active current-page");
	}); // $(document).ready(function() { })
</script>
</body>
</html>