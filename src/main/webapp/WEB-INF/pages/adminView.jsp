<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2><%=session.getAttribute("id")%>의 회원관리</h2>
<table border="1">
    <tr>
        <td>아이디</td>
        <td>이름</td>
    </tr>
    <c:forEach var="mem" items="${members}">
        <tr>
            <td>
                <a href="/modify?modifyid=${mem.id}">${mem.id}</a>
            </td>
            <td>
                    ${mem.name}
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="2">
            <input class="button" type="button" value="유저가입" onclick="location='/join'">
            <input class="button" type="button" value="로그아웃" onclick="location='/logout'">
        </td>
    </tr>
</table>