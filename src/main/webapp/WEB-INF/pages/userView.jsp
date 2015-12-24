<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2><%=session.getAttribute("id")%>의 회원관리</h2>

<form name="modifyform" method="post" action="/modifyPro" >
    <table>
        <tr>
            <th>아이디</th>
            <td>
                <input class="input" type="text" name="id" value="${member.id}" readonly>
            </td>
        </tr>
        <tr>
            <th>이름</th>
            <td>
                <input class="input" type="text" name="name" value="${member.name}">
            </td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td>
                <input class="input" type="password" name="password" value="${member.password}">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input class="button" type="submit" value="수정">
                <input class="button" type="button" value="로그아웃" onclick="location='/logout'">
            </td>
        </tr>
    </table>
</form>