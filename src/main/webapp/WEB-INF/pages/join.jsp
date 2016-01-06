<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<form name="joinform" method="post" action="input">
    <table border="1">
        <tr>
            <th colspan="2">
                회원 가입
            </th>
        </tr>
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" maxlength="10"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" maxlength="10"></td>
        </tr>
        <tr>
            <td>비밀번호</td>
            <td><input type="password" name="password" maxlength="10"></td>
        </tr>
        <tr>
            <th colspan="2">
                <input type="submit" value="가입">
                <input type="reset" value="취소">
                <input type="button" value="뒤로" onclick="location='main'">
            </th>
        </tr>
    </table>
</form>