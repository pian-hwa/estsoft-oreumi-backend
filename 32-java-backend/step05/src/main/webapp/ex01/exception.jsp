<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Exception Handling</title>
    <style>
        body {
            background-color: #171717;
            color: #eee;
        }

        #wrapper {
            display: flex;
            flex-direction: column;

            width: 580px;
            margin: 120px auto;
        }

        pre {
            padding: 16px;

            background-color: #cfcfcf;
            border-radius: 8px;

            color: #323232;
            font: normal .82rem / 1.6 "Consolas", "Liberation Mono", "Courier New", monospace;
        }
    </style>
</head>
<body>

<div id="wrapper">
    <h1>Oops! Something went wrong!</h1>

    <h2>exception.toString()</h2>
    <pre><%= exception.toString() %></pre>
</div>

</body>
</html>
