package app.uangkas.Adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import app.uangkas.IRecyclerViewClickListener;
import app.uangkas.R;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ImageViewHolder>
{
    Context context;
    String[] urlList;
    IRecyclerViewClickListener clickListener;

    public GalleryAdapter(Context context,String[] urlList,IRecyclerViewClickListener clickListener)
    {
        this.context = context;
        this.urlList = urlList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_item,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        String currentimage = urlList[position];
        ImageView imageView = holder.imageView;
        final ProgressBar progressBar = holder.progressBar;

        Toast.makeText(context,currentimage,Toast.LENGTH_LONG).show();
        Glide.with(context).load(currentimage)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                }).into(imageView);
    }

    @Override
    public int getItemCount() {
        return urlList.length;
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView imageView;
        ProgressBar progressBar;

        public ImageViewHolder(View itemView)
        {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.imageView);
            progressBar = (ProgressBar)itemView.findViewById(R.id.progBar);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v,getAdapterPosition());
        }
    }
}
