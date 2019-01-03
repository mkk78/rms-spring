<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>

<main class="mdl-layout__content">
		<div class="mdl-grid">
		<div class="mdl-card mdl-shadow--6dp">
			<div class="mdl-card__title mdl-color--primary mdl-color-text--white">
				<h2 class="mdl-card__title-text">Acme Co.</h2>
			</div>
			<div class="mdl-card__supporting-text">
				<form:form modelAttribute="user" method="post" id="form1">
					<form:hidden path="id" />
					<div class="mdl-textfield mdl-js-textfield">
						<form:input class="mdl-textfield__input" path="userName" /> 
						<form:label	class="mdl-textfield__label" path="userName">Username</form:label>
						<form:errors path="userName" cssClass="text-warning" />
					</div>
					<div class="mdl-textfield mdl-js-textfield">
						<form:password class="mdl-textfield__input" path="password" /> 
						<form:label	class="mdl-textfield__label" path="password">Password</form:label>
						<form:errors path="password" cssClass="text-warning" />
					</div>
				</form:form>
			</div>
			<div class="mdl-card__actions mdl-card--border">
				<button
					class="mdl-button mdl-button--colored mdl-js-button mdl-button--raised"
					type="submit" form="form1">Save</button>
					<a onclick="history.back()"><button
							class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect">Back</button></a>
			</div>
		</div>
		</div>
		</main>

<%@ include file="../common/footer.jspf" %>