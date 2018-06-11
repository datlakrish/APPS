package com.w3soft.chatapp.w3chat;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

class TabsPagerAdapter extends FragmentStatePagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Fragment reqfragment = new RequestFragment();
                return reqfragment;
            case 1:
                Fragment chatfragment = new ChatFragment();
                return chatfragment;
            case 2:
                Fragment frndfragment = new FriendFragment();
                return frndfragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Request";
            case 1:
                return "Chat";
            case 2:
                return "Friends";
            default:
                return null;
        }
    }
}
