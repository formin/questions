<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SLiPP</title>

<%@ include file="../commons/_header.jspf" %>

</head>
<body>
<%@ include file="../commons/_top.jspf" %>
       
	<div class="container">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span6">
        
		<h1 class="write-title">새 글 작성</h1>
 
		<c:set var="forwardUrl" value="/users" />
		<c:if test="${not empty loginUser.userId}">
		<c:set var="forwardUrl" value="/users/${loginUser.userId}/questioninsert" />
		</c:if>
		 
		<form id="question" class="form-write" action="${forwardUrl}" method="POST"> 
			<fieldset>
				<div class="box-input-line">
					<input id="title" name="title" class="inp-title" placeholder="제목" type="text" value="test1"/>
				</div>
				<div class="box-write">
					<textarea id="contents" name="contents" rows="15" cols="80">test2</textarea>
				</div>
				<div class="box-input-line">
					<input id="plainTags" name="plainTags" class="inp-tags" placeholder="태그 - 공백 또는 쉼표로 구분 ex) javajigi, slipp" type="text" value=""/>
				</div>
				<div class="submit-write">
					
					<button type="submit" class="btn-submit"><i class="icon-submit"></i> 작성완료</button>
				</div>
			</fieldset>
		</form>
     
				</div>
			</div>
		</div>
	</div>

</body>
</html>