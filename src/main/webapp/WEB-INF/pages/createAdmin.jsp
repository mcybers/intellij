<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<h2> 로그인 화면입니다. </h2>
<body>
    <form name="createform" method="post" action="/input">
        <input type="hidden" name="id" value="admin">
        <input type="hidden" name="name" value="admin">
        <input type="hidden" name="password" value="123">
        <table border="1">
                <tr>
                    <th>
                        <input type="submit" value="관리자 생성">
                        <input type="button" value="메인페이지" onclick="location='/main'">
                    </th>
                </tr>
            </table>
    </form>
</body>