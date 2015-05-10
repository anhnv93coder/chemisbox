<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseURL" value="${pageContext.servletContext.contextPath}" />
<div class="col-md-3">
	<c:if test="${not empty forumModel.topQuestionList}">
		<div class="list-group">
		<a href="#" class="list-group-item list-group-item-info"><strong>Câu hỏi có lượt xem nhiều nhất</strong></a>
			<c:forEach items="${forumModel.topQuestionList}" var="topQuestion">		 
				<a href="${baseURL}/question/${topQuestion.questionId}" class="list-group-item">${topQuestion.title}</a>
			</c:forEach>
		</div>
	</c:if>
	<c:if test="${not empty forumModel.questionHaveNotAnswerList}">
		<div class="list-group">
		<a href="#" class="list-group-item list-group-item-warning"><strong>Câu hỏi chưa có câu trả lời</strong></a>
			<c:forEach items="${forumModel.questionHaveNotAnswerList}" var="questionHaveNotAnswer">		 
				<a href="${baseURL}/question/${questionHaveNotAnswer.questionId}" class="list-group-item">${questionHaveNotAnswer.title}</a>
			</c:forEach>
		</div>
	</c:if>
</div>