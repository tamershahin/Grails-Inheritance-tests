<%@ page import="com.grailsurfing.step1.Concorde" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'concorde.label', default: 'Concorde')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-concorde" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-concorde" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="seatsNb"
                              title="${message(code: 'concorde.seatsNb.label', default: 'Seats Nb')}"/>

            <g:sortableColumn property="vehicleName"
                              title="${message(code: 'concorde.vehicleName.label', default: 'Vehicle Name')}"/>

            <g:sortableColumn property="flyingTimeMin"
                              title="${message(code: 'concorde.flyingTimeMin.label', default: 'Flying Time Min')}"/>

            <g:sortableColumn property="currentPassengerNb"
                              title="${message(code: 'concorde.currentPassengerNb.label', default: 'Current Passenger Nb')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${concordeInstanceList}" status="i" var="concordeInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${concordeInstance.id}">${fieldValue(bean: concordeInstance, field: "seatsNb")}</g:link></td>

                <td>${fieldValue(bean: concordeInstance, field: "vehicleName")}</td>

                <td>${fieldValue(bean: concordeInstance, field: "flyingTimeMin")}</td>

                <td>${fieldValue(bean: concordeInstance, field: "currentPassengerNb")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${concordeInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>
