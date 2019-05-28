package com.example.contactsgroupdemo;

import android.content.Context;
import android.content.CursorLoader;
import android.net.Uri;
import android.provider.ContactsContract;

/**
 * Group loader for the group list that includes details such as the number of contacts per group
 * and number of groups per account. This list is sorted by account type, account name, where the
 * group names are in alphabetical order. Note that the list excludes default, favorite, and deleted
 * groups.
 */
public final class GroupListLoader extends CursorLoader {

    private final static String[] COLUMNS = new String[] {
            ContactsContract.Groups.ACCOUNT_NAME,
            ContactsContract.Groups.ACCOUNT_TYPE,
            ContactsContract.Groups.DATA_SET,
            ContactsContract.Groups._ID,
            ContactsContract.Groups.TITLE,
            ContactsContract.Groups.RES_PACKAGE,
            ContactsContract.Groups.TITLE_RES,
            ContactsContract.Groups.SUMMARY_COUNT,
    };

    public final static int ACCOUNT_NAME = 0;
    public final static int ACCOUNT_TYPE = 1;
    public final static int DATA_SET = 2;
    public final static int GROUP_ID = 3;
    public final static int TITLE = 4;
    public final static int RES_PACKAGE = 5;
    public final static int TITLE_RES = 6;
    public final static int MEMBER_COUNT = 7;

    private static final Uri GROUP_LIST_URI = ContactsContract.Groups.CONTENT_SUMMARY_URI;

    public GroupListLoader(Context context) {
        super(context, GROUP_LIST_URI, COLUMNS, ContactsContract.Groups.ACCOUNT_TYPE + " NOT NULL AND "
                        + ContactsContract.Groups.ACCOUNT_NAME + " NOT NULL AND " + ContactsContract.Groups.AUTO_ADD + "=0 AND " +
                        ContactsContract.Groups.FAVORITES + "=0 AND " + ContactsContract.Groups.DELETED + "=0", null,
                ContactsContract.Groups.ACCOUNT_TYPE + ", " + ContactsContract.Groups.ACCOUNT_NAME + ", " + ContactsContract.Groups.DATA_SET + ", " +
                        ContactsContract.Groups.TITLE + " COLLATE LOCALIZED ASC");
    }
}