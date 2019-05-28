package com.example.contactsgroupdemo;

/**
 * Meta-data for a contact group.  We load all groups associated with the contact's
 * constituent accounts.
 */
public final class GroupListItem {
    private final String mAccountName;
    private final String mAccountType;
    private final String mDataSet;
    private final long mGroupId;
    private final String mTitle;
    private final boolean mIsFirstGroupInAccount;
    private final int mMemberCount;

    public GroupListItem(String accountName, String accountType, String dataSet, long groupId,
                         String title, boolean isFirstGroupInAccount, int memberCount) {
        mAccountName = accountName;
        mAccountType = accountType;
        mDataSet = dataSet;
        mGroupId = groupId;
        mTitle = title;
        mIsFirstGroupInAccount = isFirstGroupInAccount;
        mMemberCount = memberCount;
    }

    public String getAccountName() {
        return mAccountName;
    }

    public String getAccountType() {
        return mAccountType;
    }

    public String getDataSet() {
        return mDataSet;
    }

    public long getGroupId() {
        return mGroupId;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getMemberCount() {
        return mMemberCount;
    }

    public boolean hasMemberCount() {
        return mMemberCount != -1;
    }

    public boolean isFirstGroupInAccount() {
        return mIsFirstGroupInAccount;
    }
}