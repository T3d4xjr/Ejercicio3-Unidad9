package com.example.ejercicio3_unidad9miguelangelruizaguilar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ReminderReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String text = intent.getStringExtra("text");
        String category = intent.getStringExtra("category");

        switch (category) {
            case "Trabajo":
                // Muestra un mensaje tipo toast.
                Toast.makeText(context, "Recordatorio de Trabajo: " + text, Toast.LENGTH_LONG).show();
                break;

            case "Salud":
                // Emite una notificación con sonido.
                NotificationHelper.sendNotification(context, "Recordatorio de Salud", text);
                break;

            case "Social":
                // Guarda en un calendario o notifica de manera ligera.
                NotificationHelper.sendNotification(context, "Evento Social", text);
                break;
        }
    }
}
