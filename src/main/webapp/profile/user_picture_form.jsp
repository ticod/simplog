<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="row">
    <div class="col w-100" style="height: 50vh;">
        <img class="w-100 h-100" src="../resources/imgs/profile-user.png" id="preview"
             style="object-fit: contain;" alt="사진 업로드">
    </div>
</div>
<div class="row">
    <div class="form-group w-100 text-center p-1">
        <form action="user_picture.do" method="post" enctype="multipart/form-data">
            <input class="form-control" type="file" name="imageFile" id="imageFile" accept="image/*">
            <input class="btn btn-primary" type="submit" value="사진 등록">
        </form>
    </div>
</div>

<script>
    const imageFile = $("#imageFile");
    const preview = document.querySelector('#preview');

    $(function() {
        imageFile.on('change', function(event) {
            const getFile = event.target.files;
            const reader = new FileReader();
            reader.onload = (function(img) {
                return function(event) {
                    img.src = event.target.result;
                    console.log(img.src);
                }
            })(preview);

            if (getFile) {
                reader.readAsDataURL(getFile[0]);
            }
        });
    });
</script>
</body>
</html>
