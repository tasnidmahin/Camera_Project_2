package com.example.camera_project_2;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.Toast;

import com.sherazkhilji.videffects.AutoFixEffect;
import com.sherazkhilji.videffects.BlackAndWhiteEffect;
import com.sherazkhilji.videffects.BrightnessEffect;
import com.sherazkhilji.videffects.ContrastEffect;
import com.sherazkhilji.videffects.CrossProcessEffect;
import com.sherazkhilji.videffects.DocumentaryEffect;
import com.sherazkhilji.videffects.DuotoneEffect;
import com.sherazkhilji.videffects.FillLightEffect;
import com.sherazkhilji.videffects.GammaEffect;
import com.sherazkhilji.videffects.GrainEffect;
import com.sherazkhilji.videffects.GreyScaleEffect;
import com.sherazkhilji.videffects.HueEffect;
import com.sherazkhilji.videffects.InvertColorsEffect;
import com.sherazkhilji.videffects.LamoishEffect;
import com.sherazkhilji.videffects.NoEffect;
import com.sherazkhilji.videffects.PosterizeEffect;
import com.sherazkhilji.videffects.SaturationEffect;
import com.sherazkhilji.videffects.SepiaEffect;
import com.sherazkhilji.videffects.SharpnessEffect;
import com.sherazkhilji.videffects.TemperatureEffect;
import com.sherazkhilji.videffects.TintEffect;
import com.sherazkhilji.videffects.VignetteEffect;
import com.sherazkhilji.videffects.view.VideoSurfaceView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private String[] effectnames;
    private static final String TAG = "SamplePlayerActivity";

    protected Resources mResources;

    private VideoSurfaceView mVideoView = null;
    private MediaPlayer mMediaPlayer = null;

    private boolean frst = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        effectnames = getResources().getStringArray(R.array.effect_names);
        spinner = findViewById(R.id.spinnerID);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.sample_view,R.id.TVID,effectnames);
        spinner.setAdapter(adapter);

        mResources = getResources();
        mMediaPlayer = new MediaPlayer();

        try {
            // Load video file from SD Card
             /*File dir = Environment
             .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
             File file = new File(dir,
             "funny_one.mp4");
             mMediaPlayer.setDataSource(file.getAbsolutePath());*/
            // -----------------------------------------------------------------------
            // Load video file from Assets directory
            AssetFileDescriptor afd = getAssets().openFd("sample.mp4");
            mMediaPlayer.setDataSource(afd.getFileDescriptor(),
                    afd.getStartOffset(), afd.getLength());

        } catch (Exception e) {
            Log.e(TAG, e.getMessage(), e);
        }
        // Initialize VideoSurfaceView using code
        // mVideoView = new VideoSurfaceView(this);
        // setContentView(mVideoView);
        // or




        mVideoView = (VideoSurfaceView) findViewById(R.id.mVideoSurfaceView);
        //mVideoView.init(mMediaPlayer, new DuotoneEffect(Color.parseColor("#3498DB"), Color.YELLOW));
        mVideoView.init(mMediaPlayer,new NoEffect());
//      If you want to change effect then just call mVideoView.init() again
//      and then call mVideoView.onResume()

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(frst)
                {
                    if(position == 0)
                    {
                        mVideoView.init(mMediaPlayer,new NoEffect());
                        mVideoView.onResume();
                    }
                    else if(position == 1)
                    {
                        mVideoView.init(mMediaPlayer,new AutoFixEffect(1f));
                        mVideoView.onResume();
                    }
                    else if(position == 2)
                    {
                        mVideoView.init(mMediaPlayer,new BlackAndWhiteEffect());
                        mVideoView.onResume();
                    }
                    else if(position == 3)
                    {
                        mVideoView.init(mMediaPlayer,new BrightnessEffect(1.8f));
                        mVideoView.onResume();
                    }
                    else if(position == 4)
                    {
                        mVideoView.init(mMediaPlayer,new ContrastEffect(1.8f));
                        mVideoView.onResume();
                    }
                    else if(position == 5)
                    {
                        mVideoView.init(mMediaPlayer,new CrossProcessEffect());
                        mVideoView.onResume();
                    }
                    else if(position == 6)
                    {
                        mVideoView.init(mMediaPlayer,new DocumentaryEffect());
                        mVideoView.onResume();
                    }
                    else if(position == 7)
                    {
                        mVideoView.init(mMediaPlayer, new DuotoneEffect(Color.parseColor("#3498DB"), Color.YELLOW));
                        mVideoView.onResume();
                    }
                    else if(position == 8)
                    {
                        mVideoView.init(mMediaPlayer, new FillLightEffect(0.8f));
                        mVideoView.onResume();
                    }
                    else if(position == 9)
                    {
                        mVideoView.init(mMediaPlayer, new GammaEffect(1.8f));
                        mVideoView.onResume();
                    }
                    else if(position == 10)
                    {
                        mVideoView.init(mMediaPlayer, new GrainEffect(0.8f));
                        mVideoView.onResume();
                    }
                    else if(position == 11)
                    {
                        mVideoView.init(mMediaPlayer, new GreyScaleEffect());
                        mVideoView.onResume();
                    }
                    else if(position == 12)
                    {
                        mVideoView.init(mMediaPlayer, new HueEffect(180f));
                        mVideoView.onResume();
                    }
                    else if(position == 13)
                    {
                        mVideoView.init(mMediaPlayer, new InvertColorsEffect());
                        mVideoView.onResume();
                    }
                    else if(position == 14)
                    {
                        mVideoView.init(mMediaPlayer, new LamoishEffect());
                        mVideoView.onResume();
                    }
                    else if(position == 15)
                    {
                        mVideoView.init(mMediaPlayer, new PosterizeEffect());
                        mVideoView.onResume();
                    }
                    else if(position == 16)
                    {
                        mVideoView.init(mMediaPlayer, new SaturationEffect(-1f));
                        mVideoView.onResume();
                    }
                    else if(position == 17)
                    {
                        mVideoView.init(mMediaPlayer, new SepiaEffect());
                        mVideoView.onResume();
                    }
                    else if(position == 18)
                    {
                        mVideoView.init(mMediaPlayer, new SharpnessEffect(1f));
                        mVideoView.onResume();
                    }
                    else if(position == 19)
                    {
                        mVideoView.init(mMediaPlayer, new TemperatureEffect(1f));
                        mVideoView.onResume();
                    }
                    else if(position == 20)
                    {
                        mVideoView.init(mMediaPlayer, new TintEffect(Color.BLUE));
                        mVideoView.onResume();
                    }
                    else if(position == 21)
                    {
                        mVideoView.init(mMediaPlayer, new VignetteEffect(0.9f));
                        mVideoView.onResume();
                    }
                }
                else frst = true;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
        mVideoView.onResume();
    }
}
