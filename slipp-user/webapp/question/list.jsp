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
								  
									<c:if test="${empty list}">
									<li>
										<div class="wrap">
											<div class="main">
												<strong class="subject">
													등록 된 글이 없습니다.
												</strong>  
											</div>
										</div>
									</li>
									</c:if>
									
									<!--  반복 구간 시작 -->
									<c:forEach var="question" items="${list }" varStatus="status">	
									<li>
										<div class="wrap">
											<div class="main">
												<strong class="subject">
													<a href="/questions/${question.idx }">${question.title }</a>
												</strong>
												<!--  
												<div class="auth-info"> 
															<i class="icon-add-comment"></i>
															<span class="type">응답</span>
															<span class="time">
																1997-01-01
															</span>
															<a href="/users/65/fupfin" class="author">${question.userId }</a> 
												</div>
												<div class="reply" title="댓글">
													<i class="icon-reply"></i>
													<span class="point">6</span>
												</div>
												-->
											</div>
										</div>
									</li>
									</c:forEach>
									<!--  반복 구간 끝 -->
									
									
								</ul>
								
								<c:if test="${ not empty list}">
								<!--  
								<nav class="pager">
									<ul>
										<li class="active"><a href="/questions?page=1">1</a></li><li><a href="/questions?page=2">2</a></li><li><a href="/questions?page=3">3</a></li><li><a href="/questions?page=4">4</a></li><li><a href="/questions?page=5">5</a></li><li class="disabled"><a href="#">...</a></li><li><a href="/questions?page=11">11</a></li>
									</ul>
								</nav>
								-->
								</c:if>
									
							</section>
						</div>
						
						
						
						<div class="content-sub">
									
							<section class="qna-tags">
								<h1>태그목록</h1>
								<ul>
												
									<c:if test="${empty taglist}"> 
									<li>
										<a href="/questions/tagged/tdd" class="tag">등록 된 태그가 없습니다.</a>
									</li> 
									</c:if>
									 
												
									<!--  반복 구간 시작 -->
									<c:forEach var="taglistCnt" items="${taglist }" varStatus="status"> 
									<li>
										<a href="/questions/tagged/tdd" class="tag">${taglistCnt.contents }&nbsp;<span class="count">${taglistCnt.count }</span></a> 
									</li> 
									</c:forEach>
									<!--  반복 구간 끝 -->
									 
								</ul>
							</section>
					
						</div>
				
				
						
						
						
						</div>
	
						
     
				</div>
			</div>
			
			
			
				
				
		</div>
	</div>

</body>
</html>