//package com.example.demo;
//
//import android.content.Intent;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.lifecycle.Lifecycle;
//import androidx.viewpager2.adapter.FragmentStateAdapter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyFragmentAdapter extends FragmentStateAdapter {
//
//
//    private List<String> data = new ArrayList<>();
//
//    public MyFragmentAdapter() {
//        super();
//    }
//
//    public void setData(List<String> newData) {
//        data.clear();
//        data.addAll(newData);
//        notifyDataSetChanged();
//    }
//
//    public MyFragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
//        super(fragmentManager, lifecycle);
//    }
//
//    @NonNull
//    @Override
//    public Fragment createFragment(int position) {
//        if(position==1){
//
//            return new AppointmentFragment();
//        }
//            return new addmedicine();
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 2;
//    }
//
////    public void setData(List <String> data) {
////        this.data = data;
////        notifyDataSetChanged();
////
////    }
//
//}
