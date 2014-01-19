<%@ page import="com.grailsurfing.step1.Vehicle" %>



<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'seatsNb', 'error')} required">
    <label for="seatsNb">
        <g:message code="vehicle.seatsNb.label" default="Seats Nb"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field name="seatsNb" type="number" min="1" value="${vehicleInstance.seatsNb}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: vehicleInstance, field: 'vehicleName', 'error')} ">
    <label for="vehicleName">
        <g:message code="vehicle.vehicleName.label" default="Vehicle Name"/>

    </label>
    <g:textField name="vehicleName" maxlength="100" value="${vehicleInstance?.vehicleName}"/>
</div>

