<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script>
    const profilePicture = window.opener.document.getElementById('profilePicture');
    const profileImagePath = window.opener.document.getElementById('profileImagePath');

    profilePicture.src = "../resources/user_profiles/${imageName}";
    profileImagePath.value = "${imageName}";

    window.close();
</script>