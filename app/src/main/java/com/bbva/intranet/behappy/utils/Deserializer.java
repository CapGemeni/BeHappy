package com.bbva.intranet.behappy.utils;

import com.bbva.intranet.behappy.models.User;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by gesformexico on 22/02/18.
 */


public class Deserializer implements JsonDeserializer<User> {
    @Override
    public User deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        String userM = json.getAsJsonObject().get("data").getAsJsonObject().get("employeeId").getAsString();
        String firstname = json.getAsJsonObject().get("data").getAsJsonObject().get("firstName").getAsString();
        String lastname = json.getAsJsonObject().get("data").getAsJsonObject().get("lastName").getAsString();
        String email = json.getAsJsonObject().get("data").getAsJsonObject().get("email").getAsString();
        User user = new User(userM, firstname, lastname, email);
        return user;
    }
}
