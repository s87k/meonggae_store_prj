jQuery(document).ready(function($) {
	////////////////// 상품 상세페이지 //////////////////////////
	//찜 클릭
	$("#wishlist-btn").click(function() {
		if ($(this).hasClass("wished")) {
			$(this).removeClass("wished");
			$(this).html('<i class="fa fa-heart-o"></i> 찜 0');
		}else{
			$(this).addClass("wished");
			$(this).html('<i class="fa fa-heart"></i> 찜 1');
		}
	});//click
	
	//신고하기
	$(".open-report-modal").click(function(){
		$("#reportModal").modal("show");
	});
	$("#reportModal").on('hidden.bs.modal',function(e){
		$(this).find('form')[0].reset();
	});
});//ready