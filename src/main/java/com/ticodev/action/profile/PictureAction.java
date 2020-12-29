package com.ticodev.action.profile;

import com.oreilly.servlet.MultipartRequest;
import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;

public class PictureAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        String path = request.getServletContext().getRealPath("/") + "resources/user_profiles/";

        int size = 10 * 1024 * 1024;
        File pathDirectory = new File(path);
        if (!pathDirectory.exists()) {
            pathDirectory.mkdirs();
        }

        MultipartRequest multi = new MultipartRequest(request, path, size, "utf-8");
        String imageName = multi.getFilesystemName("imageFile");
        System.out.println(imageName);
        BufferedImage bi = ImageIO.read(new File(path + imageName));
        request.setAttribute("imageName", imageName);

        return new ActionForward();

    }

}
