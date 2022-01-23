package com.example.footballcalendar.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballcalendar.Interface.IClickItemTournamentListener;
import com.example.footballcalendar.R;

import java.util.List;

public class TournamentAdapter extends RecyclerView.Adapter<TournamentAdapter.TournamentViewHolder>{

    private Context mContext;
    private List<Tournament> mListTournament;
    private IClickItemTournamentListener iClickItemTournamentListener;



    public TournamentAdapter(List<Tournament> mListTournament, IClickItemTournamentListener listener) {

        this.mListTournament = mListTournament;
        this.iClickItemTournamentListener = listener;
    }

    public void setData(List<Tournament> list){
        this.mListTournament = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TournamentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tournament, parent, false);
        return new TournamentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TournamentViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final Tournament tournament = mListTournament.get(position);
        if (tournament == null){
            return;
        }

        holder.img.setImageResource(tournament.getResoureId());
        holder.tvName.setText(tournament.getName());

        holder.cvTournament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                iClickItemTournamentListener.onClickItemTournament(tournament, position);
//                onClickItem(tournament, position);
            }
        });

    }
//    private void onClickItem(Tournament tournament, int position) {
////        Toast.makeText(mContext.getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();
//        if (position == 0){
//
//        }else if (position == 1){
//            Toast.makeText(mContext.getApplicationContext(), "ok 2", Toast.LENGTH_SHORT).show();
//        }else if (position == 2){
//            Toast.makeText(mContext.getApplicationContext(), "ok 3", Toast.LENGTH_SHORT).show();
//        }else if (position == 3){
//            Toast.makeText(mContext.getApplicationContext(), "ok 4", Toast.LENGTH_SHORT).show();
//        }
////        Intent intent = new Intent(mContext, TestActivity.class);
//////        Bundle bundle = new Bundle();
//////        bundle.putSerializable("obj_tournament", tournament);
//////        intent.putExtra(bundle);
////        mContext.startActivity(intent);
//    }




    @Override
    public int getItemCount() {
        if (mListTournament != null){
            return mListTournament.size();
        }
        return 0;
    }

    public class TournamentViewHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView tvName;
        private CardView cvTournament;


        public TournamentViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.imgTournament);
            tvName = itemView.findViewById(R.id.tvTournament);
            cvTournament = itemView.findViewById(R.id.cvTournament);

        }
    }


}
