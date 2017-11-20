package com.epam.androidtraining.view;

public class SomeModel {

   private String mName;
   private String mUrl;

   public SomeModel(){}

    public SomeModel(String pName, String pUrl){
       mName = pName;
       mUrl = pUrl;
    }

    public String getName() {
        return mName;
    }

    public void setName(String pName) {
        mName = pName;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String pUrl) {
        mUrl = pUrl;
    }
}
