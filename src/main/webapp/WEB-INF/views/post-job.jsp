<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="list-client-jobs" ng-app="iBossJobPostApp">
	<h2></h2>
	<div class="col-xs-6" ng-controller="PostJobCtrlJS">	
		<form:form name="frm_post_job" modelAttribute="jobBO" action="post-job.htm" novalidate="novalidate" method="POST">
			<div class="form-horizontal" style="margin-top: 20px;">
				<div class="form-group" >
					<label for="txt_job_name" style="width: 18%;">Name</label> 
					<form:input type="text" class="form-control" id="txt_job_name" name="txt_job_name" placeholder="Name" path="jobName"/>
				</div>
				<div class="form-group"  >				
					<div class="form-inline" >
						<div class="col-xs-6" style="padding-left: 0 !important;">
							<div class="form-inline">
								<label for="txt_job_cat" style="width: 100%;">Category</label>
								<form:select class="form-control" id="txt_job_cat" style="width: 100%;" 
									ng-model="postjob.CatId"
									ng-change="getSubCategory()" path="categoryId">
								 	<form:option value="">Select Category.....</form:option>
									<c:forEach items="${jobCategories}" var="cat">
										<option value="${cat.id}">${cat.name}</option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<div class="col-xs-6">
							<div class="form-inline">
								<label for="txt_job_cat" style="width: 100%;">Sub category</label> 
								<select class="form-control" id="txt_job_subcat" style="width: 100%;"
									ng-model="postjob.SubCatId" 
									ng-options="x.id as x.subcategory for x in subcatetries track by x.id">
									<option value="">Select Sub category.....</option>
								</select>
							</div>
						</div>
					</div>
				</div>		
				<div class="form-group">
					<label for="txt_job_skills" style="width: 100%;">Skills</label> 
					<select id="txt_job_skills" style="width:350px;" class="form-control chosen-select" multiple data-placeholder="Choose a skills..." >
					</select>
				</div>	
				<div class="form-group">
					<label for="txt_job_description" style="width: 100%;">Description</label>
					<form:textarea class="form-control" rows="5" id="txt_job_description" ng-minlength="3" ng-maxlength="8" path="jobDescription"></form:textarea>
				</div>			
				<div class="form-group">
					<label for="txt_job_type" style="width: 18%;">Type</label> 
					<select class="form-control" id="txt_job_type">
						<option>Select Job Type.....</option>
					</select>
				</div>
				<div class="form-group">
					<label for="txt_job_budget" style="width: 100%;">Budget</label> 				
					<div class="input-group">
		                <span class="input-group-addon">$</span>
		                <form:input type="text" class="form-control" id="txt_job_budget" placeholder="Name" path="bugget"/>
		            </div>
				</div>
				<div class="form-group">
					<label for="txt_job_duration" style="width: 100%;">Duration</label> 
					<form:input type="text" class="form-control" id="txt_job_duration" placeholder="Name" path="jobDuration"/>
				</div>			
				<div class="form-group">
			        <div class="">
			            <button type="submit" class="btn btn-primary" >Login</button>
			        </div>		
			    </div>
			</div>
		</form:form>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
			$(".chosen-select").chosen({disable_search_threshold: 10, no_results_text:'Oops, nothing found!', width:"100%"});
			$('.chosen-choices input').autocomplete({
			  source: function( request, response ) {
				  if($.trim($("#txt_job_subcat").val()) !== "" && $.trim(request.term) !== "" &&  $.trim(request.term).length > 3){
				    var optValues = $.map($('#txt_job_skills option'), function(e) { 
			    		 return $(e).text().toUpperCase(); 
			    	});
				    $.ajax({
				      url: 'api/search_cat_skills?term=' + request.term + "&scId=" + $("#txt_job_subcat").val(),
				      dataType: "json",
				      beforeSend: function(){
				    	  $('ul.chosen-results').empty();				    	 
				    	  if ($.inArray($.trim(request.term).toUpperCase(), optValues) >= 0){
				    		  return false;
				    	  }
				   	  },
				      success: function( data ) {
				        response( $.map( data.result, function( item, index ) {
				        	if ($.inArray($.trim(item.skillName).toUpperCase(), optValues) < 0){
				        		$('#txt_job_skills').append($('<option>', {
					        	    value: item.id,
					        	    text: item.skillName
					        	}));
				        	}				        	
				            $("#txt_job_skills").trigger("chosen:updated");
				        }));
				      }
				    });
				  }
			  }
			});
	});
	
</script>
