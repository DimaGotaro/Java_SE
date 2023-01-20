package com.Patterns.Porojd.Builder;

public class Director {
    private final WebSiteBuilder webSiteBuilder;

    public Director(WebSiteBuilder webSiteBuilder) {
        this.webSiteBuilder = webSiteBuilder;
    }

    public WebSite createWebSite() {
        webSiteBuilder.setWebSite();

        webSiteBuilder.setWebSiteName();
        webSiteBuilder.setWebSiteCms();
        webSiteBuilder.setWebSitePrice();

        return webSiteBuilder.getWebSite();
    }
}
