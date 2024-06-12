<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<a href="http://192.168.10.220/meonggae_prj/My/mypage/main/myPageMain_frm.jsp" id="${ pageName == 'mypage'?'selected':'unSelected' }">마이페이지</a> | 
<a href="http://192.168.10.220/meonggae_prj/My/mypage/dibs/dibsGoods_frm.jsp" id="${ pageName == 'dibsGoods'?'selected':'unSelected' }">찜 목록</a> | 
<a href="http://192.168.10.220/meonggae_prj/My/mypage/sales_list/salesDetails_frm.jsp" id="${ pageName == 'salesDetails'?'selected':'unSelected' }">거래내역</a> | 
<a href="http://192.168.10.220/meonggae_prj/My/mypage/personal/passwordChk_frm.jsp" id="${ pageName == 'personal'?'selected':'unSelected' }">개인정보</a> | 
<a href="http://192.168.10.220/meonggae_prj/My/mypage/inquiry/inquiry_frm.jsp" id="${ pageName == 'inquiry'?'selected':'unSelected' }">1:1문의</a> | 
<a href="http://192.168.10.220/meonggae_prj/My/mypage/review/review_frm.jsp" id="${ pageName == 'review'?'selected':'unSelected' }">나의 후기</a>
