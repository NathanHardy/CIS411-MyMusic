package com.wesleyreisz.mymusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wesleyreisz.mymusic.model.Song;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by jvhard01 on 10/19/2014.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    private SimpleDateFormat df = new SimpleDateFormat("MMM d, yyyy (EEE)");
    private Context mContext;
    private List<Song> mEntries;

    public SongAdapter(Context context, int textViewResourceId, List<Song> entries) {
        super(context, textViewResourceId, entries);
        mContext = context;
        mEntries = entries;


    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view==null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listview_one_song, parent, false);
        }
        final Song song = mEntries.get(position);

        TextView textViewTitle = (TextView)view.findViewById(R.id.songTitleTextView);
                textViewTitle.setText(song.getSongTitle());

        TextView textViewArtist = (TextView)view.findViewById(R.id.artistTextView);
                textViewArtist.setText(song.getArtistName());

        TextView textViewPublishedDate = (TextView)view.findViewById(R.id.publishDateTextView);
                textViewPublishedDate.setText(df.format(song.getSongPublishedDate()));

        TextView textViewAlbumTitle = (TextView)view.findViewById(R.id.albumTitleTextView);
                textViewAlbumTitle.setText(song.getAlbumTitle());

        TextView textViewLastUpdated = (TextView)view.findViewById(R.id.lastUpdatedTextView);
                textViewLastUpdated.setText(df.format(song.getLastUpdatedDate()));

        //TextView textViewYoutubeID = (TextView)view.findViewById(R.id.youtubeIDTextView);
                //textViewYoutubeID.setText(df.format(song.getYoutubeId()));
        return view;
    }
}
