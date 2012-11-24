package fritte.tuto.info;

import java.util.ArrayList;

import fritte.tuto.info.activity.TutoCroutonEtToast;
import fritte.tuto.info.activity.TutoSendMail;
import fritte.tuto.info.mainadapter.MainAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener {

	private ListView listeView;
	
	private MainAdapter adapter;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);
		listeView = (ListView) findViewById(R.id.liste);
		
		ArrayList<String> activities = new ArrayList<String>();
		activities.add("Toast et Crouton");
		activities.add("Mail");

		adapter = new MainAdapter(getApplicationContext(), activities);
		listeView.setAdapter(adapter);
		listeView.setOnItemClickListener(this);

	}

	public void onItemClick(AdapterView<?> arg0, View view, int pos, long arg3) {
		switch (pos) {
		case 0:
			intent = new Intent(this.getApplicationContext(), TutoCroutonEtToast.class);
			break;
		case 1:
			intent = new Intent(this.getApplicationContext(), TutoSendMail.class);
			break;
		}
		startActivity(intent);
	}
}
