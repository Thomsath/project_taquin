package com.example.tbeaupertuis.poubelle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by rodrigues on 18/01/18.
 */

class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Bitmap img;
    private Bitmap[] mThumbIds  ;
    private int width;
    private int height;
    private ArrayList<Integer> vals = new ArrayList<Integer>();

    public ImageAdapter(Context c, int w,int h) {
        mContext = c;
        img = BitmapFactory.decodeResource(c.getResources(), R.drawable.ic_launcher);
        mThumbIds = new Bitmap[ w*h ];

        this.width  = w ;
        this.height = h ;

        //Vals aléatoires
        for(int i=0;i< ( width * height ) ;i++)
        {
            this.vals.add(i);
        }
        Collections.shuffle(this.vals);

        //Taille de chaque partie
        int partsW  = img.getWidth() / width ;
        int partsH = img.getHeight() / height ;

        //Découper image
        int count = 0 ; 
        for (int i = 0 ; i < width ; i++){
            for ( int j = 0 ; j < height ; j++){
                Bitmap part = Bitmap.createBitmap(img, partsH*j, partsW*i, partsW, partsH);
                mThumbIds[vals.get(count)] = part ;
                count++ ;
            }
        }
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setPadding(4, 4, 4, 4);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
}
