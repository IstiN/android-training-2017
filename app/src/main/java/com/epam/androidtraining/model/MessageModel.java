package com.epam.androidtraining.model;

import java.io.Serializable;

public class MessageModel implements Serializable {

    private String mMessage;
    private String mSender;
    private String mDate;

    public MessageModel(final String pMessage, final String pSender, final String pDate) {
        mMessage = pMessage;
        mSender = pSender;
        mDate = pDate;
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
}
