package com.practice.myspringmvc.dtos;

public class BoolRequest {
    private boolean userHasDenied;
    private boolean isBannerShown;

    public boolean isUserHasDenied() {
        return userHasDenied;
    }

    public void setUserHasDenied(boolean userHasDenied) {
        this.userHasDenied = userHasDenied;
    }

    public boolean isBannerShown() {
        return isBannerShown;
    }

    public void setBannerShown(boolean bannerShown) {
        this.isBannerShown = bannerShown;
    }
}
