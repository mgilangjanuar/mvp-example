package com.mgilangjanuar.dev.mvpexample.module.dashboard.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mgilangjanuar.dev.mvpexample.R;
import com.mgilangjanuar.dev.mvpexample.module.dashboard.model.MessageResponseModel;
import com.mgilangjanuar.dev.mvpexample.util.InflaterViewAdapterHelper;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mgilangjanuar (mgilangjanuar@gmail.com)
 *
 * @since 2018
 */

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {

    private List<MessageResponseModel.MessageModel> messages;

    public DashboardAdapter(List<MessageResponseModel.MessageModel> messages) {
        this.messages = messages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(InflaterViewAdapterHelper.inflate(R.layout.layout_dashboard_message, parent));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MessageResponseModel.MessageModel model = messages.get(position);
        holder.from.setText(model.from);
        holder.message.setText(model.message);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.from)
        TextView from;

        @BindView(R.id.message)
        TextView message;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
