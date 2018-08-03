/*
	로그인 ID 와 비밀번호 검증을 위한 정규 표현식
*/
var idReg1 = /^[\w]*$/;
var idReg2 = /^[a-zA-Z]/;
var idReg3 = /^.{8,}$/;

/*
	공용 Selector
*/
var commonSelector = {
	login: "#mLogin"
}

/*
	Selector
*/
var iSel = {
	info: "#info",
	loginBox: "#loginModal",
	id: "#id",
	pwd: "#pwd",
	btnModal: "#btnModal",
	loginForm: "#myForm",
	linkPage: "#"
}

/*
	대화 상자에 표시될 메시지
*/
var iMsg = {
	baseInfoMsg: "<strong>멀티 프레임 워크</strong><br/><hr/>세미 프로젝트",
	specialCharMsg: "특수문자는 사용할 수 없습니다.",
	alphaMsg: "첫문자는 영문자로 시작해야합니다.",
	combineMsg: "최소8자 이상 문자,숫자를 조합해야 합니다.",
	changePwd: "비밀번호는 3달에 한번 바꾸어주세요."
}

/*
	로그인 대화상자
*/
$(iSel.loginBox).modal({
	backdrop: false,
	show: false
});	

// 기본 메시지 표시
$(iSel.info).html(iMsg.baseInfoMsg);

// 메뉴에서 로그인을 클릭한 경우 실행
$(commonSelector.login).click(function(){
	$(iSel.id, iSel.pwd).val("");			// 아이디와 비밀번호를 초기화
	$(iSel.btnModal).trigger("click");		// 로그인 대화 상자 띄움

	var isKeyin = false;

	/*
		메시지 좌우로 <br/> 추가 함수
		leftRight 의 값이
		   -1 이면,  좌측에 <br/> 추가
		    0 이면,  좌측과 우측에 <br/> 추가
		    1 이면,  우측에 <br/> 추가
	*/
	var addBr = function(msg, leftRight){
		var tmp;
		switch(leftRight){
			case -1: tmp = "<br/>" + msg; break;
			case 0:  tmp = "<br/>" + msg + "<br/>"; break;
			case 1:  tmp = msg + "<br/>"; break;
		}
		return tmp; 
	}

	/*
		ID와 비밀번호를 입력시
		유효성 검증
	*/
	var keyupFunc = function($input, isVal){
		if(!isVal) {
			isVal = true;
		}
		var inputVal = $input.val();

		var result1 = idReg1.test(inputVal);
		var result2 = idReg2.test(inputVal);
		var result3 = idReg3.test(inputVal);

		$(iSel.info).text("");
		if(!result1) {
			$(iSel.info).html(addBr(iMsg.specialCharMsg, 0));
		}
		if(!result2) {
			$(iSel.info).html($(iSel.info).text() + addBr(iMsg.alphaMsg, 0));
		}
		if(!result3) {
			$(iSel.info).html($(iSel.info).text() + addBr(iMsg.combineMsg,0));
		}
		$input.css("background-color", inputVal.length == 0 && isVal ? "#ffffc5" : "white");
	}

	// ID 또는 비밀번호에 입력시 발생
	$(iSel.id + "," + iSel.pwd).on("keyup", function(){
		keyupFunc($(this), isKeyin);
	});

	// ID에 focus 있을때
	$(iSel.id).on("focus", function(){
		$(iSel.info).html(iMsg.alphaMsg + addBr(iMsg.combineMsg, -1));
	});

	// 비밀번호에 focus 있을때
	$(iSel.pwd).on("focus", function(){
		$(iSel.info).html(iMsg.changePwd + addBr(iMsg.combineMsg, -1));
	});

	// ID 또는 비밀번호에서 focus가 사라질때
	$(iSel.id + "," + iSel.pwd).on("blur", function(){
		$(this).css("background-color", "white");
		$(iSel.info).html(iMsg.baseInfoMsg);
	});
});

// 취소 버튼 클릭시 
$(iSel.loginForm).on("reset", function(e){
	$(iSel.loginBox).css("display", "none");
	e.preventDefault();
});		

// 로그인 버튼 클릭시
$(iSel.loginForm).on("submit", function(e){
	e.preventDefault();
	location.href = iSel.linkPage;
});