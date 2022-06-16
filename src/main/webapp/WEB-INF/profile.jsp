<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 6/13/2022
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- for validations -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
    <!-- YOUR own local CSS -->
    <link rel="stylesheet" href="/css/style.css"/>
    <!-- For any Bootstrap that uses JS or jQuery-->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/script.js"></script>

    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <div class="container">
        <h1># ${ player.jerseyNumber } | ${ player.firstName} ${player.lastName }</h1>
        <p>Team: ${player.team.teamName}</p>
        <p>Position: ${ player.position }</p>
        <p>Hits: ${ player.hittingHand }</p>
        <p>Throws: ${player.throwingHand}</p>
    </div>
</body>
</html>
