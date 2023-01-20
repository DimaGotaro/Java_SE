package com.Patterns.Porojd.Builder;

public class EWebSite extends WebSiteBuilder{
    @Override
    void setWebSiteName() {
        webSite.setName("EWebSite");
    }

    @Override
    void setWebSiteCms() {
        webSite.setCms(Cms.ALIFRESCO);
    }

    @Override
    void setWebSitePrice() {
        webSite.setPrice(1500);
    }
}
