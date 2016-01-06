<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<form name="searchform" method="post" action="searchPro">
    <table border="1">
        <tr>
            <td>
                검색이름
            </td>
            <td>
                <input type="text" name="name">
            </td>
            <td>
                <input type="submit" value="찾기">
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <input type="button" value="메인으로 가기" onclick="location='/main'">
            </td>
        </tr>
    </table>
</form>