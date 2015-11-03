<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="list-client-jobs">
	<h2></h2>
	<div class="row">
		<div class="col-xs-9">
			<div class="col-sm-12">			
				<div class="span2" style="float: right;">
					${job.jobName}
				</div>
			</div>
		</div>
		<div class="col-xs-3">
			<ul class="list-group">
				<li class="list-group-item">
					<span class="label label-default label-pill pull-left">14</span>
					<span class="label label-default label-pill pull-right">14</span> Cras justo odio
				</li>
				<li class="list-group-item">
					<span class="label label-default label-pill pull-left">14</span>
					<span class="label label-default label-pill pull-right">2</span> Dapibus ac facilisis in
				</li>
				<li class="list-group-item">
					<span class="label label-default label-pill pull-left">14</span>
					<span class="label label-default label-pill pull-right">1</span> Morbi leo risus
				</li>
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btn_post_jobs").click(function() {
			location.href = "view-post-job.htm";
		});

		$("#select_job_type").change(function() {
			location.href = "list-client-jobs.htm?jtype=" + $(this).val();
		});
	});
</script>