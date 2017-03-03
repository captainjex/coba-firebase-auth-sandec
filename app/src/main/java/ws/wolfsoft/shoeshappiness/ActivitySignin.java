package ws.wolfsoft.shoeshappiness;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import customfonts.MyEditText;

public class ActivitySignin extends AppCompatActivity {


     ImageView back;

    MyEditText edtEmail;
    MyEditText edtPassword;

    String email;
    String password;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        mAuth = FirebaseAuth.getInstance();

        back = (ImageView)findViewById(R.id.back);
        edtEmail = (MyEditText) findViewById(R.id.edt_signin_email);
        edtPassword = (MyEditText)findViewById(R.id.edt_signin_password);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(ActivitySignin.this,MainActivity.class);
                startActivity(it);
            }
        });
    }

    public void signin(View v){
        email = edtEmail.getText().toString().trim();
        password = edtPassword.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    task.getResult().getUser();
                    Intent i = new Intent(ActivitySignin.this, HalamanUtamaActivity.class);
                    startActivity(i);
                    finish();
                }else{

                    Toast.makeText(ActivitySignin.this, "salah logine", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
