<%@page import="com.store.meonggae.event.dao.UserEventDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.store.meonggae.event.domain.EventDomain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String eventCode = request.getParameter("event-code");
	UserEventDAO ueDAO = UserEventDAO.getInstance();
	int seq = Integer.parseInt(eventCode);
	EventDomain eventDetail = ueDAO.selectDetailEvent(seq);
	pageContext.setAttribute("eventDetail", eventDetail);
%>
<%if(eventCode != null){%>
<div class="container" style="height:1000px;">
		<table class="table table-hover;" style="width: 100%;">
		<tr>
		<th style="width: 50%">제목 : ${eventDetail.title}</th>
		<!-- <th style="width: 20%">작성자(DB에서 ID)</th> -->
		<th style="width: 20%">조회 수 : ${eventDetail.cnt}</th>
		<th style="width: 5%"><a href="http://localhost/meonggae_prj/event_page/event_main.do">목록으로</a></th>
		</tr>
		<tr>
		<td colspan="5">
		<img src="../common/images/event${eventDetail.img}" style="width: 100%; height: 500px;">
		${eventDetail.content}
		</td>
		</table>
 </div>
<%}else{%>
	없음 다시 시도하셈
<%}%>