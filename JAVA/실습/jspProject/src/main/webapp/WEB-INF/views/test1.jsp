<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
    <head>
        <meta charset = "UTF-8">
    </head>
    <body>
        JSP 파일로 만든 화면

        <h3>JSP(MVC1패턴) : HTML + JAVA 문법이 합쳐진 템플릿</h3>
        <%
        // 자바 코드 시작
            for(int i = 0 ; i <= 10; i++){
                out.println("<div>반복문 : " + i + "</div>"); // out.println(HTML에 출력할 문자열)
            }
        // 자바 코드 끝
        %>
    </body>
</html>