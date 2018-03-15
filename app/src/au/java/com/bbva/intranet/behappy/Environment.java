package com.bbva.intranet.behappy;

import com.bbva.intranet.behappy.utils.BeHappyUtilities;
import com.bbva.login.EnvironmentType;

/**
 * Created by Gesfor on 05/10/16.
 */

public abstract class Environment {
    public static final EnvironmentType Environment =EnvironmentType.AU;
    public static final String SERVICE_GPROFILE="https://au-bbva-gateway.appspot.com/gprofile/s/v2/session";
    public static final String URL_SERVICE="https://au-bbva-gateway.appspot.com/";
    public static final String SERVICE_GNAMEINDEXER="https://au-bbva-gateway.appspot.com/gnameindexer/s/index/search";
}



