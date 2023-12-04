<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!doctype html>
<html lang="ko">
<head>
  <meta charset="utf-8">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

  <title>Blog</title>

  <style>
    .bd-placeholder-img {
      font-size: 1.125rem;
      text-anchor: middle;
      -webkit-user-select: none;
      -moz-user-select: none;
      user-select: none;
    }

    @media (min-width: 768px) {
      .bd-placeholder-img-lg {
        font-size: 3.5rem;
      }
    }

    .blog-header {
      line-height: 1;
      border-bottom: 1px solid #e5e5e5;
    }

    .blog-header-logo {
      font-family: "Playfair Display", Georgia, "Times New Roman", serif/*rtl:Amiri, Georgia, "Times New Roman", serif*/;
      font-size: 2.25rem;
    }

    .blog-header-logo:hover {
      text-decoration: none;
    }

    h1, h2, h3, h4, h5, h6 {
      font-family: "Playfair Display", Georgia, "Times New Roman", serif;
    }

    .display-4 {
      font-size: 2.5rem;
    }
    @media (min-width: 768px) {
      .display-4 {
        font-size: 3rem;
      }
      
    }

    .nav-scroller {
      position: relative;
      z-index: 2;
      height: 2.75rem;
      overflow-y: hidden;
    }

    .nav-scroller .nav {
      display: flex;
      flex-wrap: nowrap;
      padding-bottom: 1rem;
      margin-top: -1px;
      overflow-x: auto;
      text-align: center;
      white-space: nowrap;
      -webkit-overflow-scrolling: touch;
    }

    .nav-scroller .nav-link {
      padding-top: .75rem;
      padding-bottom: .75rem;
      font-size: .875rem;
    }

    .card-img-right {
      height: 100%;
      border-radius: 0 3px 3px 0;
    }

    .flex-auto {
      flex: 0 0 auto;
    }

    .h-250 { height: 250px; }
    @media (min-width: 768px) {
      .h-md-250 { height: 250px; }
    }

    /* Pagination */
    .blog-pagination {
      margin-bottom: 4rem;
    }
    .blog-pagination > .btn {
      border-radius: 2rem;
    }

    /*
    * Blog posts
    */
    .blog-post {
      margin-bottom: 4rem;
    }
    .blog-post-title {
      margin-bottom: .25rem;
      font-size: 2.5rem;
    }
    .blog-post-meta {
      margin-bottom: 1.25rem;
      color: #727272;
    }

    .nav-underline .nav-link {
      padding-top: .75rem;
      padding-bottom: .75rem;
      font-size: .875rem;
      color: #6c757d;
    }

    .nav-underline .nav-link:hover {
      color: #007bff;
    }

    .nav-underline .active {
      font-weight: 500;
      color: #343a40;
    }

    .bg-color {
      background-color: #778899;
    }
    
    .pointer {
       cursor: pointer;
     }

  </style>

</head>
<body class="bg-light" style="overflow-x: hidden;">
    
<div class="container">
  <header class="blog-header py-3">
    <div class="row flex-nowrap justify-content-between align-items-center">
      <div class="col-4 pt-1">
        <a>by Seoyoon Lee</a>
      </div>
      <div class="col-4 text-center">
        <a class="blog-header-logo text-dark" href="getBlogList.do">Blog</a>
      </div>

      <form class="d-flex" action="searchBlogList.do" method="post">
		  <div class="col-4 d-flex justify-content-end align-items-center">
		      <div class="btn-toolbar mb-2 mb-md-0 col-3">
				<select name="searchCon" class="form-select form-select-sm me-2">
					<option value="title" > title </option>
					<option value="content" > content </option> 
				</select>	
		      </div>
		      <input name="searchKey" class="form-control form-control-sm me-2" type="search" placeholder="Search" aria-label="Search">
		      <button type="submit" class="btn btn-sm btn-outline-secondary me-3">Search</button>
		  </div>
		</form>
    </div>
  </header>
</div>

<main class="container">
  <div class="p-4 p-md-5 mb-4 text-white rounded bg-dark">
    <div class="col-md-6 px-0">
      <h1 class="display-4 fst-italic">Welcome to my Blog</h1>
      <p class="lead my-3">
        일상의 작은 감동과 아름다움을 담은 블로그, 사소한 순간부터 시작하는 나만의 행복 여정을 함께하며 나의 일상을 되돌아보세요.
      </p>
    </div>
  </div>

 

  <div class="row align-items-md-stretch">
    <div class="col-md-6">
      <div class="h-100 p-5 text-white bg-dark rounded-3">
        <h2>About This WebSite</h2>
        <p>매일의 일상과 감정을 간단하게 기록해 보는 것은 어떨까요? 사소한 순간이라도 기억하고 싶은 것을 적으며, 일상의 소중한 순간을 간직해보세요. 이 블로그는 일상의 작은 아름다움을 발견하고 나누는 나만을 위한 공간입니다.</p>
        <button class="btn btn-outline-light" type="button" onclick="location.href='insertBlog.do'">Add New Post</button>
      </div>
    </div>
    <div class="col-md-6">
      <div class="h-100 p-5 bg-light border rounded-3">
        <h2>Using Before Tip!</h2>
        <p>게시글 오른쪽 맨 아래에 보시면 게시글을 추가할 수 있습니다. 각 게시글의 오른쪽에 View 버튼을 누르면 게시글을 수정, 삭제 할 수 있습니다. 블로그의 상단 오른쪽에 있는 검색을 통해 제목/내용을 카테고리에 맞게 검색 할 수 있습니다. 검색 후 검색 결과는 아래 하단에 나옵니다. 초기화를 원하신다면 상단 로고를 클릭해주세요.</p>
      </div>
    </div>
  </div>


  <div class="d-flex align-items-center p-3 my-3 text-white bg-color rounded shadow-sm">
    <div class="lh-1">
      <h1 class="h6 mb-0 text-white lh-1">All Post List</h1>
      <small>Last Update 2023.11.08</small>
    </div>
  </div>

  <div class="my-3 p-3 bg-body rounded shadow-sm">
  <div class="d-flex justify-content-between border-bottom">
  	<h6>All Post</h6>
  </div>
  <c:forEach var="blog" items="${bList}" varStatus="loop">
  <div class="d-flex text-muted pt-3">
  	    <svg class="bd-placeholder-img flex-shrink-0 me-2 rounded" width="32" height="32" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 32x32" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="${blog.color}"/><text x="50%" y="50%" fill="${blog.color}" dy=".3em">32x32</text></svg>
    <div class="pb-3 mb-0 small lh-sm border-bottom w-100">
      <div class="d-flex justify-content-between">
        <strong class="text-gray-dark">${blog.title}</strong>
       	<a class="pointer" value="${blog.seq}" data-bs-toggle="modal" data-bs-target="#exampleModal${loop.index}">View</a>      
		  	<div class="modal fade" value="${blog.seq}" id="exampleModal${loop.index}" tabindex="-1" aria-labelledby="exampleModalLabel${loop.index}" aria-hidden="true">
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			      <div class="modal-header">
			        <strong class="text-gray-dark" style="font-size: 1.5em;" id="exampleModalLabel${loop.index}">${blog.title}</strong>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        ${blog.content}
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-outline-primary" onclick="location.href='modifyBlog.do?seq=${blog.seq}'">Edit</button>
			        <button type="button" class="btn btn-outline-danger" onclick="location.href='deleteBlog.do?seq=${blog.seq}'">Delete</button>
			      </div>
			    </div>
			  </div>
			</div>
      </div>
      <span class="d-block">${blog.content}</span>
    </div>
  </div>
  </c:forEach>
  
  <small class="d-block text-end mt-3">
    <a href="insertBlog.do">Add Post</a>
  </small>
</div>

</main>

<footer class="text-muted py-3">
  <div class="container">
    <p class="float-end mb-4">
      <a href="#">Back to top</a>
    </p>
  </div>
</footer>

  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
  
  </body>
</html>