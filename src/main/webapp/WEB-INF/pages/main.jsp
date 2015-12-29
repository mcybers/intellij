<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<h2> 로그인 화면입니다. </h2>
<body>
    <form name="loginform" method="post" action="login">
            <table border="1">
                <tr>
                    <th colspan="2">
                        로그인
                    </th>
                </tr>
                <tr>
                    <td>ID</td>
                    <td><input type="text" name="id" maxlength="10"></td>
                </tr>
                <tr>
                    <td>P/W</td>
                    <td><input type="password" name="password" maxlength="10"></td>
                </tr>
                <tr>
                    <th colspan="2">
                        <input type="submit" value="로그인">
                        <input type="reset" value="취소">
                    </th>
                </tr>
            </table>
    </form>
</body>
