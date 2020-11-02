package com.duotu.test.model;

/**
 * author : zhy
 * date   : 2020/11/1 19:46
 * desc   :
 */
public class Destination {


    /**
     * isFragment : true
     * asStarter : false
     * needLogin : false
     * pageUrl : main/tabs/dashboard
     * id : 261569808
     * clzName : com.duotu.test.ui.dashboard.DashboardFragment
     */

    private boolean isFragment;
    private boolean asStarter;
    private boolean needLogin;
    private String pageUrl;
    private int id;
    private String clzName;

    public boolean isIsFragment() {
        return isFragment;
    }

    public void setIsFragment(boolean isFragment) {
        this.isFragment = isFragment;
    }

    public boolean isAsStarter() {
        return asStarter;
    }

    public void setAsStarter(boolean asStarter) {
        this.asStarter = asStarter;
    }

    public boolean isNeedLogin() {
        return needLogin;
    }

    public void setNeedLogin(boolean needLogin) {
        this.needLogin = needLogin;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClzName() {
        return clzName;
    }

    public void setClzName(String clzName) {
        this.clzName = clzName;
    }
}
