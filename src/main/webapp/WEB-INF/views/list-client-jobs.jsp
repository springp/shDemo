<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="list-client-jobs">
	<h2></h2>
	<div class="row">
		<div class="col-sm-12">
			<div class="span2" style="float: left;">
				Posted Jobs
			</div>
			<div class="span2" style="float: right;">
				<button type="submit" class="btn btn-primary" style="width: 100%;" id="btn_post_jobs">Post</button>
			</div>
		</div>
		<div class="col-sm-12">
			<div class="span3" style="float: left; margin-left: 0;">
				<div class="form-inline">
					<select class="form-control" id="select_job_type" style="width: 50%;">
						<option value="ALL">All</option>
						<option value="OPEN">Open</option>
						<option value="CLESED">Closed</option>
					</select>
				</div>
			</div>
		</div>
		<div class="col-sm-12" style="margin-top: 25px;"></div>
		<div class="col-xs-12">
			<div class="table-responsive">
				<table class="table">
					<thead>
						<tr>
							<th>Jobs</th>
							<th>Status</th>
							<th>Date Posted</th>
							<th>Posted By</th>
							<th>Hires</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${jobs}" var="job">
							<tr>
								<td><a href="job-details.htm?jobId=${job.jobUUID}">${job.jobName}</a></td>
								<td>${job.jobStatus}</td>
								<td>${job.createdDate}</td>
								<td>${job.client.firstName} ${job.client.lastName}</td>
								<td></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btn_post_jobs").click(function() {
			location.href = "view-post-job.htm";
		});
		
		$("#select_job_type").change(function() {
			location.href = "list-client-jobs.htm?jtype="+ $(this).val();
		});
	});
</script>