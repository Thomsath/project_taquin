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
    private Bitmap mThumbIds[]  ;
    private int width;
    private int height;
    private int gd_size;
    private ArrayList<Integer> vals = new ArrayList<Integer>();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public ImageAdapter(Context c, int size) {
        mContext = c;
        gd_size = size;
        img = BitmapFactory.decodeResource(c.getResources(), R.drawable.ile);
        mThumbIds = new Bitmap[gd_size * gd_size];

        //Vals aléatoires (mélanger)
        for (int i = 0; i < (gd_size * gd_size); i++) {
            this.vals.add(i);
        }
        Collections.shuffle(this.vals);

        decouper(img);
        melanger(mThumbIds);
    }

    public void decouper (Bitmap image){
        int taille = image.getWidth()/gd_size;
        System.out.println(taille);
        int b=0;
        for (int y=0;y < gd_size ;y++){
            for( int x =0;x<gd_size; x++){
                mThumbIds[b]=Bitmap.createBitmap(image, x*taille, y*taille,taille,taille);
                b++;
            }
        }
        mThumbIds[mThumbIds.length-1]=Bitmap.createBitmap(taille,taille, Bitmap.Config.ALPHA_8);
    }

    public void melanger(Bitmap[] tab){
        for (int i=0; i<500*gd_size;i++){
            int n = (int)(Math.random() * tab.length);
            //move(n);
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
            imageView.setScaleType(ImageView.ScaleType.CENTER);
            imageView.setPadding(2, 2, 2, 2);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap(mThumbIds[position]);
        return imageView;
    }
}
