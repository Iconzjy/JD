<%--
  Created by IntelliJ IDEA.
  User: zeng
  Date: 19-7-4
  Time: 下午1:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        window.onload = function(){
            function autoclick(){
                var url = document.getElementById('btn').href;//获取要点击的a标签
                window.location.href= url;
            }

            setTimeout(autoclick, 1)
        }

    </script>
</head>
<body>
<a href="denglu" id="btn"></a>

</body>
</html>
