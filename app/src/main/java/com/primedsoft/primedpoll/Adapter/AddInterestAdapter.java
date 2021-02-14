package com.primedsoft.primedpoll.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.primedsoft.primedpoll.Activities.CompleteReg;
import com.primedsoft.primedpoll.Models.Data;
import com.primedsoft.primedpoll.Models.Interest;
import com.primedsoft.primedpoll.R;

import java.util.ArrayList;

import static com.facebook.share.internal.DeviceShareDialogFragment.TAG;

public class AddInterestAdapter extends RecyclerView.Adapter<AddInterestAdapter.DataHolder> {
    private ArrayList<Interest> dataArrayList;
    private ArrayList<Interest> selected;
    private Context context;
    private FloatingActionButton addInterestFab;
    SharedPreferences.Editor editor;

    public AddInterestAdapter(ArrayList<Interest> dataList) {
        this.dataArrayList = dataList;
    }

    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        selected = new ArrayList<>();
//        SharedPreferences pref = viewGroup.getContext().getSharedPreferences("DataList", Context.MODE_PRIVATE);

        View view = layoutInflater.inflate(R.layout.add_interest_item, viewGroup, false);
        return new DataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final DataHolder dataHolder, int i) {
        final Interest model = dataArrayList.get(i);
        dataHolder.setTitle(model.getTitle());
        dataHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Interest interest = new Interest();
                interest.setTitle(model.getTitle());
                interest.setId(model.getId());
                selected.add(interest);
                SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(v.getContext());
                SharedPreferences.Editor editor = sharedPrefs.edit();
                Gson gson = new Gson();
                String json = gson.toJson(selected);
                editor.putString("TAG", json);
                editor.commit();
//                Intent intent = new Intent(dataHolder.itemView.getContext(), CompleteReg.class);
//                intent.putParcelableArrayListExtra("Data", selected);
//                dataHolder.itemView.getContext().startActivity(intent);
                Toast.makeText(v.getContext(), model.getId(), Toast.LENGTH_SHORT).show();
                Toast.makeText(v.getContext(), model.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
            }

    @Override
    public int getItemCount() {
        return dataArrayList == null ? 0 : dataArrayList.size();
    }

    public class DataHolder extends RecyclerView.ViewHolder {
        Button addInterestButton;
        public DataHolder(@NonNull View itemView) {
            super(itemView);
            addInterestButton = itemView.findViewById(R.id.add_new_interest_button);
        }

        public void setTitle(String interest) {
            addInterestButton.setText(interest);
        }

    }
}
