package com.haoze.utils;/*
package com.haoze.utils;

import com.haoze.model.system.user.entity.EmrUserEntity;
import com.haoze.model.system.user.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

*/
/**
 * Created by Administrator on 2018/5/7.
 *//*

public class MyShiroUtil {

    @Autowired
    private static SessionDAO sessionDAO;

    public static Subject getSubjct() {
        return SecurityUtils.getSubject();
    }
    public static UserEntity getUser() {
        Object object = getSubjct().getPrincipal();
        return (UserEntity)object;
    }
    public static Long getUserId() {
        return getUser().getUserId();
    }

    public static void logout() {
        getSubjct().logout();
    }

    public static List<Principal> getPrinciples() {
        List<Principal> principals = null;
        Collection<Session> sessions = sessionDAO.getActiveSessions();
        return principals;
    }
}
*/
