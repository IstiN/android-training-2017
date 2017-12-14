package com.epam.androidtraining.db;

import com.epam.androidtraining.db.models.UserDb;
import com.epam.androidtraining.model.MessageModel;

public class DbModels {

    public static final Class<?>[] DB_MODELS =
            new Class[]{
                    UserDb.class,
                    MessageModel.MessagesDb.class
            };
}
