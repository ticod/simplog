package com.ticodev.action.module;

import com.ticodev.action.Action;
import com.ticodev.action.ActionForward;
import com.ticodev.action.AlertAction;
import com.ticodev.model.dao.MemberDao;
import com.ticodev.model.dao.MemberRecommendDao;
import com.ticodev.model.dto.MemberRecommend;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecommendAction implements Action {

    private static final int BLOG = 0;
    private static final int BOARD = 1;
    private static final int COMMENT = 2;

    @Override
    public ActionForward execute(HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {

        String sessionId = (String) request.getSession().getAttribute("login");

        int memberNum;
        int contentType;
        int contentNum;
        try {
            memberNum = new MemberDao().selectMemberById(sessionId).getMbNum();
            contentType = Integer.parseInt(request.getParameter("contentType"));
            contentNum = Integer.parseInt(request.getParameter("contentNum"));
        } catch (Exception e) {
            return AlertAction.forwardError(request);
        }

        MemberRecommendDao dao = new MemberRecommendDao();
        MemberRecommend mr = dao.selectRecommendByContent(memberNum, contentType, contentNum);
        // 이미 추천한 적이 있을 때
        if (mr != null) {
            // 토글
            if (!dao.updateRecommend(!mr.isMrIsCancel(), memberNum, contentType, contentNum)) {
                return AlertAction.forwardError(request);
            }
        } else {
            if (!dao.insertRecommend(memberNum, contentType, contentNum)) {
                return AlertAction.forwardError(request);
            }
        }
        
        return AlertAction.forwardBeforePage(request);
    }
}
