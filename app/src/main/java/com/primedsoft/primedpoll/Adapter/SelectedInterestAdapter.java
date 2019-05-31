package com.primedsoft.primedpoll.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.primedsoft.primedpoll.Models.Interest;
import com.primedsoft.primedpoll.R;

import java.util.ArrayList;

public class SelectedInterestAdapter extends RecyclerView.Adapter<SelectedInterestAdapter.DataHolder> {
    private ArrayList<Interest> dataArrayList;

    public SelectedInterestAdapter(ArrayList<Interest> dataList) {
        this.dataArrayList = dataList;
    }

    @NonNull
    @Override
    public SelectedInterestAdapter.DataHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.selected_interest_item, viewGroup, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectedInterestAdapter.DataHolder dataHolder, int i) {
        Interest interest = dataArrayList.get(i);
        dataHolder.setTitle(interest.getTitle());
    }

    @Override
    public int getItemCount() {
        return dataArrayList == null ? 0 : dataArrayList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        Button selectedInterestButton;

        public DataHolder(@NonNull View itemView) {
            super(itemView);
            selectedInterestButton = itemView.findViewById(R.id.selected_interest_button);

        }

        public void setTitle(String interest) {
            selectedInterestButton.setText(interest);
        }

    }
}
