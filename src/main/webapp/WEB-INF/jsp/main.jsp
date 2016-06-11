<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Анатолий
  Date: 09.06.2016
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hot News</title>
</head>
<body>

<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.11/css/jquery.dataTables.css">
<link rel="stylesheet" href="../../resources/css/bootstrap.min.css">

<script type="text/javascript" src="../../resources/js/jquery-2.2.3.min.js"></script>
<script type="text/javascript" src="../../resources/js/bootstrap.min.js"></script>
<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.11/js/jquery.dataTables.js"></script>
<script type="text/javascript" charset="utf-8" src="https://cdn.datatables.net/1.10.12/js/dataTables.bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../resources/css/responsive.bootstrap.min.css">
<script type="text/javascript" src="../../resources/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="../../resources/js/datatablesUtil.js"></script>
<script type="text/javascript" src="../../resources/js/NewsDatatable.js"></script>
<script type="text/javascript" src="../../resources/js/date.js"></script>


<div class="jumbotron">
  <div class="container">
    <br>

    <table id="newstable" class="table table-striped table-bordered">
      <thead>
      <tr>
        <th>ID</th>
        <th>Заголовок</th>
        <th>Опубликовано</th>
        <th>Категории</th>
        <th></th>
        <th></th>
        <th class="none"></th>
      </tr>
      </thead>
      <tfoot>
      <tr>
        <th></th>
        <th>Заголовок</th>
        <th></th>
        <th>Категории</th>
        <th></th>
        <th></th>
        <th class="none"></th>
      </tr>
      </tfoot>

    </table>

    <a class="btn btn-sm btn-info" onclick="add()">Добавить</a>
  </div>
</div>

<div class="modal fade" id="editRow">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h2 class="modal-title"></h2>
      </div>
      <div class="modal-body">
        <form:form class="form-horizontal" method="post" action="/ajax/save" id="detailsForm" modelAttribute="news">
          <form:input type="text" hidden="hidden" id="id" name="id" value="0" path="id"/>


          <div class="form-group">
            <label for="headline" class="control-label col-xs-3">Заголовок:</label>

            <div class="col-xs-9">
              <form:input type="text" class="form-control" id="headline" name="headline" placeholder="headline" path="headline"/>
            </div>
          </div>


          <div class="form-group">
            <label for="content" class="control-label col-xs-3">Содержание:</label>

            <div class="col-xs-9">
              <form:textarea class="form-control" id="content" name="content" placeholder="" path="content"/>
            </div>
          </div>

          <div class="form-group">

            <label for="catIDs" class="control-label col-xs-3">Категории:</label>
            <div class="col-xs-9">
              <form:select path="catIDs" multiple="true">
                <form:option value="1">Политика</form:option>
                <form:option value="2">Экономика</form:option>
                <form:option value="3">Спорт</form:option>
              </form:select>
            </div>
          </div>


          <div class="form-group">
            <div class="col-xs-offset-3 col-xs-9">
              <form:button type="submit" class="btn btn-primary">Save</form:button>
            </div>
          </div>
        </form:form>
      </div>
    </div>
  </div>
</div>
</body>

</html>
