<%@ page import="com.grailsurfing.step1.FlyingObject" %>



<div class="fieldcontain ${hasErrors(bean: flyingObjectInstance, field: 'flyingTimeMin', 'error')} required">
	<label for="flyingTimeMin">
		<g:message code="flyingObject.flyingTimeMin.label" default="Flying Time Min" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="flyingTimeMin" type="number" min="0" value="${flyingObjectInstance.flyingTimeMin}" required=""/>
</div>

