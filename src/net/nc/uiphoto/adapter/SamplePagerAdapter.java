package net.nc.uiphoto.adapter;

import java.util.List;

import net.nc.uiphoto.ViewPagerActivity;
import uk.co.senab.photoview.PhotoView;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

public class SamplePagerAdapter extends PagerAdapter {

	private List<Integer> drawableIds;
	
	public SamplePagerAdapter(List<Integer> drawableIds){
		this.drawableIds = drawableIds;
	}

	@Override
	public int getCount() {
		return drawableIds.size();
	}

	@Override
	public View instantiateItem(ViewGroup container, int position) {
		PhotoView photoView = new PhotoView(container.getContext());
		photoView.setImageResource(drawableIds.get(position));
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
		int currentPage = ViewPagerActivity.getCurrentIndex(); 
		if (currentPage == (Integer) photoView.getTag()) {
			return POSITION_NONE;
		} else {
			return POSITION_UNCHANGED;
		}
	}

}
