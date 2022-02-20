package com.mycooco.dokdo;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.mycooco.dokdo.databinding.ActivityMainBinding;
import com.mycooco.dokdo.vo.Autumn;
import com.mycooco.dokdo.vo.Season;
import com.mycooco.dokdo.vo.Spring;
import com.mycooco.dokdo.vo.Summer;
import com.mycooco.dokdo.vo.Winter;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends Activity {

    private AdView mAdView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = binding.adView;
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Season spring = new Spring();
        Season summer = new Summer();
        Season autumn = new Autumn();
        Season winter = new Winter();

        Map map = new HashMap();
        map.put("season", spring);

        AssetManager am = getResources().getAssets();

        binding.btnPrev.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("DEV", "spring button is clicked. wow!");
                //Log.i("DEV", spring.getNextImage());
                String[] imageInfo = Helper.getPrevImage((Season) map.get("season")).split("#");
                String title = imageInfo[0];
                String fileName = imageInfo[1];
                binding.mainCanvas.setImageBitmap(Helper.getBitMap(am, fileName));
                binding.imgDesc.setText(title);
            }
        });

        binding.btnNext.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("DEV", "spring button is clicked. wow!");
                //Log.i("DEV", spring.getNextImage());
                String[] imageInfo = Helper.getNextImage((Season) map.get("season")).split("#");
                String title = imageInfo[0];
                String fileName = imageInfo[1];
                binding.mainCanvas.setImageBitmap(Helper.getBitMap(am, fileName));
                binding.imgDesc.setText(title);
            }
        });

        binding.btnSpring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("season", spring);
                Log.i("DEV", "spring button is clicked. wow!");
                //Log.i("DEV", spring.getNextImage());
                String[] imageInfo = spring.getNextImage().split("#");
                String title = imageInfo[0];
                String fileName = imageInfo[1];
                binding.mainCanvas.setImageBitmap(Helper.getBitMap(am, fileName));
                binding.imgDesc.setText(title);
            }
        });

        binding.btnSummer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("season", summer);
                Log.i("DEV", "summer button is clicked.");
                String[] imageInfo = summer.getNextImage().split("#");
                String title = imageInfo[0];
                String fileName = imageInfo[1];
                binding.mainCanvas.setImageBitmap(Helper.getBitMap(am, fileName));
                binding.imgDesc.setText(title);
            }
        });

        binding.btnAutumn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("season", autumn);
                Log.i("DEV", "autumn button is clicked.");
                String[] imageInfo = autumn.getNextImage().split("#");
                String title = imageInfo[0];
                String fileName = imageInfo[1];
                binding.mainCanvas.setImageBitmap(Helper.getBitMap(am, fileName));
                binding.imgDesc.setText(title);
            }
        });

        binding.btnWinter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                map.put("season", winter);
                Log.i("DEV", "winter button is clicked.");
                String[] imageInfo = winter.getNextImage().split("#");
                String title = imageInfo[0];
                String fileName = imageInfo[1];
                binding.mainCanvas.setImageBitmap(Helper.getBitMap(am, fileName));
                binding.imgDesc.setText(title);
            }
        });
    }
}
