package com.example.user.nuik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {


    // UI components
    public Button btnScan1;
    TextView tv_qr_readTxt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnScan1 = (Button) findViewById(R.id.btnScan1);
		tv_qr_readTxt = (TextView) findViewById(R.id.tv_qr_readTxt);
		btnScan1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick (View view){

				IntentIntegrator integrator = new IntentIntegrator(MainActivity.this);
				integrator.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
				integrator.setPrompt("Scan");
				integrator.setCameraId(0);
				integrator.setBeepEnabled(false);
				integrator.setBarcodeImageEnabled(false);
				integrator.initiateScan();

			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
		if(result != null) {
			if(result.getContents() == null) {
				Log.e("Scan*******", "Cancelled scan");

			} else {
				Log.e("Scan", "Scanned");

				tv_qr_readTxt.setText(result.getContents());
				Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
			}
		} else {
			// This is important, otherwise the result will not be passed to the fragment
			super.onActivityResult(requestCode, resultCode, data);
		}
	}
}