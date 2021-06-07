package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word>words=new ArrayList<Word>();
        words.add(new Word("One", "Lutti", R.drawable.number_one,R.raw.number_one));
        words.add(new Word("Two", "Otiiko", R.drawable.number_two,R.raw.number_two ));
        words.add(new Word("Three", "Tolookosu",R.drawable.number_three,R.raw.number_three ));
        words.add(new Word("Four", "Oyyisa", R.drawable.number_four,R.raw.number_four ));
        words.add(new Word("Five", "massakka", R.drawable.number_five,R.raw.number_five ));
        words.add(new Word("Six", "temmokka", R.drawable.number_six,R.raw.number_six ));
        words.add(new Word("Seven", "kenekaku", R.drawable.number_seven,R.raw.number_seven ));
        words.add(new Word("Eight", "kawinta", R.drawable.number_eight,R.raw.number_eight ));
        words.add(new Word("Nine", "wo´e", R.drawable.number_nine,R.raw.number_nine ));
        words.add(new Word("Ten", "na´aacha", R.drawable.number_ten,R.raw.number_ten ));

        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_numbers );
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id){
                Word word = words.get(position);
                MediaPlayer mediaPlayer = MediaPlayer.create(numbers.this,word.getmAudioResourceId() );
                mediaPlayer.start();
            }
        });

    }
}