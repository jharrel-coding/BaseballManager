<%--
  Created by IntelliJ IDEA.
  User: jason
  Date: 6/13/2022
  Time: 11:56 AM
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
        <div>
            <form:form action="/players/create" method="post" modelAttribute="newPlayer">
                <div class="row">
                    <form:label path="jerseyNumber" class="form-label">Number</form:label>
                    <form:input path="jerseyNumber" class="form-control" type="number" value=""/>
                    <form:errors path="jerseyNumber" class="text-danger" />
                </div>

                <div class="row">
                    <form:label path="firstName" class="form-label">First Name</form:label>
                    <form:input path="firstName" class="form-control" type="text" />
                    <form:errors path="firstName" class="text-danger" />
                </div>

                <div class="row">
                    <form:label path="lastName" class="form-label">Last Name</form:label>
                    <form:input path="lastName" class="form-control" type="text" />
                    <form:errors path="lastName" class="text-danger" />
                </div>

                <div class="row input-group">

                    <form:label path="throwingHand" class="form-label">Throwing Hand</form:label>
                    <div class="input-group-text">
                        <form:radiobutton class="form-check-input" label="Left" path="throwingHand" value="yes" />
                    </div>

                    <div class="input-group-text">
                        <form:radiobutton class="form-check-input" label="right" path="throwingHand" value="no" />
                    </div>
                </div>

                <div class="row input-group">

                    <form:label path="hittingHand" class="form-label">Hitting Hand</form:label>
                    <div class="input-group-text">
                        <form:radiobutton class="form-check-input" label="Left" path="hittingHand" value="yes" />
                    </div>

                    <div class="input-group-text">
                        <form:radiobutton class="form-check-input" label="right" path="hittingHand" value="no" />
                    </div>
                </div>

                <div class="row input_group">
                    <form:select path="team">
                        <c:forEach var = "team" items="${allTeams}">
                            <option value="${ team.id }">${ team.teamName }</option>
                        </c:forEach>
                    </form:select>
                </div>

                <input class="btn btn-primary" type="submit" value="submit">
        </div>
            </form:form>
</body>
</html>
