<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>로그인 페이지</h1><hr>
<form id="loginForm">
    <input type="text" id="email" name="email" placeholder="이메일"/><br>
    <input type="password" id="password" name="password" placeholder="패스워드"/>
    <button type="submit">로그인</button>
</form>

<script>
    $(document).ready(function() {
        $('#loginForm').submit(function(event) {
            // 폼 기본 동작 방지
            event.preventDefault();

            // 입력값 가져오기
            var email = $('#email').val();
            var password = $('#password').val();

            // AJAX 요청
            $.ajax({
                type: 'POST',
                url: '/sign-in',
                contentType: 'application/json',
                data: JSON.stringify({
                    email: email,
                    password: password
                }),
                success: function(response) {
                    // 서버로부터의 응답 처리
                    console.log(response);
                    alert('로그인 성공!');
                    // 페이지 이동
                    window.location.href = '/chat/room';
                },
                error: function(xhr, status, error) {
                    // 오류 처리
                    console.error(xhr.responseText);
                    alert('로그인 실패!');
                    // 필요한 처리 수행
                }
            });
        });
    });
</script>

</body>
</html>
