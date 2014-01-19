<%@ page import="com.grailsurfing.step1.Eagle" %>



<div class="fieldcontain ${hasErrors(bean: eagleInstance, field: 'flyingTimeMin', 'error')} required">
    <label for="flyingTimeMin">
        <g:message code="eagle.flyingTimeMin.label" default="Flying Time Min"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field name="flyingTimeMin" type="number" min="0" value="${eagleInstance.flyingTimeMin}" required=""/>
</div>

