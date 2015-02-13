package net.nc.uiphoto;

import uk.co.senab.photoview.PhotoView;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class ViewPagerActivity extends Activity {
	
	private ViewPager vpImages;

	private SamplePagerAdapter mSamplePagerAdapter;

	private static int currentIndex;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager);
		
		vpImages = (ViewPager) findViewById(R.id.vp_images);

		mSamplePagerAdapter = new SamplePagerAdapter();
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
	
	static class SamplePagerAdapter extends PagerAdapter {

		private static final int[] sDrawables = { R.drawable.wallpaper,
				R.drawable.wallpaper, R.drawable.wallpaper,
				R.drawable.wallpaper, R.drawable.wallpaper,
				R.drawable.wallpaper };

		@Override
		public int getCount() {
			return sDrawables.length;
		}

		@Override
		public View instantiateItem(ViewGroup container, int position) {
			PhotoView photoView = new PhotoView(container.getContext());
			photoView.setImageResource(sDrawables[position]);
			photoView.setTag(position);

			// Now just add PhotoView to ViewPager and return it
			container.addView(photoView, LayoutParams.MATCH_PARENT,
					LayoutParams.MATCH_PARENT);

			return photoView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public int getItemPosition(Object object) {
			PhotoView photoView = (PhotoView) object;
			int currentPage = getCurrentIndex(); 
			if (currentPage == (Integer) photoView.getTag()) {
				return POSITION_NONE;
			} else {
				return POSITION_UNCHANGED;
			}
		}

	}

	public static int getCurrentIndex() {
		return currentIndex;
	}

}
