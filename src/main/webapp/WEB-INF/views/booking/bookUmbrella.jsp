<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>

<t:maintemplate>
    <jsp:attribute name="styles">
        <link href="/vendor/datetimepicker-master/build/jquery.datetimepicker.min.css"" rel="stylesheet" type="text/css"/>
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <script src="/vendor/datetimepicker-master/build/jquery.datetimepicker.full.min.js"></script>
        <script>
            $( function() {
                $( ".datetimepicker" ).datetimepicker({
                    allowTimes:[
                    '08:00', '13:00', '20:00' 
                    ]
                });
            });
        </script>
    </jsp:attribute>
    <jsp:body>
        <h2>Book umbrella</h2>

        <div class="row mt-5">
            <div class="col-4">
                <div class="form-group">
                    <label>From</label>
                    <input type="text" class="form-control datetimepicker" readonly="readonly">
                </div>
            </div>
            <div class="col-4">
                <div class="form-group">
                    <label>To</label>
                    <input type="text" class="form-control datetimepicker" readonly="readonly">
                </div>
            </div>
            <div class="col-4">
                <div class="form-group">
                    <label style="min-height: 17.23px;"></label>
                    <button class="btn btn-primary form-control">Find</button>
                </div>
            </div>
        </div>
    </jsp:body>
</t:maintemplate>