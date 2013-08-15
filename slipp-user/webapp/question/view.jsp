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

				<h1 class="article-title">${qestion.title }</h1>
				<div class="content-main">
					 
				<article class="article">
						<div class="article-header"> 
							<div class="article-header-text">
								<a href="/questions/${qestion.idx }" class="article-author-name">${qestion.userId }</a>
								<a href="/questions/${qestion.idx }" class="article-header-time">
								${qestion.insertdates }
								<i class="icon-link"></i>
								</a>	 
							</div> 
						</div>
						<div class="article-doc">
							<br />
							<p>${qestion.contents }</p> 
						</div> 
								
		              <c:choose>
		              <c:when test="${qestion.userId == loginUser.userId}">
		
							<div class="control-group">
								<div class="controls"> 
								
								<form id="question" class="form-write" action="/questions/questionupdateform" method="POST"> 
									<button type="submit" class="btn btn-primary">수정하기</button>
									<input type="hidden" name="idx" id="idx" value="${qestion.idx }">
								</form>
						     
								<form id="question" class="form-write" action="/questions/questiondelete" method="POST">  
									<button type="submit" class="btn btn-primary">삭제하기</button> 
									<input type="hidden" name="idx" id="idx" value="${qestion.idx }">
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
				
				<c:if test="${empty list}">
				<li>
					<div class="wrap">
						<div class="main">
							<strong class="subject">
								등록 된 의견이 없습니다.
							</strong>  
						</div>
					</div>
				</li>
				</c:if>
				
				<!--  반복 구간 시작 -->
				<c:forEach var="list" items="${list }" varStatus="status">	
			
					<div class="qna-comment">
						
							<article class="article" id="answer-770">
								
								<div class="article-header">
									<div class="article-header-thumb">
										<img src='//www.gravatar.com/avatar/e37ae9de87ccaf948d470073ca4b8da7' class="article-author-thumb" alt="" />
									</div>
									<div class="article-header-text">
										<a href="/users/247/오실장" class="article-author-name">${list.userId }</a>
										<a href="#answer-770" class="article-header-time" title="퍼머링크">
											${list.insertdates }
											<i class="icon-link"></i>
										</a>
									</div>
								</div> 
								<div class="article-doc comment-doc">
									<p>${list.contents }</p>
								</div>
								<div class="article-util">
									<ul class="list-util">
										
										
										<li>
											<button type="button" class="link-answer-article" data-answer-id="770" data-answer-user-id="@${list.userId }"></button>
										</li>
										
									</ul>
								</div>
							</article>
							
					 </div>
							
				</c:forEach>
				<!--  반복 구간 끝 -->
				
				
              <c:choose>
              <c:when test="${empty loginUser}">
              				<fieldset>
								<legend class="submit-write">의견추가는 로그인 후 가능합니다.</legend> 
							</fieldset>   
              </c:when>
              <c:otherwise>
              				   
						<form id="answer" class="form-write" action="/questions/${qestion.idx }/answers" method="POST">
							<fieldset>
								<legend class="submit-write">의견 추가하기</legend>
								<div class="submit-write">
									<textarea id="contents" name="contents" rows="15" cols="80"></textarea>
								</div>
								<div class="submit-write">	
									<button type="submit" class="btn-submit"><i class="icon-submit"></i> 작성완료</button>
								</div>
							</fieldset>
						</form>
						    
              </c:otherwise>
              </c:choose>
              
					
				</div> 
		  
		  
		  
					  
					  
				<div class="content-sub">
					<div class="floating">
						 
						<section class="qna-tags">
							<h1>연관태그</h1>
							<ul>
											
								<c:if test="${empty taglist}"> 
								<li>
									<a href="/questions/tagged/tdd" class="tag">등록 된 태그가 없습니다.</a>
								</li> 
								</c:if>
								
												
								<!--  반복 구간 시작 -->
								<c:forEach var="taglist" items="${taglist }" varStatus="status"> 
								<li>
									<a href="/questions/tagged/tdd" class="tag">${taglist.contents }</a>
								</li> 
								</c:forEach>
								<!--  반복 구간 끝 -->
								
							</ul>
						</section> 
					</div>
				</div>
				
				
				
			</section>

		</div>
	</div>
	

</body>
</html>