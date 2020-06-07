<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:maintemplate>
    <jsp:attribute name="scripts">
        <script>
            $(document).ready(function() {
                setTimeout(function () {
                    $('#result-alert').hide();
                }, 5000)
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h2>User profile</h2>
        <c:if test="${param.success}">
            <div class="alert alert-success" role="alert" id="result-alert">
                Profile updated successfully!
            </div>
        </c:if>
        <div class="row mt-5">
            <div class="col-6">
                <form:form class="user" action="/profile" method="post" modelAttribute="user">
                    <form:input type="hidden" path="username" />
                    <div class="form-group row">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                            <label>First Name</label>
                            <form:input type="text" class="form-control form-control-user" path="firstName" placeholder="First Name" />
                            <form:errors path="firstName" cssClass="text-danger" />
                        </div>
                        <div class="col-sm-6">
                            <label>Last Name</label>
                            <form:input type="text" class="form-control form-control-user" path="lastName" placeholder="Last Name" />
                            <form:errors path="lastName" cssClass="text-danger" />
                        </div>
                    </div>
                    <div class="row mb-3">
                        <div class="col-12 text-center">Compile the following fields if you want to change your password</div>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-6 mb-3 mb-sm-0">
                            <form:input type="password" class="form-control form-control-user" path="password" placeholder="Password" />
                            <form:errors path="password" cssClass="text-danger" />
                        </div>
                        <div class="col-sm-6">
                            <form:input type="password" class="form-control form-control-user" path="confirmPassword" placeholder="Repeat Password" />
                            <form:errors path="confirmPassword" cssClass="text-danger" />
                        </div>
                    </div>
                    <div class="row mt-5">
                        <div class="col-12">
                            <button class="btn btn-primary">Update info</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </jsp:body>
</t:maintemplate>