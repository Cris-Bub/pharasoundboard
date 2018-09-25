//package com.example.cristianvillanueva.soundboard;
//
//import android.media.AudioAttributes;
//import android.media.AudioManager;
//import android.media.SoundPool;
//import android.os.Build;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//
//public class MainActivity extends AppCompatActivity {
//
//    private SoundPool soundPool;
//    private int sound1, sound2, sound3, sound4, sound5;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//            AudioAttributes audioAttributse = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION).setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION).build();
//
//            soundPool = new SoundPool.Builder().setMaxStreams(6).setAudioAttributes(audioAttributse).build();
//
//
//        } else {
//            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
//
//        }
//
//        sound1 = soundPool.load(this, R.raw.rocketbarrage, 1);
//        sound2 = soundPool.load(this, R.raw.attack, 1);
//        sound3 = soundPool.load(this, R.raw.backintothefray, 1);
//        sound4 = soundPool.load(this, R.raw.defend, 1);
//        sound5 = soundPool.load(this, R.raw.muchbetter, 1);
//
//    }
//
//
//    public void playsound(View v){
//        switch(v.getId()){
//            case R.id.button_sound1:
//                soundPool.play(sound1, 1,1, 0,0,1);
//                break;
//            case R.id.button_sound2:
//                soundPool.play(sound2, 1,1, 0,0,1);
//                break;
//            case R.id.button_sound3:
//                soundPool.play(sound3, 1,1, 0,0,1);
//                break;
//            case R.id.button_sound4:
//                soundPool.play(sound4, 1,1, 0,0,1);
//                break;
//            case R.id.button_sound5:
//                soundPool.play(sound5, 1,1, 0,0,1);
//                break;
//
//        }
//
//
//    }
//
//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//        soundPool.release();
//        soundPool = null;
//    }
//}



//--------------------

package com.example.cristianvillanueva.soundboard;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SoundPool soundPool;
    private int sound1, sound2, sound3, sound4, sound5, sound6;
    private int sound3StreamId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(6)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }

        sound1 = soundPool.load(this, R.raw.rocketbarrage, 1);
        sound2 = soundPool.load(this, R.raw.muchbetter, 1);
        sound3 = soundPool.load(this, R.raw.defend, 1);
        sound4 = soundPool.load(this, R.raw.backintothefray, 1);
        sound5 = soundPool.load(this, R.raw.attack, 1);
        sound6 = soundPool.load(this, R.raw.allsystems, 1);
    }

    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.button_sound1:
                soundPool.play(sound1, 1, 1, 0, 1, 1);
                //soundPool.pause(sound3StreamId);
                soundPool.autoPause();
//                Log.d("myTag", "THis is epic");
                break;
            case R.id.button_sound2:
                soundPool.play(sound2, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound3:
                sound3StreamId = soundPool.play(sound3, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound4:
                soundPool.play(sound4, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound5:
                soundPool.play(sound5, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound6:
                soundPool.play(sound6, 1, 1, 0, 0, 1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}