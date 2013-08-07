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
			        
			        <c:choose>
			        <c:when test="${empty Question.title}">
			          
						<h1 class="write-title">새 글 작성</h1>
					
			          </c:when>
			        <c:otherwise>
			          
						<h1 class="write-title">글 수정</h1>
					
			          </c:otherwise>
			        </c:choose>
			 
					<c:set var="forwardUrl" value="/questions/${loginUser.userId}/questioninsert" />
					<c:if test="${not empty Question.title}">
					<c:set var="forwardUrl" value="/questions/${loginUser.userId}/questionupdate" />
					</c:if>
					 
					<form id="question" class="form-write" action="${forwardUrl}" method="POST"> 
						<fieldset>
							<div class="box-input-line">
								<input id="title" name="title" class="inp-title" type="text" value="${Question.title}"/>
							</div>
							<div class="box-write">
								<textarea id="contents" name="contents" rows="15" cols="80">${Question.contents}</textarea>
							</div> 
							<div class="box-input-line">
								<input id="plaintags" name="plaintags" class="inp-tags" type="text" value="${Question.plaintags }" placeholder="태그 - 공백 또는 쉼표로 구분 ex) javajigi, slipp"/>
							</div>
							<div class="submit-write"> 
								<button type="submit" class="btn-submit"><i class="icon-submit"></i> 작성완료</button>
							</div>
							<input type="hidden" name="idx" id="idx" value="${Question.idx }">
						</fieldset>
					</form>
     
				</div>
			</div>
		</div>
	</div>

</body>
</html>