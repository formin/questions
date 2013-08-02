<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link href='http://fonts.googleapis.com/css?family=Oswald' rel='stylesheet' type='text/css'>
<link href="http://www.slipp.net/resources/stylesheets/slipp.css" rel="stylesheet">
<link rel="stylesheet" href="http://www.slipp.net/resources/stylesheets/highlight/github.css">
<link rel="stylesheet" href="http://www.slipp.net/resources/stylesheets/wiki-style.css">
<link rel="stylesheet" href="http://www.slipp.net/resources/stylesheets/wiki-textile-style.css">
	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SLiPP</title>

<%@ include file="../commons/_header.jspf" %>

</head>
<body>
<%@ include file="../commons/_top.jspf" %>
       
	
	<div class="content" >
		<div class="container">
			<div id="siteSearchArea" class="site-search-area"> 
			</div>
			 
			<section class="view-content">

				<h1 class="article-title">${Question.title }</h1>
				<div class="content-main">
					 
				<article class="article">
						<div class="article-header"> 
							<div class="article-header-text">
								<a href="/questions/${Question.idx }" class="article-author-name">${Question.userId }</a>
								<a href="/questions/${Question.idx }" class="article-header-time">
								${Question.insertdates }
								<i class="icon-link"></i>
								</a>	 
							</div> 
						</div>
						<div class="article-doc">
							<br />
							<p>${Question.contents }</p> 
						</div> 
								
		              <c:choose>
		              <c:when test="${Question.userId == loginUser.userId}">
		
							<div class="control-group">
								<div class="controls">
						<form id="question" class="form-write" action="/questions/questionupdateform" method="POST"> 
									<button type="submit" class="btn btn-primary">수정하기</button>
							<input type="hidden" name="idx" id="idx" value="${Question.idx }">
						</form>
						     
						<form id="question" class="form-write" action="/questions/questiondelete" method="POST">  
									<button type="submit" class="btn btn-primary">삭제하기</button> 
							<input type="hidden" name="idx" id="idx" value="${Question.idx }">
						</form>
								</div>
							</div>
						        
		              </c:when>
		              <c:otherwise>
		              		<div class="control-group">
								<div class="controls">
									글을등록한계정만수정가능합니다.
								</div>
							</div>           
		              </c:otherwise>
		              </c:choose>
		               
				</article>
				
				</div> 
		  
			</section>

		</div>
	</div>
	

</body>
</html>