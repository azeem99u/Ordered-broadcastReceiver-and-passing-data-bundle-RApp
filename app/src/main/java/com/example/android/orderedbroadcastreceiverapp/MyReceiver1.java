package com.example.android.orderedbroadcastreceiverapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyReceiver1 extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (isOrderedBroadcast()){
            int initialCode = getResultCode();
            String initialData = getResultData();
            // true if bundle is null then new bundle will initialized;
            // no null pointer exception
            Bundle bundle = getResultExtras(true);
            String stringExtra  = bundle.getString("message_key");
            initialCode++;
            stringExtra+="-> BR1";
            String output = "initial code: "+initialCode+"\n"+
                    "initial data: "+initialData+"\n"+
                    "string extra: "+stringExtra;
            Toast.makeText(context, output, Toast.LENGTH_SHORT).show();

            initialData = "BR1";
            bundle.putString("message_key",stringExtra);
            setResult(initialCode,initialData,bundle);

        }
    }
}
