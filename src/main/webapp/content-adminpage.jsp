<%@include file="taglib.jsp"%>
<script type="text/javascript" class="init" src="Javascript/adminDelete.js"></script>

<div class="container-fluid">
    <br><br><br>

    <div class="row">
        <div class="col-md-5">
            <h2>Admin Account Delete</h2>
            <br>
        </div>
    </div>

    <div class="row">

        <table id="userTable" class="display" cellspacing="0" width="100%">
            <thead>
            <th>User ID</th>
            <th></th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Movie Count</th>
            <th>Bio</th>
            <th></th>
            </thead>

            <tbody>
            <c:forEach var="current" items="${users}">
                <tr>
                    <td>${current.userName}</td>
                    <c:choose>
                        <c:when test="${empty current.userPicture}">
                            <td><img src="Images/noimagesm.png" class="img-responsive"></td>
                        </c:when>
                        <c:otherwise>
                            <td><img src="${current.userPicture}" width=185 height=150 class="img-responsive"></td>
                        </c:otherwise>
                    </c:choose>
                    <td>${current.firstName}</td>
                    <td>${current.lastName}</td>
                    <td>${current.movieCount}</td>
                    <td>${current.userBio}</td>
                    <td><button type="button" id="${current.userName}" class="btnfriend btn btn-xs btn-danger"><span class="glyphicon glyphicon-minus"></span></button></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <c:import url="Modals/adminDeleteModal.jsp" />

</div> <!-- End Container -->

