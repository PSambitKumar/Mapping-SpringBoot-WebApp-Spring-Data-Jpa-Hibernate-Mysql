<%--
  Created by IntelliJ IDEA.
  User: sambit.pradhan
  Date: 9/4/2022
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" >
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <title>Add Programming Question</title>
</head>
<body style="margin: 2rem;">
<style>
    a{
        cursor: pointer;
    }
</style>
<h3>Add Programming Question</h3>
<div class="card text-center" style="margin-right: 5rem; margin-left: 5rem;">
    <div class="card-header">
        <ul class="nav nav-tabs card-header-tabs">
            <li class="nav-item"><a class="nav-link active" id="addId" onclick="openAdd()" <%--href="/add"--%>>Add Question</a></li>
            <li class="nav-item"><a class="nav-link" id="subId" onclick="openSubmit()" <%--href="/add"--%>>Submit Answer</a></li>
            <li class="nav-item"><a class="nav-link" id="viewId" onclick="openView()" <%--href="/view"--%>>View Q&A</a></li>
        </ul>
    </div>

    <div class="card-body">
        <div id="add">
            <form action="/addProgrammingQuestion" method="post" id="addProgrammingQuestionForm">
                <h3 class="card-title">Question Details</h3>
                <div class="form">

                    <div class="row g-3 m-4">

                        <div class="col-md-6 control-label">
                            <label for="programmingQuestionName" class="form-label control-label">Question</label>
                            <textarea name="programmingQuestionName" rows="5" class="form-control" id="programmingQuestionName" placeholder="Enter Question"></textarea>
                        </div>

                        <div class="col-md-4 control-label">
                            <label for="status" class="form-label control-label">Status</label>
                            <select name="status" id="status" class="form-control">
                                <option value="Active">Active</option>
                                <option value="Inactive">Inactive</option>
                            </select>
                        </div>

                        <div class="btnhold mt-3">
                            <button type="submit" class="btn btn-outline-primary mr-3">Submit</button>
                            <button type="reset" class="btn btn-outline-secondary">Reset</button>
                        </div>

                    </div>
                </div>
            </form>
        </div>

        <div id="sub">
            <form action="/submitProgrammingAnswer" method="post" id="submitProgrammingAnswerForm">
                <h3 class="card-title">Answer Details</h3>
                <div class="form">

                    <div class="row g-3 m-4">

                        <div class="col-md-4 control-label">
                            <label for="programmingQuestionNumber" class="form-label control-label">Question Number</label>
                            <select name="programmingQuestionNumber" id="programmingQuestionNumber" class="form-control" onchange="getQuestion(this.value)">
                                <option value="0" hidden>Select Question Number</option>
                                <c:forEach items="${programmingQuestionList}" var="programmingQuestion">
                                    <option value="${programmingQuestion.programmingQuestionId}">${programmingQuestion.programmingQuestionId}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="col-md-4 control-label">
                            <label for="programmingQuestionName" class="form-label control-label">Question</label>
                            <textarea name="programmingQuestionName" rows="5" class="form-control" id="programmingQuestionName1" placeholder="Enter Question"></textarea>
                        </div>

                        <div class="col-md-4 control-label">
                            <label for="status" class="form-label control-label">Status</label>
                            <select name="status" id="status1" class="form-control">
                                <option value="Active">Active</option>
                                <option value="Inactive">Inactive</option>
                            </select>
                        </div>

                        <div class="btnhold mt-3">
                            <button type="submit" class="btn btn-outline-primary mr-3">Submit</button>
                            <button type="reset" class="btn btn-outline-secondary">Reset</button>
                        </div>

                    </div>
                </div>
            </form>
        </div>


        <div id="view">
            <h3 class="card-title">Question Details</h3>
<%--            <table class="table table-bordered">--%>
<%--                <thead>--%>
<%--                <tr>--%>
<%--                    <th>Sl.No</th>--%>
<%--                    <th>Question</th>--%>
<%--                    <th>Staus</th>--%>
<%--                    <th>Action</th>--%>
<%--                </tr>--%>
<%--                </thead>--%>
<%--                <tbody>--%>
<%--                <c:forEach items="${departmentList}" var="department" varStatus="count">--%>
<%--                    <tr>--%>
<%--                        <td>${count.count}</td>--%>
<%--                        <td>${department.departmentName}</td>--%>
<%--                        <td>${department.status}</td>--%>
<%--                        <td>--%>
<%--                            <a href = "/edit/${department.departmentId}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen" viewBox="0 0 16 16"><path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001zm-.644.766a.5.5 0 0 0-.707 0L1.95 11.756l-.764 3.057 3.057-.764L14.44 3.854a.5.5 0 0 0 0-.708l-1.585-1.585z"/></svg></a>--%>
<%--                            |--%>
<%--                            <a href = "/delete/${department.departmentId}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16"><path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/><path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/></svg></a>--%>
<%--                        </td>--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--                </tbody>--%>
<%--            </table>--%>
        </div>
    </div>

    <a href="/"><button class="btn btn-primary">Home</button></a>
</div>

</body>

<script>

    $(document).ready(function (){
        $('#add').show();
        $('#view').hide();
        $('#sub').hide();
    });

    function openAdd(){
        $('#add').show();
        $('#view').hide();
        $('#sub').hide();

        $('#addId').addClass("active");
        $('#viewId').removeClass("active");
        $('#subId').removeClass("active");
    }
    function openView(){
        $('#view').show();
        $('#add').hide();
        $('#sub').hide();

        $('#addId').removeClass("active");
        $('#subId').removeClass("active");
        $('#viewId').addClass("active");
    }

    function openSubmit() {
        $('#view').hide();
        $('#add').hide();
        $('#sub').show();

        $('#addId').removeClass("active");
        $('#subId').addClass("active");
        $('#viewId').removeClass("active");
    }

    function getQuestion(programmingQuestionId){
        $.ajax({
            url: "/getProgrammingQuestion",
            type: "GET",
            data: {
                programmingQuestionId: programmingQuestionId
            },
            success: function (data) {
                console.log(data);
                $('#question').val(data.question);
                $('#status1').val(data.status);
                $('#programmingQuestionId').val(data.programmingQuestionId);
            }
        });
    }

</script>
</html>
