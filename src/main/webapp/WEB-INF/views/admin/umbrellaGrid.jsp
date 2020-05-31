<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags/" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:maintemplate>
    <jsp:attribute name="scripts">
        <script>
            function addUmbrella() {
                var form = document.getElementById('addUmbrellaForm');
                var dataObj = Object.fromEntries(new FormData(form));
                var data = JSON.stringify(dataObj);

                $.ajax({

                    url : '/admin/addUmbrella',
                    type : 'POST',
                    data : data,
                    dataType:'html',
                    contentType: 'application/json',
                    success : function(dataRecived) {              
                        var row = $('#umbrella-grid-row-' + dataObj.gridRow);
                        if(row.length> 0) {
                            row.append(dataRecived)
                        }
                        else {
                            var rowElement = '<tr id="umbrella-grid-row-' + dataObj.gridRow + '">' + dataRecived + '</tr>';
                            $('#umbrella-grid-table').append(rowElement);
                        }

                        form.reset();

                        $('#addUmbrellaModal').modal('toggle');
                    },
                    error : function(request,error)
                    {
                        console.log("error", error);
                    }
                });
            }
        </script>
    </jsp:attribute>
    <jsp:body>
        <button class="btn btn-primary" data-toggle="modal" data-target="#addUmbrellaModal">Add umbrella</button>
        <table class="table table-bordered mt-5" id="umbrella-grid-table">
            <c:forEach items="${grid}" var="row">
                <tr id="umbrella-grid-row-${row.getKey()}">
                    <c:forEach items="${row.getValue()}" var="column">
                        <c:set var="column" value="${column}" scope="request"/>
                        <c:import url="../fragments/grid/gridTd.jsp"/>
                    </c:forEach>
                </tr>    
            </c:forEach>
        </table>

        <!-- Add umbrella modal -->
        <div class="modal fade" id="addUmbrellaModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">Add umbrella</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="addUmbrellaForm">
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label>Row</label>
                                    <input class="form-control" type="number" name="gridRow" />
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label>Column</label>
                                    <input class="form-control" type="number" name="gridColumn" />
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label>Capacity</label>
                                    <input class="form-control" type="number" name="capacity" />
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label>Price</label>
                                    <input class="form-control" type="number" name="price" />
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" onclick="addUmbrella()">Save changes</button>
                </div>
                </div>
            </div>
        </div>
    </jsp:body>
</t:maintemplate>