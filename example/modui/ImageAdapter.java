package com.example.modui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;

	public ImageAdapter(Context c) {
		mContext = c;
	}

	public int getCount() {
		return 32767;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		CustomDrawableView cdv;
		if (convertView == null) {
			cdv = new CustomDrawableView(mContext, position);
			cdv.setLayoutParams(new GridView.LayoutParams(75, 150));
			cdv.setPadding(2, 2, 2, 2);
		}
		else {
			cdv = (CustomDrawableView) convertView;
		}
		return cdv;

	}

}
