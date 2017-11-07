package com.example.modui;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private int offset = 0;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setBackgroundColor(Color.TRANSPARENT);
		gridview.setAdapter(new ImageAdapter(this));

		final SeekBar sb = (SeekBar) findViewById(R.id.seekBarID);
		sb.setMax(360 * 4);
		sb.setProgress(0);
		sb.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				offset = progress;
				gridview.invalidateViews();
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				gridview.invalidateViews();
			}
		});
	}

	public int getOffset() {
		return offset;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		FragmentManager fm = getFragmentManager();
		Moma m = new Moma();
		m.show(fm, "fragment_edit_name");
		return super.onOptionsItemSelected(item);
	}
}
