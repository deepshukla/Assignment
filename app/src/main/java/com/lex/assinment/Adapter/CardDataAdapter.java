package com.lex.assinment.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.lex.assinment.Model.CardDataRes;
import com.lex.assinment.R;

import java.util.ArrayList;
import java.util.List;




public class CardDataAdapter extends RecyclerView.Adapter<CardDataAdapter.MyViewHolder> {
    private Context context;
    private List<CardDataRes> list = new ArrayList<>();
    public CardDataAdapter(Context context, List<CardDataRes> list){
        this.context = context;
        this.list = list;
    }
    @Override
    public CardDataAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(CardDataAdapter.MyViewHolder holder, int position) {
        holder.tvName.setText(list.get(position).getName());
        holder.tvAge.setText(list.get(position).getAge());
        holder.tvLocation.setText(list.get(position).getLocation());
        Glide.with(context).load(list.get(position).getUrl())
                .thumbnail(0.5f)
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .transform(new CircleTransform(context))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgPic);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvAge;
        TextView tvLocation;
        ImageView imgPic;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvName = (TextView)itemView.findViewById(R.id.tv_name);
            tvAge = (TextView)itemView.findViewById(R.id.tv_age);
            tvLocation = (TextView)itemView.findViewById(R.id.tv_location);
            imgPic= (ImageView)itemView.findViewById(R.id.img_pic);
        }
    }

    public class CircleTransform extends BitmapTransformation {

        public CircleTransform(Context context) {
            super(context);
        }

        @Override protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private  Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;

            int size = Math.min(source.getWidth(), source.getHeight());
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;

            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);

            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }

            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);
            return result;
        }

        @Override public String getId() {
            return getClass().getName();
        }
    }
}
