<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="list-client-jobs">
	<h2></h2>
	<div class="row">
		<div class="col-xs-12">
			<a href="list-client-jobs.htm"><< Back to Job List</a>
		</div>
		<div class="col-xs-9">
			<c:forEach items="${contracts}" var="contract">
				<div class="col-sm-12">			
					<div class="col-sm-12 h3" style="float: left;">
						${contract.job.jobName}
					</div>
					<div class="col-sm-12" style="float: left;">
						${contract.job.jobStatus} - Posted on ${contract.job.createdDate}
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="col-xs-3">
			<ul class="list-group">
				<li class="list-group-item">
					<span class="label label-default label-pill pull-left">14</span>
					<span class="label label-default label-pill pull-right">14</span> 
					<span style="padding-left: 10px;">Cras justo odio</span>
				</li>
				<li class="list-group-item">
					<span class="label label-default label-pill pull-left">14</span>
					<span class="label label-default label-pill pull-right">2</span> 
					<span style="padding-left: 10px;">Cras justo odio</span>
				</li>
				<li class="list-group-item">
					<span class="label label-default label-pill pull-left">14</span>
					<span class="label label-default label-pill pull-right">1</span> 
					<span style="padding-left: 10px;">Cras justo odio</span>
				</li>
			</ul>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
	});
</script>