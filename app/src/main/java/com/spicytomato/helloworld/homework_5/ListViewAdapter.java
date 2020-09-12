package com.spicytomato.helloworld.homework_5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.spicytomato.helloworld.R;

import java.util.List;

public class ListViewAdapter extends ListAdapter<Member, ListViewAdapter.InnerHolder> {
    private OnClickListener listener;

    protected ListViewAdapter() {
        super(new DiffUtil.ItemCallback<Member>() {
            @Override
            public boolean areItemsTheSame(@NonNull Member oldItem, @NonNull Member newItem) {
                if (oldItem == newItem){
                    return true;
                }
                return false;
            }

            @Override
            public boolean areContentsTheSame(@NonNull Member oldItem, @NonNull Member newItem) {
                if (oldItem.getId() == newItem.getId() &&
                oldItem.getName() == newItem.getName()){
                    return true;
                }
                return false;
            }
        });
    }

    @NonNull
    @Override
    public InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.phonemember_layout,null,false);

        return new InnerHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InnerHolder holder, int position) {
        holder.mTextViewId.setText(getItem(position).getId());
        holder.mTextViewName.setText(getItem(position).getName());

        if (listener != null) {
            listener.onClick(position);
        }
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        private final TextView mTextViewId;
        private final TextView mTextViewName;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);

            mTextViewId = itemView.findViewById(R.id.cell_id);

            mTextViewName = itemView.findViewById(R.id.cell_name);
        }
    }

    public interface OnClickListener{
        void onClick(int position);
    }

    public void setOnClickListener(OnClickListener listener){
        this.listener = listener;
    }
}
