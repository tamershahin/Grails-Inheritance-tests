<%@ page import="com.grailsurfing.step1.Concorde" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'concorde.label', default: 'Concorde')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-concorde" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-concorde" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list concorde">

        <g:if test="${concordeInstance?.seatsNb}">
            <li class="fieldcontain">
                <span id="seatsNb-label" class="property-label"><g:message code="concorde.seatsNb.label"
                                                                           default="Seats Nb"/></span>

                <span class="property-value" aria-labelledby="seatsNb-label"><g:fieldValue bean="${concordeInstance}"
                                                                                           field="seatsNb"/></span>

            </li>
        </g:if>

        <g:if test="${concordeInstance?.vehicleName}">
            <li class="fieldcontain">
                <span id="vehicleName-label" class="property-label"><g:message code="concorde.vehicleName.label"
                                                                               default="Vehicle Name"/></span>

                <span class="property-value" aria-labelledby="vehicleName-label"><g:fieldValue
                        bean="${concordeInstance}" field="vehicleName"/></span>

            </li>
        </g:if>

        <g:if test="${concordeInstance?.flyingTimeMin}">
            <li class="fieldcontain">
                <span id="flyingTimeMin-label" class="property-label"><g:message code="concorde.flyingTimeMin.label"
                                                                                 default="Flying Time Min"/></span>

                <span class="property-value" aria-labelledby="flyingTimeMin-label"><g:fieldValue
                        bean="${concordeInstance}" field="flyingTimeMin"/></span>

            </li>
        </g:if>

        <g:if test="${concordeInstance?.currentPassengerNb}">
            <li class="fieldcontain">
                <span id="currentPassengerNb-label" class="property-label"><g:message
                        code="concorde.currentPassengerNb.label" default="Current Passenger Nb"/></span>

                <span class="property-value" aria-labelledby="currentPassengerNb-label"><g:fieldValue
                        bean="${concordeInstance}" field="currentPassengerNb"/></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: concordeInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${concordeInstance}"><g:message
                    code="default.button.edit.label" default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
