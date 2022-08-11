package app.uangkas;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import app.uangkas.Adapters.FullSizeAdapter;

public class FullScreenActivity extends AppCompatActivity {

    ViewPager viewPager;
    String[] images;
    int position;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_full_screen);

        if(saveInstanceState==null)
        {
            Intent i = getIntent();
            images = i.getStringArrayExtra("IMAGES");
            position = i.getIntExtra("POSITION",0);
        }

        viewPager = (ViewPager)findViewById(R.id.viewPager);

        FullSizeAdapter fullSizeAdapter = new FullSizeAdapter(this,images);
        viewPager.setAdapter(fullSizeAdapter);
        viewPager.setCurrentItem(position,true);
    }
}
