<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>

		<main class="mdl-layout__content">
		<div class="mdl-grid">
			<div class="mdl-card mdl-shadow--6dp mdl-cell mdl-cell--12-col">
				<div class="mdl-card__title mdl-color--primary mdl-color-text--white">
					<h2 class="mdl-card__title-text">User List</h2>
				</div>
				
				<table	class="mdl-data-table mdl-js-data-table mdl-shadow--2dp">
					<thead>
						<tr>
							<th class="mdl-data-table__cell--non-numeric">User Name</th>
							<th>Password</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${users}" var="user">
							<c:if test="${user.id != loggedinUser.id}">
							<tr>
								<td class="mdl-data-table__cell--non-numeric">${user.userName}</td>
								<td>${user.password}</td>
								<td><a href="update-user?id=${user.id}"
									class="mdl-button mdl-js-button mdl-button--raised mdl-button--colored">Edit</a></td>
								<td><a href="delete?id=${user.id }"
									class="mdl-button mdl-js-button mdl-button--raised mdl-button--accent">Delete</a></td>
							</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
				<div class="mdl-card__actions mdl-card--border">
					<a href="add-user" class="mdl-button mdl-js-button mdl-button--colored">Add User</a>
				</div>
				
			</div>
		</div>
		</main>

<%@ include file="../common/footer.jspf" %>
