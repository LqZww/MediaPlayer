package com.example.mediaplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;
import android.os.Binder;

public class MusicService extends  Service{
    private final IBinder mBinder = new LocalBinder();
    public class LocalBinder extends Binder{
        MusicService getService() {
            return MusicService.this;
        }
    }
    public MediaPlayer	music	= null;
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "本地绑定：Service",
                Toast.LENGTH_SHORT).show();
        return mBinder;
    }
    public boolean onUnbind(Intent intent){
        Toast.makeText(this, "取消本地绑定：Service",
                Toast.LENGTH_SHORT).show();
        return false;
    }
    @Override
    public void onCreate() {
        Toast.makeText(this, "(1) 调用 onCreate()创建服务Service", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onStart(Intent intent, int startId) {
        ///super.onStart(intent, startId);
        Toast.makeText(this, "(2) 调用onStart()启动服务Service", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "(3) 调用onDestroy()撤消服务Service", Toast.LENGTH_SHORT).show();
        stoptMusic();
    }
    public void playerMusic(int what){
        switch(what){
            case 1:
                music = MediaPlayer.create(MusicService.this, R.raw.xzqwhp);
                music.start();
                break;
            case 2:
                music = MediaPlayer.create(MusicService.this, R.raw.xzqyb);
                music.start();
                break;
            case 3:
                music = MediaPlayer.create(MusicService.this, R.raw.omfgiloveyou);
                music.start();
                break;
            case 4:
                music = MediaPlayer.create(MusicService.this, R.raw.andcc);
                music.start();
                break;
            case 5:
                music = MediaPlayer.create(MusicService.this, R.raw.bxzd);
                music.start();
                break;
            case 6:
                music = MediaPlayer.create(MusicService.this, R.raw.by);
                music.start();
                break;
            default:
        }
    }
    public void stoptMusic(){
        music.stop();
        music.release();
    }
}


