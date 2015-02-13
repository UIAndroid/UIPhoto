package net.nc.uiphoto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	private Button btnViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnViewPager = (Button) findViewById(R.id.btn_viewpager);
		btnViewPager.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_viewpager:
			startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
			break;

		default:
			break;
		}
		
	}
	
}
