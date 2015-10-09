<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="list-client-jobs">
	<h2></h2>
	<div class="col-xs-6">	
		<div class="form-horizontal" style="margin-top: 20px;">
			<div class="form-group">
				<label for="txt_job_name" style="width: 18%;">Name</label> 
				<input type="text" class="form-control" id="txt_job_name" placeholder="Name" />
			</div>
			<div class="form-group" ng-app="myApp" >				
				<div class="form-inline" ng-controller="JobCategoryCtrlJS">
					<div class="col-xs-6" style="padding-left: 0 !important;">
						<div class="form-inline">
							<label for="txt_job_cat" style="width: 100%;">Category</label>
							<select class="form-control" id="txt_job_cat" style="width: 100%;" 
								ng-model="jobcetegory.Name"
								ng-change="getSubCategory()">
							 	<option value="">Select Category.....</option>
								<c:forEach items="${jobCategories}" var="cat">
									<option>${cat.name}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="col-xs-6">
						<div class="form-inline">
							<label for="txt_job_cat" style="width: 100%;">Sub category</label> 
							<select class="form-control" id="txt_job_subcat" style="width: 100%;"
								ng-model="jobcetegory.SubCatName" 
								ng-options="x.id as x.subcategory for x in subcatetries track by x.id">
								<option>Select Sub category.....</option>
							</select>
						</div>
					</div>
				</div>
			</div>			
			<div class="form-group">
				<label for="txt_job_description" style="width: 18%;">Description</label>
				<textarea class="form-control" rows="5" id="txt_job_description"></textarea>
			</div>			
			<div class="form-group">
				<label for="txt_job_type" style="width: 18%;">Type</label> 
				<select class="form-control" id="txt_job_type">
					<option>Select Job Type.....</option>
				</select>
			</div>
			<div class="form-group">
				<label for="txt_job_budget" style="width: 18%;">Budget</label> 				
				<div class="input-group">
	                <span class="input-group-addon">$</span>
	                <input type="text" class="form-control" id="txt_job_budget" placeholder="Name" />
	            </div>
			</div>
			<div class="form-group">
				<label for="txt_job_duration" style="width: 18%;">Duration</label> 
				<input type="text" class="form-control" id="txt_job_duration" placeholder="Name" />
			</div>
			<div class="form-group">
				<label for="txt_job_skills" style="width: 18%;">Skills</label> 
				<input type="text" class="form-control" id="txt_job_skills" placeholder="Name" />
			</div>
			<div class="form-group">
		        <div class="">
		            <button type="submit" class="btn btn-primary">Login</button>
		        </div>		
		    </div>
		</div>
	</div>
</div>
