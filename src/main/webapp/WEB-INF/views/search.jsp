<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="login">
	<h2>Search</h2>
	<div class="row">
		<div class="col-xs-3">
			<div class="search_filter">
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Category</a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<p>
									<input type="checkbox" name="chk_java" id="chk_java" onchange="window.location='${requestScope['javax.servlet.forward.request_uri']}search-jobs/'"/>
									<label>Java1</label>
								</p>
								<p>
									<input type="checkbox" name="chk_net" id="chk_net" onchange="window.location='./search-jobs/3'"/>
									<label>.Net</label>
								</p>
							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion"
									href="#collapseTwo">2. What is Bootstrap?</a>
							</h4>
						</div>
						<div id="collapseTwo" class="panel-collapse collapse">
							<div class="panel-body">
								<p>
									Bootstrap is a powerful front-end framework for faster and
									easier web development. It is a collection of CSS and HTML
									conventions. <a href="http://www.tutorialrepublic.com/twitter-bootstrap-tutorial/" target="_blank">Learn more.</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-9">
				<div class="form-inline" style="margin-top: 20px;">
					   <div class="form-group" style="width: 40%;">
						    <label for="txt_search_job" style="width: 18%;">Search</label>
						    <input type="text" class="form-control" id="txt_search_job" placeholder="Search" style="width: 80%;"/>
					  </div>
					  <button type="submit" class="btn btn-success">Search</button>
				</div>
		</div>
	</div>
	<!-- 1 -->
</div>
