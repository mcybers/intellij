<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1">
    <tr>
        <td>I D</td>
        <td>이 름</td>
    </tr>
    <c:forEach var="member" items="${members}">
    <tr>
        <td>${member.id}</td>
        <td>${member.name}</td>
    </tr>
    </c:forEach>
    <tr>
        <td colspan="2">
            <input type="button" value="메인으로 가기" onclick="location='/main'">
        </td>
    </tr>
</table>