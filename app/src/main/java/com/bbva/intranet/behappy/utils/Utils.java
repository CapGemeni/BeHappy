package com.bbva.intranet.behappy.utils;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.bbva.intranet.behappy.modules.splash.SplashActivity;
import com.bbva.login.ErrorCode;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class Utils {

    public static int dpToPixels(Context context, int dp) {
        return (int) (dp * context.getResources().getDisplayMetrics().density);
    }

    public static boolean hasPermission(Context context, String permission) {
        return ContextCompat.checkSelfPermission(context,
                permission) == PackageManager.PERMISSION_GRANTED;
    }

    public static void ManageError(int errorCode, String errorMsg, Activity activity) {
        if (errorCode == ErrorCode.UserCancel) {
            // El usuario canceló la pantalla de login.
            activity.finish();
        } else if (errorCode == ErrorCode.ConnectionError) {
            Toast.makeText(activity, "La conexión de red no está disponible.", Toast.LENGTH_LONG).show();
        }
        //else if (errorCode== ErrorCodeLogin.RequestUserProfileError)  // Sólo  ocurre si se ha configurado acceso extendido al profile y no habilitado permisos por GCP
        //{
        //	// No visualizar este error
        //		Log.d(TAG, "No se ha habilitado acceso al perfil usuario.");
        //}
        else {
            Toast.makeText(activity, "Se ha producido un error en la autenticación no siendo posible el acceso al recurso. \n" + errorMsg, Toast.LENGTH_LONG).show();
        }
    }





}
