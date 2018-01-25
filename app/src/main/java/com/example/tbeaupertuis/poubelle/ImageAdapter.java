package com.example.tbeaupertuis.poubelle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Image;
import android.os.Build;
import android.support.annotation.RequiresApi;
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
    private Bitmap partHidden;
    private Bitmap[] mThumbIds  ;
    private int width;
    private int height;
    private ArrayList<Integer> vals = new ArrayList<Integer>();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public ImageAdapter(Context c, int w, int h) {
        mContext = c;
        img = BitmapFactory.decodeResource(c.getResources(), R.drawable.ile);
        mThumbIds = new Bitmap[ w*h ];

        this.width  = w ;
        this.height = h ;

        //Vals aléatoires (mélanger)
        for(int i=0;i< ( width * height ) ;i++)
        {
            this.vals.add(i);
        }
        Collections.shuffle(this.vals);

        //Taille de chaque partie
        int partsW  = img.getWidth() / width ;
        int partsH = img.getHeight() / height ;
        System.out.println(partsH + " x " + partsW);

        //Découper image
        int count = 0 ;
        for (int i = 0 ; i < width ; i++){
            for ( int j = 0 ; j < height ; j++){
                Bitmap part = Bitmap.createBitmap(img, partsW*i, partsH*j, partsW, partsH);
                part.setHeight(partsH);
                mThumbIds[vals.get(count)] = part ;
                count++ ;
            }
        }

        //Cacher part bas droite
        mThumbIds[8]=null;
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
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setPadding(2, 2, 2, 2);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap(mThumbIds[position]);
        return imageView;
    }
}
