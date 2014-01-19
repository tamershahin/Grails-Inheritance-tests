<%@ page import="com.grailsurfing.step1.Vehicle" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'vehicle.label', default: 'Vehicle')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-vehicle" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                              default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-vehicle" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list vehicle">

        <g:if test="${vehicleInstance?.seatsNb}">
            <li class="fieldcontain">
                <span id="seatsNb-label" class="property-label"><g:message code="vehicle.seatsNb.label"
                                                                           default="Seats Nb"/></span>

                <span class="property-value" aria-labelledby="seatsNb-label"><g:fieldValue bean="${vehicleInstance}"
                                                                                           field="seatsNb"/></span>

            </li>
        </g:if>

        <g:if test="${vehicleInstance?.vehicleName}">
            <li class="fieldcontain">
                <span id="vehicleName-label" class="property-label"><g:message code="vehicle.vehicleName.label"
                                                                               default="Vehicle Name"/></span>

                <span class="property-value" aria-labelledby="vehicleName-label"><g:fieldValue bean="${vehicleInstance}"
                                                                                               field="vehicleName"/></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: vehicleInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${vehicleInstance}"><g:message code="default.button.edit.label"
                                                                                        default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
