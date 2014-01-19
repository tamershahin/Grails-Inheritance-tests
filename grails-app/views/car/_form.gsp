<%@ page import="com.grailsurfing.step1.Car" %>



<div class="fieldcontain ${hasErrors(bean: carInstance, field: 'seatsNb', 'error')} required">
    <label for="seatsNb">
        <g:message code="car.seatsNb.label" default="Seats Nb"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field name="seatsNb" type="number" min="1" value="${carInstance.seatsNb}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: carInstance, field: 'vehicleName', 'error')} ">
    <label for="vehicleName">
        <g:message code="car.vehicleName.label" default="Vehicle Name"/>

    </label>
    <g:textField name="vehicleName" maxlength="100" value="${carInstance?.vehicleName}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: carInstance, field: 'brand', 'error')} ">
    <label for="brand">
        <g:message code="car.brand.label" default="Brand"/>

    </label>
    <g:textField name="brand" maxlength="100" value="${carInstance?.brand}"/>
</div>

