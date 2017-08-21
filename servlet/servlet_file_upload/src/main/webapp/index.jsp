<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Servlet : File Upload</title>
</head>
<body>
<h1>Servlet : File Upload</h1>
Select a file to upload<br/><br/>
<form action="${pageContext.request.contextPath}/file_upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/><br><br><br>
    <input type="submit" value="Upload"/>
</form>
</body>
</html>
