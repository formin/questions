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
        
		<h1 class="write-title">글목록</h1>
 


<div class="list-content">
	<div class="content-main">
		<section class="qna-list">
		
		
			<ul class="list">
			 
				<!--  반복 구간 시작 -->
				<c:forEach var="article" items="${list}" varStatus="status">	
				<li>
					<div class="wrap">
						<div class="main">
							<strong class="subject">
								<a href="/questions/170">${question.title}</a>
							</strong> 
							<div class="auth-info"> 
										<i class="icon-add-comment"></i>
										<span class="type">응답</span>
										<span class="time">
											2013-07-30 10:30
										</span>
										<a href="/users/65/fupfin" class="author">fupfin</a> 
							</div>
							<div class="reply" title="댓글">
								<i class="icon-reply"></i>
								<span class="point">6</span>
							</div>
						</div>
					</div>
				</li>
				</c:forEach>
				<!--  반복 구간 끝 -->
				
				
			</ul>
			<nav class="pager">
				<ul>
					<li class="active"><a href="/questions?page=1">1</a></li><li><a href="/questions?page=2">2</a></li><li><a href="/questions?page=3">3</a></li><li><a href="/questions?page=4">4</a></li><li><a href="/questions?page=5">5</a></li><li class="disabled"><a href="#">...</a></li><li><a href="/questions?page=11">11</a></li>
				</ul>
			</nav>
		</section>
	</div>
	</div>
	
	
				
     
				</div>
			</div>
		</div>
	</div>

</body>
</html>