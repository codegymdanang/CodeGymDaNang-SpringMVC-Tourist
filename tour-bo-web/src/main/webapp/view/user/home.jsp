
<section>
	<div class="row">
		<div class="col-md-12 well">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Firstname</th>
						<th>Lastname</th>
						<th>Email</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="person in people">
						<td>{{person.id}}</td>
						<td>{{person.firstName}}</td>
						<td>{{person.lastName}}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</section>
