package fritte.tuto.info.activity;

import fritte.tuto.info.R;
import fritte.tuto.info.librarycrouton.Crouton;
import fritte.tuto.info.librarycrouton.Style;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TutoCroutonEtToast extends Activity implements OnClickListener {

	private Button toast;
	private Button crouton_info;
	private Button crouton_ok;
	private Button crouton_error;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/** recuperation de la vue */
		setContentView(R.layout.tutocroutontoast_view);

		/** definition des boutons venant de la vue */
		toast = (Button) findViewById(R.id.button1);
		crouton_info = (Button) findViewById(R.id.button2);
		crouton_ok = (Button) findViewById(R.id.button3);
		crouton_error = (Button) findViewById(R.id.button4);

		/** assignation d'evenement aux boutons */
		toast.setOnClickListener(this);
		crouton_info.setOnClickListener(this);
		crouton_ok.setOnClickListener(this);
		crouton_error.setOnClickListener(this);
	}

	public void onClick(View v) {
		/** test de l'id de l'evenement pour connaitre sur quoi on a cliqué */
		switch (v.getId()) {
		/** bouton toast */
		case R.id.button1:
			/** le toast a besoin d'un context pour être créé, un text (possible de faire via getString(R.string. ...) et un temps défini */
			Toast.makeText(getApplicationContext(), "Toast de base", Toast.LENGTH_LONG).show();
			break;
		/** bouton crouton Info */
		case R.id.button2:
			/** Crouton a besoin d'un activity, pour connaitre le context et surtout la vue, car il va créer une vue qui sera en "Header".
			 * Dès ce moment, il peut générer cette vue, sur la vue de l'activité qui l'a appelé
			 * Si vous faites un Crouton dans une dialogue, la vue de crouton sera affiché dans la dialogue, pas sur le main */
			Crouton.makeText(this, "Crouton INFO !", Style.INFO).show();
			break;
		/** bouton crouton OK */
		case R.id.button3:
			Crouton.makeText(this, "Crouton CONFIRM !", Style.CONFIRM).show();
			break;
		/** bouton crouton erreur */
		case R.id.button4:
			Crouton.makeText(this, "Crouton ALERT !", Style.ALERT).show();
			break;
		}
	}
}
