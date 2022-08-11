package app.uangkas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

import app.uangkas.Adapters.GalleryAdapter;

public class GalleryActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comic_view);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        Random random = new Random();

        final String[] images = new String[10];

        for(int i=0;i<images.length;i++)
            images[i] = "https://www.superherodb.com/pictures2/portraits/10/100/" + random.nextInt(100+1) + ".jpg";

        final app.uangkas.IRecyclerViewClickListener listener = new  app.uangkas.IRecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent i = new Intent(getApplicationContext(),FullScreenActivity.class);
                i.putExtra("IMAGES",images);
                i.putExtra("POSITION",position);
                startActivity(i);
            }
        };

        GalleryAdapter galleryAdapter = new GalleryAdapter(this,images,listener);
        recyclerView.setAdapter(galleryAdapter);

    }
}
