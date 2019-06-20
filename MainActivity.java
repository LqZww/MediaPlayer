package com.example.mediaplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.IBinder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp = new MediaPlayer();
    VideoView video;
    MusicService music;
    boolean isBound = false;
    TextView labelView;
    PopupMenu popup=null;
    public  int what=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent serviceIntent = new Intent(MainActivity.this,MusicService.class);
        ServiceConnection connection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                music = ((MusicService.LocalBinder)service).getService();
            }
            @Override
            public void onServiceDisconnected(ComponentName name) {
                music = null;
            }
        };
        bindService(serviceIntent,connection,Context.BIND_AUTO_CREATE);
        Button start = (Button)findViewById(R.id.button1);
        Button stop  = (Button)findViewById(R.id.button2);

        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View button) {
                // TODO 自动生成的方法存根
                popup=new PopupMenu(MainActivity.this,button);
                getMenuInflater().inflate(R.menu.musicmenu,popup.getMenu());
                popup.show();
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item) {
                        switch(item.getItemId()){
                            case R.id.item1:
                                what=1;
                                break;
                            case R.id.item2:
                                what=2;
                                break;
                            case R.id.item3:
                                what=3;
                                break;
                            case R.id.item4:
                                what=4;
                                break;
                            case R.id.item5:
                                what=5;
                                break;
                            case R.id.item6:
                                what=6;
                                break;
                            default:
                        }
                        music.playerMusic(what);
                        return false;
                    }

                });
            }});
        stop.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                music.stoptMusic();
            }
        });
    }

    public void onPopupeButtonClick(View button){
        popup = new PopupMenu(this,button);
        getMenuInflater().inflate(R.menu.main,popup.getMenu());
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item1:
                        Intent intent1=new Intent(MainActivity.this,ActionBarActivity.class);
                        intent1.putExtra("from", "intent1");
                        startActivity(intent1);
                        break;
                    case R.id.item2:
                        Intent intent2=new Intent(MainActivity.this,ActionBarActivity.class);
                        intent2.putExtra("from", "intent2");
                        startActivity(intent2);
                        break;
                    case R.id.item3:
                        Intent intent3=new Intent(MainActivity.this,ActionBarActivity.class);
                        intent3.putExtra("from", "intent3");
                        startActivity(intent3);
                        break;
                    case R.id.item4:
                        Intent intent4=new Intent(MainActivity.this,ActionBarActivity.class);
                        intent4.putExtra("from", "intent4");
                        startActivity(intent4);
                        break;
                }
                return false;
            }
        });
        popup.show();
    }
}


