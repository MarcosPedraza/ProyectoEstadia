package com.example.marcospedraza.proyectoestadia.pageradapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.marcospedraza.proyectoestadia.R;

/**
 * Created by Marcos Pedraza on 20/11/2017.
 */

public class SlidePagerAdapter extends PagerAdapter {


    Context mContext;
    LayoutInflater mLayoutInflater;
    String [] imags;

    public  SlidePagerAdapter(Context context,String [] images)
    {
        this.mContext = context;
        this.imags = images;
        mLayoutInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imags.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.view_pager_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView_pager);
        //imageView.setImageResource(imags[position]);

        Glide.with(imageView.getContext()).load(imags[position]).centerCrop().into(imageView);



        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
