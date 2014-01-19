<%@ page import="com.grailsurfing.step1.Concorde" %>



<div class="fieldcontain ${hasErrors(bean: concordeInstance, field: 'flyingTimeMin', 'error')} required">
    <label for="flyingTimeMin">
        <g:message code="concorde.flyingTimeMin.label" default="Flying Time Min"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field name="flyingTimeMin" type="number" min="0" value="${concordeInstance.flyingTimeMin}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: concordeInstance, field: 'currentPassengerNb', 'error')} required">
    <label for="currentPassengerNb">
        <g:message code="concorde.currentPassengerNb.label" default="Current Passenger Nb"/>
        <span class="required-indicator">*</span>
    </label>
    <g:field name="currentPassengerNb" type="number" min="0" max="200" value="${concordeInstance.currentPassengerNb}"
             required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: concordeInstance, field: 'vehicle', 'error')} ">
    <label for="vehicle">
        <g:message code="concorde.vehicle.label" default="Vehicle"/>

    </label>
    <g:select id="vehicle" name="vehicle.id" from="${com.grailsurfing.step1.Vehicle.list()}" optionKey="id"
              value="${concordeInstance?.vehicle?.id}" class="many-to-one" noSelection="['null': '']"/>
</div>

