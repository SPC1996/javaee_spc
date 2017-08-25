<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Servlet : Metadata Complete</title>
</head>
<body>
<h1>Servlet : Metadata Complete</h1>
Call the <a href="${pageContext.request.contextPath}/meta_servlet">meta servlet</a>.
Call the <a href="${pageContext.request.contextPath}/web_servlet">web servlet</a>.
<br><br>
@WebServlet is ignored, instead the servlet-mapping from "web.xml" is used.
</body>
</html>
