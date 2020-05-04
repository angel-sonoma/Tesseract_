package com.example.tesseract;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.widget.Toast;

public class WifiDirectBroadcastReciever extends BroadcastReceiver {
    private WifiP2pManager manager;
    private WifiP2pManager.Channel channel;
    private MainActivity activity;

    public WifiDirectBroadcastReciever(WifiP2pManager manager, WifiP2pManager.Channel channel, MainActivity activity){
        this.manager = manager;
        this.channel = channel;
        this.activity = activity;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
       String action = intent.getAction();
       if(WifiP2pManager.WIFI_P2P_STATE_CHANGED_ACTION.equals(action)){
           // int state = intent.getIntExtra(WifiP2pManager.EXTRA_WIFI_STATE, -1);
           // if(state == WifiP2pManager.WIFI_P2P_STATE_ENABLED){
                //Toast.makeText(context, "WIFI ON", Toast.LENGTH_SHORT).show();
            //}

       }
       else if(WifiP2pManager.WIFI_P2P_PEERS_CHANGED_ACTION.equals(action)){
        if(manager != null){
            manager.requestPeers(channel, activity.peerListListener);
        }
       }
    }
}
