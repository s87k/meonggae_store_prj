jQuery(document).ready(function($) {
	//검색버튼 클릭
	$("#search-btn").click(function(){
		location.href="http://localhost//meonggae_prj/main_page/search_contents.do";
	});
	
	//카테고리 토글
	$(".category-btn").click(function() {
		//카테고리 로드
		loadCategories();
		
		// .categories에 show 클래스가 있으면 .fa-bars에 color-change 클래스를 추가
		if ($(".categories").hasClass("show")) {
			$(".fa-bars").addClass("color-change");
		} else {
			$(".fa-bars").removeClass("color-change");
		}
	});//click

	//카테고리 상세 토글 보이기
	//$(".category-ul li").mouseenter(function() {
	$(".category-ul").on("mouseenter", "li", function() {
		//부모의 카테고리번호 가져오기
		var parentCategory = $(this).find(".parent-category").data("parentid");
		loadSubCategories(parentCategory);
	});//mouseenter
	$(".parent-category").mouseleave(function() {
		$(".category-detail").removeClass("show");
	});//mouseleave
	
	//카테고리 상세 토글 유지
	$(".category-detail").mouseenter(function() {
		$(".category-detail").toggleClass("show");
	});//mouseenter
	$(".category-detail").mouseleave(function() {
		$(".category-detail").toggleClass("show");
	});//mouseleave

	//스크롤의 위치에 따라 카테고리 위치 변경
	$(window).scroll(function() {
		var scrollPosition = $(window).scrollTop();
		var topPosition = (scrollPosition > 8) ? '145px' : '216px';

		$(".categories, .category-detail").css({
			top: topPosition
		});
	});//scroll

	//이벤트 버튼
	$(".event-btn").click(function(){
		location.href="http://localhost//meonggae_prj/event_page/event_main.do";
	});
	
	//로그인 버튼
	$(".login-btn").click(function() {
        $.ajax({
            url: 'http://localhost//meonggae_prj/login_page/login_page.do',
            type: 'GET',
            success: function(data) {
                $('#popupModal .modal-body').html(data);
                $('#popupModal').modal('show');
            },
            error: function(xhr, status, error) {
                console.error('AJAX Error: ' + status + error);
            }
        });
	});
});//ready

//카테고리 로드
function loadCategories(){
$.ajax({
	type: 'GET',
	url: 'parentCategory.do',
	dataType:"json",
	success: function(response){
		updateCategoryList(response);
		//카테고리 show
		$(".categories").toggleClass("show");
	},
	error: function(xhr){
		console.log('대분류 카테고리 요청 실패', xhr.status);
	}
});//ajax
};//loadCategories

//카테고리 대분류 생성
function updateCategoryList(categories){
	var $ul = $(".category-ul");
	$ul.empty();
	
	//json parsing
	$.each(categories, function(index, item){
		var $li = $("<li>");
		var $a = $("<a>").attr("href", "#void")
						.addClass("parent-category")
						.attr("data-parentid", item.categoryNum)
						.text(item.name);
		$li.append($a);
		$ul.append($li);				
	});
};//updateCategoryList

//서브 카테고리 로드
function loadSubCategories(parentCategory){
$.ajax({
	url:'subCategory.do', 
	type:'GET',
	dataType:'json',
	data:{ Category:parentCategory },
	success: function(response){
		updateSubCategoryList(response);
		//서브 카테고리 show
        $(".category-detail").addClass("show");
	},
	error:function(xhr){
		console.log('소분류 카테고리 요청 실패', xhr.status);
	}
});
};//loadSubCategories

////카테고리 소분류 생성
function updateSubCategoryList(categories){
	var $ul = $(".detail-ul");
	$ul.empty();
	
	//json parsing
	$.each(categories, function(index, item){
		var $li = $("<li>");
		var $a = $("<a>").attr("href", "#void")
						.addClass("sub-category")
						.attr("data-value", item.categoryNum)
						.text(item.name);
		$li.append($a);
		$ul.append($li);
	});
};//updateSubCategoryList
