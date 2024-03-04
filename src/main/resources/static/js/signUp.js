function signUpSubmit(){

    var form = $("#signUpForm")[0];
    var formData = new FormData(form);

    //data json으로 저장
    var data = {

        "password" : $.trim($("#password").val()),
        "passwordCheck" : $.trim($("#passwordCheck").val()),
        "nickname" : $.trim($("#nickname").val()),
        "email" : $.trim($("#email").val()),

    }
    formData.append("createUserRequest", new Blob([JSON.stringify(data)] , {type: "application/json"}));     //createUserRequest 이름으로 회원가입 정보 저장

    $.ajax({
                url : "/users/register",
                type : "post",
                data : formData,
                dataType : 'json',
                contentType : false,
                processData : false,
                success : function(data) {
                    window.location.replace('/users/loginForm'); //로그인 창으로 이동
                    alert("회원가입이 완료되었습니다.");
                },
                error : function(error){
                    alert(JSON.stringify(error));
                }
    });
}
