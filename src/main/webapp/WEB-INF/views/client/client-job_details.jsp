<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="list-client-jobs">
	<h2></h2>
	<div class="row">
		<div class="col-xs-12">
			<a href="list-client-jobs.htm"><< Back to Job List</a>
		</div>
		<div class="col-xs-9">
			<div class="col-sm-12">
				<div class="col-sm-12 h3" style="float: left;">
					${job.jobName}
				</div>
				<div class="col-sm-12" style="float: left;">
					${job.jobStatus} - Posted on ${job.createdDate}
				</div>
			</div>
		</div>
		<div class="col-xs-3"></div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>