package org.zwx.codedsite.zhihu.config.url;

/**
 * @author jony
 */
public class SourceUrl {
    public static final String ROOT_API = "https://api.zhihu.com/";

    public static final String ROOT_V4 = "https://www.zhihu.com/api/v4/";

    public static final String ROOT_v3 = "https://www.zhihu.com/api/v3/";

    public static final String ROOT_PAGE = "https://www.zhihu.com/";

    public static final String ZHUAN_LAN = "https://zhuanlan.zhihu.com/";

    public static final String PEOPLE_API = ROOT_API + "people/{0}";

    public static final String PEOPLE_V4 = ROOT_V4 + "members/{0}?include=";

    private SourceUrl() {}
}
