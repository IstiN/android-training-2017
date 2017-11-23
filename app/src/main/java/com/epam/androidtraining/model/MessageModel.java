package com.epam.androidtraining.model;

import java.io.Serializable;

public class MessageModel implements Serializable {

    private String mMessage;
    private String mSender;
    private String mDate;
    private String mUrl;

    public MessageModel(final String pMessage, final String pSender, final String pDate, String mUrl) {
        mMessage = pMessage;
        mSender = pSender;
        mDate = pDate;
        this.mUrl = mUrl;
    }

    public String getMessage() {
        return mMessage;
    }

    public String getSender() {
        return mSender;
    }

    public String getDate() {
        return mDate;
    }

    public String getUrl() {
        return mUrl;
    }
}
