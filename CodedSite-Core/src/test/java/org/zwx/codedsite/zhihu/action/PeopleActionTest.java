package org.zwx.codedsite.zhihu.action;

import okhttp3.*;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.zwx.codedsite.BaseTest;
import org.zwx.codedsite.core.annotation.Action;
import org.zwx.codedsite.core.annotation.NeedLogin;
import org.zwx.codedsite.zhihu.info.PeopleInfo;
import org.zwx.codedsite.zhihu.model.People;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.charset.Charset;
import java.text.MessageFormat;

import static org.junit.Assert.*;

public class PeopleActionTest extends BaseTest{
    @Test
    public void main() throws Exception{
        Class<?>[] interfaces = new Class[]{PeopleAction.class};
        PeopleInfo peopleInfo = new PeopleInfo();
        InvocationHandler invoke = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                print("GET DATA AND POST ACTION");
                Action action = method.getDeclaredAnnotation(Action.class);
                NeedLogin needLogin = method.getDeclaredAnnotation(NeedLogin.class);
                Response r = null;
                if(needLogin != null) {
                    // 省略
                }
                if(action != null) {
                    String url = MessageFormat.format(action.value(), "chu-sen-88");  // should be People
                    String type = action.type();
                    r = getResponse(url, type);
                }
                print("LOG SOMETHING");
                return r;
            }
        };
        PeopleAction pc = (PeopleAction) Proxy.newProxyInstance(
                ClassLoader.getSystemClassLoader(), interfaces, invoke);
        Response r = pc.follow();
        print(r.body().string().getBytes());
        print("\\u77E5");
//        print(StringEscapeUtils.unescapeJson(r.body().string()));  // 第三方应用操作时无此权限
    }

    public Response getResponse(String url, String type) throws IOException{
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .header("Authorization", "OAuth c3cef7c66a1843f8b3a9e6a1e3160e20")
                .url(url)
                .method(type, RequestBody.create(null, ""))
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }
}