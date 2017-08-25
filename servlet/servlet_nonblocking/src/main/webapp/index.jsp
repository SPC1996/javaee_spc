<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Servlet : Non-blocking I/O</title>
</head>
<body>
<h1>Non-blocking I/O using Servlet 3.1</h1>
<form enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/client">
    <label for="fileToUpload">Select a File to Upload</label>
    <input type="file" name="fileToUpload" id="fileToUpload" onchange="fileSelected();"><br>
    <div id="fileName"></div>
    <div id="fileSize"></div>
    <div id="fileType"></div>
    <div>
        <input type="submit" value="Upload"/>
    </div>
</form>
</body>
<script type="text/javascript">
    function fileSelected() {
        var file = document.getElementById("fileToUpload").files[0];
        if (file) {
            var fileSize = 0;
            if (fileSize > 1024 * 1024) {
                fileSize = (Math.round(file.size * 100 / (1024 * 1024)) / 100).toString() + "MB";
            } else {
                fileSize = (Math.round(file.size * 100 / 1024) / 100).toString() + "KB";
            }
            document.getElementById("fileName").innerHTML = "Name: " + file.name;
            document.getElementById("fileSize").innerHTML = "Size: " + fileSize;
            document.getElementById("fileType").innerHTML = "Type: " + file.type;
        }
    }
</script>
</html>
