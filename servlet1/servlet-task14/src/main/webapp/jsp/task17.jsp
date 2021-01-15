<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
    <meta charset="UTF-8">
    <title>Task17 jsp</title>
</head>
<ul>
<c:forEach items="${expenses}" var="expense">
    <li><c:out value="num=${expense.num} paydate=${expense.paydate} receiver=${expense.receiver} value=${expense.value}"/></li>
</c:forEach>
</ul>

