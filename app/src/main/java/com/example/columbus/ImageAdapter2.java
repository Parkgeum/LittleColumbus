package com.example.columbus;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;


public class ImageAdapter2 extends BaseAdapter {

    Context context;

    private Integer[] mThumblds ={R.drawable.photo133, R.drawable.photo143, R.drawable.photo123,
            R.drawable.photo133, R.drawable.photo143, R.drawable.photo123,
            R.drawable.photo133, R.drawable.photo143, R.drawable.photo123,
            R.drawable.photo133, R.drawable.photo143, R.drawable.photo123,
            R.drawable.photo133, R.drawable.photo143, R.drawable.photo123,
    };

    public ImageAdapter2(Context context){
        this.context = context;
    }
    @Override
    public int getCount() {
        return mThumblds.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if(convertView == null){
            imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(200,200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }else{
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumblds[position]);
        return imageView;
    }
}
