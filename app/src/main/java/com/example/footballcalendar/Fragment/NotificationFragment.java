package com.example.footballcalendar.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.footballcalendar.NotificationScreen.NotificationToday;
import com.example.footballcalendar.Adapter.NotificationTodayAdapter;
import com.example.footballcalendar.R;
import com.example.footballcalendar.databinding.FragmentNotificationBinding;

import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {

    private NotificationTodayAdapter notificationTodayAdapter,notificationMoreAdapter;

    FragmentNotificationBinding binding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        notificationTodayAdapter = new NotificationTodayAdapter(getActivity());

        notificationMoreAdapter = new NotificationTodayAdapter(getActivity());

        binding = FragmentNotificationBinding.inflate(getLayoutInflater());

        LinearLayoutManager llmToday = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        binding.rcvToday.setLayoutManager(llmToday);

        notificationTodayAdapter.setData(getListNotificationToday());
        binding.rcvToday.setAdapter(notificationTodayAdapter);

        LinearLayoutManager llmMore = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        binding.rcvMore.setLayoutManager(llmMore);

        notificationMoreAdapter.setData(getListNotificationMore());
        binding.rcvMore.setAdapter(notificationMoreAdapter);



        return binding.getRoot();
    }

    private List<NotificationToday> getListNotificationToday() {
        List<NotificationToday> list = new ArrayList<>();
        list.add(new NotificationToday(R.drawable.real, R.drawable.barcelona, "This match will take place in five minutes", "03:00 AM"));
        list.add(new NotificationToday(R.drawable.aletico, R.drawable.sevilla, "This match will take place in five minutes", "03:00 AM"));

        return list;
    }

    private List<NotificationToday> getListNotificationMore() {
        List<NotificationToday> list = new ArrayList<>();
        list.add(new NotificationToday(R.drawable.mu, R.drawable.man_city, "This match will take place in five minutes", "03:00 AM"));
        list.add(new NotificationToday(R.drawable.liverpool, R.drawable.arsena, "This match will take place in five minutes", "03:00 AM"));
        list.add(new NotificationToday(R.drawable.chelsea, R.drawable.tottenham_hotspur, "This match will take place in five minutes", "03:00 AM"));


        return list;
    }
}