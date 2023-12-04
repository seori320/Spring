<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
  <head>
    <meta charset="utf-8">

    <title>Edit Post</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">

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
    
      .container {
        max-width: 960px;
      }
    </style>
  </head>
<body class="bg-light">
    
<div class="container">
  <main>
    <div class="py-5 text-center">
      <h2>Edit Post</h2>
      <p class="lead">이전에 작성한 이야기를 수정 해보세요. 그날의 하루에 다른 일이 더 있었나요? 혹은 완료한 일정, 과제 등이 있나요? 혹은 기억하고 싶었던 생각이 더 커졌나요? 그때의 기분을 색으로 기록 해두세요!
        <br>+) 색상을 미선택 하시면 이전에 저장한 색으로 저장됩니다.<br>선택 전 정말로 바꾸실건지 다시 한번 확인해주세요!
      </p>
    </div>

      <div>
        <h4 class="mb-3">Writing Form</h4>
        <form class="needs-validation" action="modifyBlogProc.do?seq=${blog.seq}" method="post" novalidate>
          <div class="row g-3">
            <div class="col-10">
              <label for="text" class="form-label">Title</label>
              <input type="text" class="form-control" name="title" value="${blog.title}" placeholder="Please enter title." required>
              <div class="invalid-feedback">
                Please enter a valid title updates.
              </div>
            </div>

            <div class="col-2">
              <label for="zip" class="form-label">Color <span class="text-muted">(Optional)</span></label>
              <input type="color" class="form-control" id="myBestColor" value="${blog.color}" name="color" style="height: 37px">
            </div>

            <div class="col-12">
              <label for="text" class="form-label">Content</label>
              <textarea type="text" class="form-control" style="height: 100px" name="content" placeholder="Please enter your story." required>${blog.content}</textarea>
              <div class="invalid-feedback">
                Please enter your story.
              </div>
            </div>

          <hr class="my-4">
          
          <div class="text-end">
            <button class="col-1 btn btn-primary btn-lg" type="submit">Edit</button>
          </div>
        </form>
      </div>
    </div>
  </main>
</div>
</body>
</html>
