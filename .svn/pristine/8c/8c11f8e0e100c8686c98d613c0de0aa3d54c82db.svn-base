package com.haoze.utils;

import com.haoze.model.system.user.entity.EmrUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * 当前用户工具。
 * @author maxl
 * @time 2018-05-18。
 */
public class CurrentUser {

    private final static String CURRENT_DEPT_KEY = "userDepartment";

    public static String getCurrentUserDepartment(){
        return ShiroUtil.getSession().getAttribute(ShiroUtil.getUserId() + CURRENT_DEPT_KEY) == null ? "" :
                ShiroUtil.getSession().getAttribute(ShiroUtil.getUserId() + CURRENT_DEPT_KEY).toString();
    }

    public static void setCurrentUserDepartment(String departmentId){
        ShiroUtil.getSession().setAttribute(ShiroUtil.getUserId() + CURRENT_DEPT_KEY,departmentId);
    }

    public static EmrUserEntity getUser() {
        Object object = getSubjct().getPrincipal();
        return (EmrUserEntity)object;
    }

    public static String getUserId() {
        return getUser().getID();
    }

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }
}
