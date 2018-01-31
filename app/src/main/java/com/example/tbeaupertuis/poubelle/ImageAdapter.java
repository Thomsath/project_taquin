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
    private Bitmap mThumbIds[];
    private int gd_size;
    private int rannul;
    private ArrayList<Integer> vals = new ArrayList<Integer>();

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public ImageAdapter(Context c, int size) {
        mContext = c;
        gd_size = size;
        img = BitmapFactory.decodeResource(c.getResources(), R.drawable.ic_launcher);
        mThumbIds = new Bitmap[gd_size * gd_size];

        //Vals aléatoires (mélanger)

        // On remplis une liste qui représente la grille de jeu
        for (int i = 0; i < (gd_size * gd_size); i++) {
            this.vals.add(i);
        }
        //Collections.shuffle(this.vals); -> Mélanger()

        decouper(img);


        rannul=gd_size*gd_size-1;
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
            move(n);
        }
    }

    public void move( int position){
        // Ici on test les positions posibles suivant la place de la case vide

        // Toutes les cases à gauche de la grille ont un modulo égal à 0 
        // les conditions sont utiles à savoir où on se trouve sur la grille
        /* 
             ______
            |x| | |
            |x| | |
            |x| | |
            ¯¯¯¯¯¯¯
        */
        if( position % gd_size == 0){

            if ((position-gd_size)>=0 && (position+gd_size)<=(vals.size()-1)){
                //deplacement possible droite, bas, haut
                if(vals.get(position+1)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position+1];
                    mThumbIds[position+1]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position+1));
                    vals.set(position+1,x);
                }
                else if (vals.get(position+gd_size)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position+gd_size];
                    mThumbIds[position+gd_size]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position+gd_size));
                    vals.set(position+gd_size,x);
                }
                else if (vals.get(position-gd_size)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position-gd_size];
                    mThumbIds[position-gd_size]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position-gd_size));
                    vals.set(position-gd_size,x);
                }

            }

            else if ((position-gd_size)<=0){
                if(vals.get(position+1)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position+1];
                    mThumbIds[position+1]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position+1));
                    vals.set(position+1,x);
                }
                else if (vals.get(position+gd_size)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position+gd_size];
                    mThumbIds[position+gd_size]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position+gd_size));
                    vals.set(position+gd_size,x);
                }
            }


            else if (position+gd_size>=vals.size()-1){

                if(vals.get(position+1)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position+1];
                    mThumbIds[position+1]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position+1));
                    vals.set(position+1,x);
                }
                else if (vals.get(position-gd_size)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position-gd_size];
                    mThumbIds[position-gd_size]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position-gd_size));
                    vals.set(position-gd_size,x);
                }

            }
        }

        else if (position % gd_size == (gd_size-1)){
            if ((position-gd_size)>=0 && (position+gd_size)<=(vals.size()-1)){
                //deplacement possible droite, bas, haut
                if(vals.get(position-1)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position-1];
                    mThumbIds[position-1]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position-1));
                    vals.set(position-1,x);
                }
                else if (vals.get(position+gd_size)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position+gd_size];
                    mThumbIds[position+gd_size]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position+gd_size));
                    vals.set(position+gd_size,x);
                }
                else if (vals.get(position-gd_size)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position-gd_size];
                    mThumbIds[position-gd_size]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position-gd_size));
                    vals.set(position-gd_size,x);
                }

            }
            if (position-gd_size<=0){
                if(vals.get(position-1)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position-1];
                    mThumbIds[position-1]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position-1));
                    vals.set(position-1,x);
                }
                else if (vals.get(position+gd_size)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position+gd_size];
                    mThumbIds[position+gd_size]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position+gd_size));
                    vals.set(position+gd_size,x);
                }

            }
            else if (position+gd_size>=vals.size()-1){
                if(vals.get(position-1)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position-1];
                    mThumbIds[position-1]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position-1));
                    vals.set(position-1,x);
                }
                else if (vals.get(position-gd_size)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position-gd_size];
                    mThumbIds[position-gd_size]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position-gd_size));
                    vals.set(position-gd_size,x);
                }
            }
        }
        else {
            if ((position-gd_size)>=0 && (position+gd_size)<=(vals.size()-1)){
                //deplacement possible droite, bas, haut ,gauche
                if(vals.get(position-1)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position-1];
                    mThumbIds[position-1]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position-1));
                    vals.set(position-1,x);
                }
                else if (vals.get(position+gd_size)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position+gd_size];
                    mThumbIds[position+gd_size]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position+gd_size));
                    vals.set(position+gd_size,x);
                }
                else if (vals.get(position-gd_size)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position-gd_size];
                    mThumbIds[position-gd_size]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position-gd_size));
                    vals.set(position-gd_size,x);
                }
                else if(vals.get(position+1)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position+1];
                    mThumbIds[position+1]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position+1));
                    vals.set(position+1,x);
                }

            }
            else if ((position-gd_size)<0){
                if(vals.get(position-1)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position-1];
                    mThumbIds[position-1]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position-1));
                    vals.set(position-1,x);
                }
                else if (vals.get(position+gd_size)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position+gd_size];
                    mThumbIds[position+gd_size]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position+gd_size));
                    vals.set(position+gd_size,x);
                }

                else if(vals.get(position+1)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position+1];
                    mThumbIds[position+1]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position+1));
                    vals.set(position+1,x);
                }
            }
            else if (position+gd_size>vals.size()-1){
                if(vals.get(position-1)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position-1];
                    mThumbIds[position-1]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position-1));
                    vals.set(position-1,x);
                }
                else if (vals.get(position-gd_size)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position-gd_size];
                    mThumbIds[position-gd_size]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position-gd_size));
                    vals.set(position-gd_size,x);
                }
                else if(vals.get(position+1)==rannul){
                    Bitmap img = mThumbIds[position];
                    mThumbIds[position]=mThumbIds[position+1];
                    mThumbIds[position+1]=img;
                    // x est la variable tampon pour stocker la position le temps de l'échange des positions
                    int x = vals.get(position);
                    // A chaque fois ici on échange les deux positions pour simuler le mouvement des pièces
                    vals.set(position,vals.get(position+1));
                    vals.set(position+1,x);
                }
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
            imageView.setLayoutParams(new GridView.LayoutParams(350, 350));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(1, 1, 1, 1);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageBitmap(mThumbIds[position]);
        return imageView;
    }
}
