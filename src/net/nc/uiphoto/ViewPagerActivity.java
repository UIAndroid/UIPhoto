package net.nc.uiphoto;

import java.util.ArrayList;
import java.util.List;

import net.nc.uiphoto.adapter.SamplePagerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ViewPagerActivity extends Activity implements OnClickListener {
	
	private ViewPager vpImages;

	private SamplePagerAdapter mSamplePagerAdapter;

	private static int currentIndex;
	
	private List<Integer> drawableIds;
	
	private TextView tv1, tv2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager);
		
		vpImages = (ViewPager) findViewById(R.id.vp_images);
		
		tv1 = (TextView) findViewById(R.id.textView1);
		tv2 = (TextView) findViewById(R.id.textView2);
		
		tv1.setOnClickListener(this);
		tv2.setOnClickListener(this);
		
		drawableIds = new ArrayList<Integer>();
		
		setDrawableIds(R.drawable.wallpaper);

		mSamplePagerAdapter = new SamplePagerAdapter(drawableIds);
		vpImages.setAdapter(mSamplePagerAdapter);
		
		vpImages.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				currentIndex = arg0;
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				if (arg0 == 0) {
					mSamplePagerAdapter.notifyDataSetChanged();
				}
			}
		});
	}
	
	private void setDrawableIds(int id){
		drawableIds.clear();
		for(int i=0; i<6; i++){
			drawableIds.add(id);
		}
	}
	
	public static int getCurrentIndex() {
		return currentIndex;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.textView1:
			setDrawableIds(R.drawable.wallpaper);
			mSamplePagerAdapter = new SamplePagerAdapter(drawableIds);
			vpImages.setAdapter(mSamplePagerAdapter);
			break;
		case R.id.textView2:
			setDrawableIds(R.drawable.ic_launcher);
			mSamplePagerAdapter = new SamplePagerAdapter(drawableIds);
			vpImages.setAdapter(mSamplePagerAdapter);
			break;

		default:
			break;
		}
	}

}
