package org.zwx.codedsite.zhihu.action;

import okhttp3.Response;
import org.zwx.codedsite.core.annotation.Action;
import org.zwx.codedsite.core.annotation.NeedLogin;

import static org.zwx.codedsite.zhihu.config.url.ActionUrl.*;

/**
 * @author jony
 */
public interface PeopleAction {
    /**
     * Follow someone
     * @return
     */
    @NeedLogin(message = "Need to log in before you can follow someone")
    @Action(PEOPLE_FOLLOW_V4)
    Response follow();

    @NeedLogin(message = "Need to log in before you can block someone")
    @Action(PEOPLE_BLOCK_v4)
    Response block();

    @NeedLogin(message = "Need to log in before you can unblock someone")
    @Action(value = PEOPLE_BLOCK_v4, type = "DELETE")
    Response unBlock();

}
