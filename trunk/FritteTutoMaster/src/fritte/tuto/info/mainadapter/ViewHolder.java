package fritte.tuto.info.mainadapter;

import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolder {

	public TextView title;
	public ImageView img;

	public TextView getTitle() {
		return title;
	}

	public void setTitle(TextView title) {
		this.title = title;
	}

	public ImageView getImg() {
		return img;
	}

	public void setImg(ImageView img) {
		this.img = img;
	}

}
