package com.bbva.intranet.behappy.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by gesformexico on 27/11/17.
 */

public abstract class BeHappyUtilities {

//    public enum Environment {
//        DEVELOPMENT,
//        TEST,
//        AU,
//        PRODUCTION
//    }
//
//    public static void defineEnvironmentDomain(Environment environment) {
//        switch (environment) {
//            case DEVELOPMENT:
//
//                break;
//            case TEST:
//
//                break;
//            case AU:
//                Config.SERVICE_GNAMEINDEXER = Config.SERVICE_GNAMEINDEXER_AU;
//                Config.SERVICE_GPROFILE = Config.SERVICE_GPROFILE_AU;
//                break;
//            case PRODUCTION:
//
//        }
//    }

    public static void sayHello(Context context){
        Toast.makeText(context, "Probanco los ambientes" ,Toast.LENGTH_LONG);
    }
}
