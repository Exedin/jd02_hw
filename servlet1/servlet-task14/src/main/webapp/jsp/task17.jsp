<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<ul>
<c:forEach items="${expenses}" var="expense">
    <li><c:out value="num=${expense.num} paydate=${expense.paydate} receiver=${expense.receiver} value=${expense.value}"/></li>
</c:forEach>
</ul>

