<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>${member.id} 수정페이지</h2>
<form name="modifyform" method="post" action="modifyPro">
    <table border="1">
        <tr>
            <td>
                아이디
            </td>
            <td>
                <input type="text" name="id" value="${member.id}" readonly>
            </td>
        </tr>
        <tr>
            <td>
                이름
            </td>
            <td>
                <input type="text" name="name" value="${member.name}">
            </td>
        </tr>
        <tr>
            <td>
                비밀번호
            </td>
            <td>
                <input type="password" name="password">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="수정">
                <input type="button" value="뒤로" onclick="location='/main'">
            </td>
        </tr>
    </table>
</form>
