<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<main class="mdl-layout__content">
<div class="mdl-grid">
Welcome ${loggedinUser.userName} !!! <br />
<a href="/list">Click Here</a> &nbsp to manage your todo list
<br />
<a href="/logout">Logout</a>
</div>
</main>

<%@ include file="common/footer.jspf" %>