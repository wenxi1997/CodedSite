package org.zwx.codedsite.zhihu.info;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.zwx.codedsite.BaseTest;
import org.zwx.codedsite.core.annotation.Attribute;
import org.zwx.codedsite.core.annotation.Processor;
import org.zwx.codedsite.core.annotation.Source;
import org.zwx.codedsite.core.parse.JsonProcessor;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PeopleInfoTest extends BaseTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    private Response getResponse(String url) throws Exception{
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder()
                .header("Authorization", "OAuth c3cef7c66a1843f8b3a9e6a1e3160e20")
                .url(url)
                .get()
                .build();
        Response response = client.newCall(request).execute();
        return response;
    }

    @Test
    public void main() throws Exception {
        Gson gson = new GsonBuilder().create();
    }

    @Test
    public void annotation() throws Exception {
        // Get right url
        Class<PeopleInfo> c = PeopleInfo.class;
        String mainUrl = null;
        List<String> alternative = new ArrayList<>();
        Source source = c.getAnnotation(Source.class);
        mainUrl = source.value();
        alternative.addAll(Arrays.asList(source.alternative()));

        // Connection
        long seconds0 = System.currentTimeMillis();

        String url = MessageFormat.format(mainUrl, "2f89d110f06e9b7a4260ce52fa957cbc");
        Response r = getResponse(url);
        String s = r.body().string();

        printFormat("Connection worked during {0} milliseconds", System.currentTimeMillis() - seconds0);

        // Serialize attribute
        long seconds = System.currentTimeMillis();

        PeopleInfo people = new PeopleInfo();
        Map<?, ?> p = JsonProcessor.process(s);

//        print(p.get("is_followed").getClass());
        long seconds1 = System.currentTimeMillis();
        printFormat("Gson worked during {0} milliseconds", seconds1 - seconds);

        Field [] fields = c.getDeclaredFields();
        for(Field f : fields) {
            Attribute[] a = f.getAnnotationsByType(Attribute.class);
            Processor processor = f.getAnnotation(Processor.class);
            if(a != null) {
                Attribute one = a[0];
                f.setAccessible(true);
                Object o = p.get(one.value());
                if(o instanceof Double){
                    o = ((Double) o).intValue();
                }
                if(f.getType() == boolean.class){
                    o = false;
                }
                if(f.getType() == TopicInfo[].class) {
                    o = null;
                }
                f.set(people, o);
            }
        }
//        print(people);
        long seconds2 = System.currentTimeMillis();
        printFormat("Reflection to set attributes worked during {0} milliseconds",
                seconds2 - seconds1);
        interceptor(people);
    }

    public void interceptor(PeopleInfo p) throws Exception {
        long seconds = System.currentTimeMillis();

        PeopleInfo people = p;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PeopleInfo.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                System.out.println("Interceptor working...");
                return method.invoke(people, args);

            }
        });
        PeopleInfo newPeople = (PeopleInfo) enhancer.create();
//        print(newPeople);

        long now = System.currentTimeMillis();
        print("Cglib dynamic generate class worked during {} milliseconds".replace("{}", Long.toString(now - seconds)));
    }

}