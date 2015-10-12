<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="page-container">
	<!-- BEGIN PAGE HEAD -->
	<div class="page-head">
		<div class="container">
			<!-- BEGIN PAGE TITLE -->
			<div class="page-title">
				<h1>
					Master Data <small>Master Data</small>
				</h1>
			</div>
			<!-- END PAGE TITLE -->
			<!-- BEGIN PAGE TOOLBAR -->
		</div>
	</div>
	<!-- END PAGE HEAD -->
	<!-- BEGIN PAGE CONTENT -->
	<div class="page-content">
		<div class="container">
			<!-- BEGIN SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<div class="modal fade" id="portlet-config" tabindex="-1"
				role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true"></button>
							<h4 class="modal-title">Modal title</h4>
						</div>
						<div class="modal-body">Widget settings form goes here</div>
						<div class="modal-footer">
							<button type="button" class="btn blue">Save changes</button>
							<button type="button" class="btn default" data-dismiss="modal">Close</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<!-- END SAMPLE PORTLET CONFIGURATION MODAL FORM-->
			<!-- BEGIN PAGE BREADCRUMB -->
			<ul class="page-breadcrumb breadcrumb">
				<li><a href="#">Home</a><i class="fa fa-circle"></i></li>
				<li><a href="#">Masters</a> <i class="fa fa-circle"></i></li>
				<li class="active">Add Route Details</li>
			</ul>
			<!-- END PAGE BREADCRUMB -->
			<!-- BEGIN PAGE CONTENT INNER -->
			<div class="row">
				<div class="col-md-12">
					<div
						class="tabbable tabbable-custom tabbable-noborder tabbable-reversed">
						<div class="tab-pane" id="tab_2">
							<div class="portlet box green">
								<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-gift"></i>Route Details
									</div>
									<div class="tools">
										<a href="javascript:;" class="collapse"> </a> <a
											href="#portlet-config" data-toggle="modal" class="config">
										</a> <a href="javascript:;" class="reload"> </a> <a
											href="javascript:;" class="remove"> </a>
									</div>
								</div>

								<!-- CompanyStart -->
								<div class="portlet box green">
									<div class="portlet-body form">
										<!-- BEGIN FORM-->
										<form:form action="saveContractCompRoute.htm" modelAttribute="companyRoute" class="form-horizontal">
										<form:hidden path="id" />
										<form:hidden path="delFlag" />
										<form:hidden path="compId" />
											<div class="form-body">
												<h3 class="form-section"></h3>
												<div class="row">
													<%-- <div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Comp id</label>
															<div class="col-md-9">
																<form:input type="text" path="compId" class="form-control"
																	placeholder="Route Type Detail."/> 
															</div>
														</div>
													</div> --%>
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">Start City</label>
															<div class="col-md-9">
																	<form:select path="startCityId" class="form-control">
																	<form:option value="0" label="Select One" />
																	<form:options class="form-control" itemValue="id" itemLabel="name"  items="${lCityStart}" />
																</form:select> 
															</div>
														</div>
													</div>
													<!--/span-->
													<!--/span-->
												</div>
												<!--/row-->
												<div class="row">
													<div class="col-md-6">
														<div class="form-group">
															<label class="control-label col-md-3">End City</label>
															<div class="col-md-9">
																<%-- <form:input type="text" path="endCityId" class="form-control"/> --%>
																<form:select path="endCityId" class="form-control">
																	<form:option value="0" label="Select One" />
																	<form:options class="form-control" itemValue="id" itemLabel="name" items="${lCityEnd}" />
																</form:select> 
															</div>
														</div>
													</div>
												</div>
												<!--/row-->
											<div class="form-actions right">
											<a href="getAllTransportDetails.htm">
												<button class="btn default" type="button">Cancel</button></a>
												<button class="btn blue" type="submit"><i class="fa fa-check"></i> Submit</button>
											</div>
											</div>
										</form:form>
										<!-- END FORM-->
									</div>
								</div>
								<!--companyEnd  -->
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- END PAGE CONTENT INNER -->
		</div>
	</div>
	<!-- END PAGE CONTENT -->
</div>


