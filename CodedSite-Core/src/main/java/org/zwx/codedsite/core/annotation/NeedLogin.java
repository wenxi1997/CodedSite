package org.zwx.codedsite.core.annotation;

public @interface NeedLogin {
    String message();
    boolean helpLogin() default false;
}
