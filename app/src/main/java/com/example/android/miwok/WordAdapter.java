package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word>words, int colorResourceId){
        super(context, 0,words);
        mColorResourceId =colorResourceId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

        }

        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_translation);
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_translation);
        ImageView imageView =(ImageView) listItemView.findViewById(R.id.image);

        miwokTextView.setText(currentWord.getMiwokTranslation());
        defaultTextView.setText(currentWord.getDefaultTranslation());

            if (currentWord.hasImage()){
                imageView.setImageResource(currentWord.getmImageResourceId());
            }
            else {
                imageView.setVisibility(View.GONE);
            }

            View textContainer  = listItemView.findViewById(R.id.text_container);
            int color = ContextCompat.getColor(getContext(),mColorResourceId);
            textContainer.setBackgroundColor(color);

        return listItemView;
    }
}
