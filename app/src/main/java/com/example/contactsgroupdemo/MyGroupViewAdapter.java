package com.example.contactsgroupdemo;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyGroupViewAdapter extends RecyclerView.Adapter<MyGroupViewAdapter.MyViewHolder> {
    private Context mContext;
    private Cursor mCursor;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.group_info);
        }
    }

    public MyGroupViewAdapter(Context myContext) {
        mContext = myContext;
    }

    @NonNull
    @Override
    public MyGroupViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.group_item, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyGroupViewAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.mTextView.setText(getItem(i).getTitle()+" ("+getItem(i).getMemberCount()+")");
    }

    @Override
    public int getItemCount() {
        return (mCursor == null || mCursor.isClosed()) ? 0 : mCursor.getCount();
    }

    public GroupListItem getItem(int position) {
        if (mCursor == null || mCursor.isClosed() || !mCursor.moveToPosition(position)) {
            return null;
        }
        String accountName = mCursor.getString(GroupListLoader.ACCOUNT_NAME);
        String accountType = mCursor.getString(GroupListLoader.ACCOUNT_TYPE);
        String dataSet = mCursor.getString(GroupListLoader.DATA_SET);
        long groupId = mCursor.getLong(GroupListLoader.GROUP_ID);
        String title = getTitle();
        int memberCount = mCursor.getInt(GroupListLoader.MEMBER_COUNT);

        return new GroupListItem(accountName, accountType, dataSet, groupId, title,
                false, memberCount);
    }

    private String getTitle() {
        String title = null;
        if (title == null) {
            title = mCursor.getString(GroupListLoader.TITLE);
        }
        return title;
    }

    public void setCursor(Cursor cursor) {
        mCursor = cursor;
        notifyDataSetChanged();
    }
}
