package com.demotxt.myapp.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Streamer> lstStreamer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstStreamer = new ArrayList<>();
        lstStreamer.add(new Streamer("CHAPAX","Categorie Streamer","GTA V",R.drawable.chapax));
        lstStreamer.add(new Streamer("ISSnho","Categorie Streamer","CLASH ROYALE",R.drawable.issinho));
        lstStreamer.add(new Streamer("Tony GameSpace","Categorie Streamer","PUG MOBILE",R.drawable.tonygamespace));
        lstStreamer.add(new Streamer("CHAPAX","Categorie Streamer","GTA V",R.drawable.chapax));
        lstStreamer.add(new Streamer("ISSnho","Categorie Streamer","CLASH ROYALE",R.drawable.issinho));
        lstStreamer.add(new Streamer("Tony GameSpace","Categorie Streamer","PUG MOBILE",R.drawable.tonygamespace));
        lstStreamer.add(new Streamer("ROGISH","Categorie Streamer","LOL, cosa fea",R.drawable.rogish));
        lstStreamer.add(new Streamer("DeivFG","Categorie Streamer","Free Fire",R.drawable.deivfg));
        lstStreamer.add(new Streamer("CHAPAX","Categorie Streamer","GTA V",R.drawable.chapax));
        lstStreamer.add(new Streamer("ISSnho","Categorie Streamer","CLASH ROYALE",R.drawable.issinho));
        lstStreamer.add(new Streamer("Tony GameSpace","Categorie Streamer","PUG MOBILE",R.drawable.tonygamespace));
        lstStreamer.add(new Streamer("ROGISH","Categorie Streamer","LOL, cosa fea",R.drawable.rogish));
        lstStreamer.add(new Streamer("DeivFG","Categorie Streamer","Free Fire",R.drawable.deivfg));
        lstStreamer.add(new Streamer("ROGISH","Categorie Streamer","LOL, cosa fea",R.drawable.rogish));
        lstStreamer.add(new Streamer("DeivFG","Categorie Streamer","Free Fire",R.drawable.deivfg));

        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        AdaptadorRecyclerView myAdapter = new AdaptadorRecyclerView(this, lstStreamer);
        myrv.setLayoutManager(new GridLayoutManager(this,3));
        myrv.setAdapter(myAdapter);


    }
}
