package com.example.footballcalendar.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.footballcalendar.NotificationScreen.NotificationToday;
import com.example.footballcalendar.R;

import java.util.List;

public class NotificationTodayAdapter extends RecyclerView.Adapter<NotificationTodayAdapter.NotificationTodayViewHolder>{

    private Context mContext;
    private List<NotificationToday> mListNotificationToday;

    public NotificationTodayAdapter(Context mContext) {
        this.mContext = mContext;
    }
    public void setData(List<NotificationToday> list){
        this.mListNotificationToday = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotificationTodayViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification_today, parent, false);
        return new NotificationTodayViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationTodayViewHolder holder, int position) {
        NotificationToday notificationToday = mListNotificationToday.get(position);
        if (notificationToday == null){
            return;
        }

        holder.img1.setImageResource(notificationToday.getResoureId1());
        holder.img2.setImageResource(notificationToday.getResoureId2());
        holder.tvDes.setText(notificationToday.getDes());
        holder.tvTime.setText(notificationToday.getTime());

    }

    @Override
    public int getItemCount() {
        if (mListNotificationToday !=null){
            return mListNotificationToday.size();
        }
        return 0;
    }

    public class NotificationTodayViewHolder extends RecyclerView.ViewHolder{

        private ImageView img1, img2;
        private TextView tvDes, tvTime;

        public NotificationTodayViewHolder(@NonNull View itemView) {
            super(itemView);

            img1 = itemView.findViewById(R.id.imgClub1);
            img2 = itemView.findViewById(R.id.imgClub2);
            tvDes = itemView.findViewById(R.id.tvDes);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }
}
