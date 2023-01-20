package com.Patterns.Porojd.Builder;

public class VCWebSite extends WebSiteBuilder{
    @Override
    void setWebSiteName() {
        webSite.setName("VCWebSite");
    }

    @Override
    void setWebSiteCms() {
        webSite.setCms(Cms.WORDPRESS);
    }

    @Override
    void setWebSitePrice() {
        webSite.setPrice(400);
    }
}
