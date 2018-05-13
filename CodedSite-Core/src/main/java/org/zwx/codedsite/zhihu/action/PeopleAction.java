package org.zwx.codedsite.zhihu.action;

import okhttp3.Response;
import org.zwx.codedsite.core.annotation.Action;
import org.zwx.codedsite.core.annotation.NeedLogin;

/**
 * @author jony
 */
public interface PeopleAction {
    /**
     * @return
     */
    @NeedLogin(message = "Need to log in before you can follow someone")
    @Action("https://www.zhihu.com/api/v4/members/{}/followers")
    Response follow();
}
