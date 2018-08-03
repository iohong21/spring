/*
	첫번 째 Circle
*/
setTimeout(function(){
	$("#circle1")
	.addClass("growDownCircle")
	.one("animationend", function(){
		$(this).removeClass("growDownCircle");
	});
}, 0.1);

/*
	두번 째 Circle
	70ms 후 실행
*/
setTimeout(function(){
	$("#circle2")
	.addClass("growCircle")
	.one("animationend", function(){
		$(this)
		.removeClass("growCircle");
	});
}, 70);

/*
	세번 째 Circle
	90ms 후 실행
*/
setTimeout(function(){
	$("#circle3")
	.addClass("growDownCircle")
	.one("animationend", function(){
		$(this)
		.removeClass("growDownCircle");
		$("#indexPage").remove();
	});
}, 90);

