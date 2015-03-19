<%@ taglib prefix="authz"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Provider Index</title>
</head>
<body>
    <h1>Provider index page</h1> </br>

    <authz:authorize ifAllGranted="ROLE_USER">
        <div class="form-horizontal">
            <form action="<c:url value="/logout"/>" role="form" method="post">
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
                <button class="btn btn-primary" type="submit">Logout</button>
            </form>
        </div>

        <h2><a href="<c:url value="/resource"/>">resource</a></h2>

    </authz:authorize>
</body>
</html>
