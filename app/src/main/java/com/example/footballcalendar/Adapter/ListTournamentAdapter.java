package com.example.footballcalendar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.footballcalendar.R;

public class ListTournamentAdapter extends BaseAdapter {

    Context context;
    String[] flNameClub1, flScore1, flNameClub2, flScore2, flResult;
    int[] image1, image2;

    LayoutInflater inflater;

    public ListTournamentAdapter(Context context, String[] flNameClub1, String[] flScore1, String[] flNameClub2, String[] flScore2, String[] flResult, int[] image1, int[] image2) {
        this.context = context;
        this.flNameClub1 = flNameClub1;
        this.flScore1 = flScore1;
        this.flNameClub2 = flNameClub2;
        this.flScore2 = flScore2;
        this.flResult = flResult;
        this.image1 = image1;
        this.image2 = image2;
    }

    @Override
    public int getCount() {
        return flResult.length;
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
        if (inflater == null)
            inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null){

            convertView =inflater.inflate(R.layout.listview_tournament, null);
        }


        TextView textClub1 = convertView.findViewById(R.id.tvClub1);
        TextView textClub2 = convertView.findViewById(R.id.tvClub2);
        TextView textScore1 = convertView.findViewById(R.id.tvScore1);
        TextView textScore2 = convertView.findViewById(R.id.tvScore2);
        TextView textResult = convertView.findViewById(R.id.tvResult);
        ImageView imageView1 = convertView.findViewById(R.id.imgClub1);
        ImageView imageView2 = convertView.findViewById(R.id.imgClub2);

        textClub1.setText(flNameClub1[position]);
        textClub2.setText(flNameClub2[position]);
        textScore1.setText(flScore1[position]);
        textScore2.setText(flScore2[position]);
        textResult.setText(flResult[position]);
        imageView1.setImageResource(image1[position]);
        imageView2.setImageResource(image2[position]);



        return convertView;
    }
}
