<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<a href="http://192.168.10.220/meonggae_prj/My/mypage/sales_list/salesDetails_frm.jsp" id="${ lowPageName == 'sales'?'selected':'unSelected' }">판매중</a> | 
<a href="http://192.168.10.220/meonggae_prj/My/mypage/sales_list/soldDetails_frm.jsp" id="${ lowPageName == 'sold'?'selected':'unSelected' }">판매완료</a> | 
<a href="http://192.168.10.220/meonggae_prj/My/mypage/sales_list/boughtDetails_frm.jsp" id="${ lowPageName == 'bought'?'selected':'unSelected' }">구매완료</a>