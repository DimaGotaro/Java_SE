package com.Patterns.Porojd.Builder;

public abstract class WebSiteBuilder {
    WebSite webSite;

    public void setWebSite() {
        this.webSite = new WebSite();
    }

    public WebSite getWebSite() {
        return webSite;
    }

    abstract void setWebSiteName();

    abstract void setWebSiteCms();

    abstract void setWebSitePrice();
}
