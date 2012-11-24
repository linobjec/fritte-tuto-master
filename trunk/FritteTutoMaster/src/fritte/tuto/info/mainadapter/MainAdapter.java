package fritte.tuto.info.mainadapter;

import java.util.ArrayList;

import fritte.tuto.info.R;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MainAdapter extends BaseAdapter {

	private ViewHolder holder;
	private LayoutInflater inflater;
	private Context context;
	private ArrayList<String> listeActivities;

	public MainAdapter(Context applicationContext, ArrayList<String> activities) {
		context = applicationContext;
		inflater = LayoutInflater.from(applicationContext);
		listeActivities = activities;
	}

	public int getCount() {
		return listeActivities.size();
	}

	public Object getItem(int id) {
		return listeActivities.get(id);
	}

	public long getItemId(int id) {
		return id;
	}

	public View getView(int pos, View view, ViewGroup viewGroup) {
		if (view == null) {
			view = inflater.inflate(R.layout.list_adapter, null);
			holder = new ViewHolder();
			holder.title = (TextView) view.findViewById(R.id.title);
			holder.img = (ImageView) view.findViewById(R.id.img);
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		
		holder.title.setText(listeActivities.get(pos));
		holder.img.setImageDrawable(switchDrawable(pos));
		
		return view;
	}

	private Drawable switchDrawable(int pos) {
		Drawable icon = null;
		switch (pos) {
		case 0:
			icon = context.getResources().getDrawable(R.drawable.ic_action_alert);
			break;
		case 1:
			icon = context.getResources().getDrawable(R.drawable.ic_action_mail);
			break;
		}
		return icon;
	}

}
