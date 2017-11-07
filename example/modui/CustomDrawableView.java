package com.example.modui;
import android.R.color;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;

public class CustomDrawableView extends View {
	private ShapeDrawable mDrawable;
	private int mIndex;
	private Integer[] colorArray = {
			Color.BLACK, Color.BLUE, Color.CYAN,
			Color.DKGRAY, Color.GRAY, Color.GREEN,
			Color.LTGRAY, Color.MAGENTA, Color.RED,
			Color.WHITE, Color.YELLOW
	};

	private boolean[] changeArray = {
			false, true, true,
			false, false, true,
			false, true, true,
			false, true
	};
	Context mContext;
	public CustomDrawableView(Context context, int index) {
		super(context);
		mContext= context;
		mIndex = index;
		int x = 0;
		int y = 0;
		int width = 300;
		int height = 150;
		this.setWillNotDraw(false);
		mDrawable = new ShapeDrawable(new RectShape());
		mDrawable.setBounds(x, y, x + width, y + height);
	}

	protected void onDraw(Canvas canvas) {
		int offset = 0;
		int color = colorArray[mIndex % colorArray.length];
		float[] hsvColor = {0, 0, 0};
		Color.colorToHSV(color, hsvColor);
		offset = ((MainActivity) mContext).getOffset();
		hsvColor[0] = (hsvColor[0] + offset) % 360;
		color = Color.HSVToColor(hsvColor);
		mDrawable.getPaint().setColor(color);
		mDrawable.draw(canvas);
	}

}
