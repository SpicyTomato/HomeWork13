package com.spicytomato.helloworld.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.spicytomato.helloworld.R;

import java.util.List;
import java.util.Map;

public class ViewpagerAdapter extends RecyclerView.Adapter<ViewpagerAdapter.InnerHolder> {



    private List<Mess> mMesses;

    ViewpagerAdapter(List<Mess> mMesses){
        this.mMesses = mMesses;
    }


    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View item = layoutInflater.inflate(R.layout.recyclerview_cell,parent,false);

        return new InnerHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        Mess mess = mMesses.get(position);
        if (mess.getWay().equals("get")){
            holder.mGet_layout.setVisibility(View.VISIBLE);
            holder.mSend_layout.setVisibility(View.INVISIBLE);
            holder.mGet_cell.setText(mess.getContent());
        }else if (mess.getWay().equals("send")){
            holder.mGet_layout.setVisibility(View.INVISIBLE);
            holder.mSend_layout.setVisibility(View.VISIBLE);
            holder.mSend_cell.setText(mess.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return mMesses.size();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {


        private final ConstraintLayout mGet_layout;
        private final ConstraintLayout mSend_layout;
        private final TextView mGet_cell;
        private final TextView mSend_cell;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);

            mGet_layout = itemView.findViewById(R.id.getLayout);
            mSend_layout = itemView.findViewById(R.id.sendLayout);
            mGet_cell = itemView.findViewById(R.id.get_cell);
            mSend_cell = itemView.findViewById(R.id.send_cell);

        }
    }
}
