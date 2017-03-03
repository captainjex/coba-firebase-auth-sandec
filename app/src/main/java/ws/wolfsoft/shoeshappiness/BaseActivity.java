package ws.wolfsoft.shoeshappiness;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

/**
 * Created by Lab Kom on 1/28/2017.
 */

public class BaseActivity extends AppCompatActivity {
    ProgressDialog vProgressDialog;

    public void showProgressBar(){
        if(vProgressDialog == null){
            vProgressDialog = new ProgressDialog(this);
            vProgressDialog.setCancelable(false);
            vProgressDialog.setMessage("Menunggu...");
        }

        vProgressDialog.show();
    }

    public void hideProgressBar(){
        if(vProgressDialog != null && vProgressDialog.isShowing()){
            vProgressDialog.dismiss();
        }
    }


}
