<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="login">
	<h1>Home page</h1>
	<div class="row">
		<div class="col-xs-3">
			<div class="search_filter">
				<div class="panel-group" id="accordion">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" href="#collapseOne">Search : </a>
							</h4>
						</div>
						<div id="collapseOne" class="panel-collapse collapse in">
							<div class="panel-body">
								<p>
									<input type="checkbox" name="chk_java" id="chk_java" />
									<label>Java</label>
								</p>
								<p>
									<input type="checkbox" name="chk_net" id="chk_net" />
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
									conventions. <a
										href="http://www.tutorialrepublic.com/twitter-bootstrap-tutorial/"
										target="_blank">Learn more.</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-xs-6">
			<h3>Search Result: </h3>
		
		</div>
		<div class="col-xs-3">
			<h2>Bootstrap</h2>
			<p>Bootstrap is a powerful front-end framework for faster and
				easier web development. The Bootstrap tutorial section will help you
				learn the techniques of Bootstrap so that you can quickly create
				your own website.</p>
			<p>
				<a
					href="http://www.tutorialrepublic.com/twitter-bootstrap-tutorial/"
					target="_blank" class="btn btn-success">Learn More &raquo;</a>
			</p>
		</div>
	</div>
	<!--  -->
</div>
