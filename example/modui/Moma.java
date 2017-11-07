package com.example.modui;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;


public class Moma extends DialogFragment {
	static private final String URL = "http://www.moma.org";
	static private final String TAG = "LaunchMOMADialog";

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		builder.setMessage(R.string.description)
		.setPositiveButton(R.string.visitmoma, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				startImplicitActivation();
			}
		})
		.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
			}
		});
		return builder.create();
	}

	private void startImplicitActivation() {

		Log.i(TAG, "Entered startImplicitActivation()");

		Intent baseIntent = null;
		baseIntent = new Intent(Intent.ACTION_VIEW);
		baseIntent.setData(Uri.parse(URL));
		Intent chooserIntent = null;
		chooserIntent = Intent.createChooser(baseIntent, "Who do you love?");
		Log.i(TAG,"Chooser Intent Action:" + chooserIntent.getAction());
		startActivity(chooserIntent);
	}
}
