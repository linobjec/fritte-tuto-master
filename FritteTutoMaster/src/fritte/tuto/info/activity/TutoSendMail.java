package fritte.tuto.info.activity;

import fritte.tuto.info.R;
import fritte.tuto.info.javamail.Mail;
import fritte.tuto.info.librarycrouton.Crouton;
import fritte.tuto.info.librarycrouton.Style;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class TutoSendMail extends Activity implements OnClickListener{

	public Mail m;
	
	private EditText mailEdit;
	private EditText pwdEdit;
	private EditText toEdit;
	private EditText subjectEdit;
	private Button sendMail;
	
	private String user;
	private String pwd;
	private String to;
	private String subject;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.tutosendmail_view);

		mailEdit = (EditText) findViewById(R.id.editMail);
		pwdEdit  = (EditText) findViewById(R.id.editMdp);
		toEdit = (EditText) findViewById(R.id.editTo);
		subjectEdit = (EditText) findViewById(R.id.editSubject);
		sendMail = (Button) findViewById(R.id.buttonSend);
		/** surtout pas oublier d'assigner le onclick au bouton */
		sendMail.setOnClickListener(this);
		

	}

	/**
	 * AsyncTask pour envoyer le mail
	 * @author fritte
	 *
	 */
	private class SendMail extends AsyncTask<Void, Void, String[]> {
		private boolean envoye;

		@Override
		protected String[] doInBackground(Void... params) {

			/** user et pwd de qui envoie */
			m = new Mail(user, pwd);
			/** a qui j'envoie */
			String[] toArr = { 
								to
								};
			m.set_to(toArr);
			/** le 'from' de qui vient le mail */
			m.set_from(user);
			/** le sujet */
			m.set_subject("Test envoi mail via javamail");
			/** et le message */
			m.set_body(subject);
			try {
				/** l'envoi */
				if (m.send()) {
					envoye = true;
				} else {
					envoye = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
		
		@Override
		protected void onPostExecute(String[] result) {
			super.onPostExecute(result);
			if (envoye) {
				Crouton.makeText(TutoSendMail.this, getString(R.string.envoye), Style.CONFIRM).show();
			} else {
				Crouton.makeText(TutoSendMail.this, getString(R.string.pasenvoye), Style.ALERT).show();
			}
		}
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.buttonSend:
			if (testIfNull()) {
				/** on pourrait même lancer une progressDialogue dans l'action barre, comme pour le refresh G+ etc */
				new SendMail().execute();
			}
			break;
		}
	}

	/**
	 * on peut tester aussi avec un regex les mails s'ils sont correct etc...
	 * @return
	 */
	private boolean testIfNull() {
		boolean OK;
		if (mailEdit.getText().toString().length() > 0 
				&& pwdEdit.getText().toString().length() > 0 
					&& toEdit.getText().toString().length() > 0 
							&& subjectEdit.getText().toString().length() > 0) {

			user = mailEdit.getText().toString();
			pwd = pwdEdit.getText().toString();
			to = toEdit.getText().toString();
			subject = subjectEdit.getText().toString();
			OK = true;
		} else {
			OK = false;
			Crouton.makeText(TutoSendMail.this, getString(R.string.erreur_champs_vides), Style.ALERT).show();
		}
		return OK;
	}
}
