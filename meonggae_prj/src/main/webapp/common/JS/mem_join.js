$(function() {
	//datepicker 사용
	// 기본 사용
	//$( "#datepicker" ).datepicker();

	//input을 datepicker로 선언
	$("#datepicker").datepicker({ 
		dayNamesMin: ["일", "월", "화", "수", "목", "금", "토"],
		dateFormat: "yy-mm-dd",
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		monthNames: ["1월", "2월", "3월", "4월", "5월", "6월", "7월", "8월", "9월", "10월", "11월", "12월"],
		showMonthAfterYear: true,
		changeYear: true,
		changeMonth: true,
		yearRange: 'c-100:c+0'
	});
	
	//아이디 유효성검사
    $("#idChk").click(function(){
    	idDupWin();
    });
    
	//비밀번호 확인
	$("#password2").focusout(function() {
		chkCorrectPw();
	});
	
	//닉네임 유효성검사
	$("#nickChk").click(function(){
		nickDupWin();
	});
	
	//우편번호 검색
    $("#zipcode").click(function(){
    	zipcodeApi();
    });
	//우편번호 추가 검색
    $("#addChk").click(function(){
    	zipcodeApi();
    });
	
	//폼 제출
	$("#btnSubmit").click(function() {
		chkInputAll();
	}); // click

});//ready

//아이디 유효성검사 후 중복 팝업 생성
function idDupWin(){
	var id=document.frm.id.value;
    var reg = /^[A-z0-9]{5,12}$/;//영문/숫자 5~12자 이내인지 확인
    if( !reg.test(id) ){
    	alert("아이디를 영문, 숫자 5~12자 이내로 입력해주세요.");
        $("#id").val('');
        $("#id").focus();
    } else {
    	window.open("id_dup.do?id="+id, "idDup", "width=472, height=350, top="+
        (window.screenY+203)+", left="+(window.screenX+306));
    }
};//idDupWin

//비밀번호와 비밀번호 확인이 일치하는지
function chkCorrectPw() {
	if ($("#password").val() != $("#password2").val()) {
		alert('비밀번호가 다릅니다');
		$("#password").val('');
		$("#password2").val('');
		$("#password").focus();
	} // end if
}; // chkCorrectPw	

//닉네임 유효성검사 후 중복 팝업 생성
function nickDupWin() {
	var nick=document.frm.nick.value;
    var ko_reg = /^[ㄱ-ㅎ가-힣a-zA-Z0-9]{1,12}$/;//한글/영문/숫자 1~12자 이내인지 확인
    if( !ko_reg.test(nick) ){
    	alert("닉네임을 한글, 영문, 숫자 1~12자 이내로 입력해주세요.");
    	$("#nick").val('');
        $("#nick").focus();
     } else {
        window.open("nick_dup.do?nick="+nick, "nickDup", "width=472, height=400, top="+
        (window.screenY+203)+", left="+(window.screenX+306));
     }
}; //nickDupWin	

//필수 입력 확인
function chkInputAll() {
	let flagInputArrAll = true;
	let arrEssential = $(".essential");
	let arrLabel = ['아이디', '비밀번호', '이름', '닉네임', '생년월일', '전화번호', '우편번호', '주소', '상세주소']

	$.each(arrEssential, function(index, value) {
		if ($(value).val() == "") {
			alert(arrLabel[index] + '는 필수 입력입니다');
			flagInputArrAll = false;
			return false;
		} // end if
	});

	if (flagInputArrAll && !($("[name='gender']").is(":checked"))) {
		alert('성별은 필수 입력입니다');
		flagInputArrAll = false;
	} // end if

	if (flagInputArrAll) {
		$("#frm").submit();
	} // end if

}; // chkInputAll

//	다음 우편번호 API 설정
function zipcodeApi() {
	new daum.Postcode({
		oncomplete: function(data) {
			// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var roadAddr = data.roadAddress; // 도로명 주소 변수
			var extraRoadAddr = ''; // 참고 항목 변수

			// 법정동명이 있을 경우 추가한다. (법정리는 제외)
			// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
			if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
				extraRoadAddr += data.bname;
			}
			// 건물명이 있고, 공동주택일 경우 추가한다.
			if (data.buildingName !== '' && data.apartment === 'Y') {
				extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			}
			// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
			if (extraRoadAddr !== '') {
				extraRoadAddr = ' (' + extraRoadAddr + ')';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('zipcode').value = data.zonecode;
			document.getElementById("addr0").value = roadAddr;
			document.getElementById("addr1").focus();	// 커서를 상세 주소 input으로 이동
		}
	}).open();
};//zipcodeApi