package com.duotu.libnavannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * author : zhy
 * date   : 2020/10/25 17:00
 * desc   :
 */
@Target(ElementType.TYPE)
public @interface FragmentDestination {

    String pageUrl();
    boolean needLogin() default false;
    boolean asStart() default false;
}

