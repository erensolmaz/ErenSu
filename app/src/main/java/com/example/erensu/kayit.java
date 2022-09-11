package com.example.erensu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class kayit extends AppCompatActivity {

  /**  EditText fullName, mail, password, adres, mail2, password2;
    Button buttonkaydol, buttongiris, bomb;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profil);

        fullName = (EditText) findViewById(R.id.fullName);
        mail = (EditText) findViewById(R.id.mail);
        password = (EditText) findViewById(R.id.password);
        adres = (EditText) findViewById(R.id.adres);
        mail2 = (EditText) findViewById(R.id.mail2);
        bomb = (Button) findViewById(R.id.bomb);
        password2 = (EditText) findViewById(R.id.password2);
        buttonkaydol = (Button) findViewById(R.id.buttonkaydol);
        buttongiris = (Button) findViewById(R.id.buttongiris);
        DB = new DBHelper(this);

        buttonkaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(kayit.this, "Kayıt başarılı", Toast.LENGTH_SHORT).show();
                String name = fullName.getText().toString();
                String user = mail.getText().toString();
                String pass = password.getText().toString();
                String adrs = adres.getText().toString();
                if (user.equals("")||pass.equals(""))
                    Toast.makeText(kayit.this, "Lütfen gerekli alanları doldurunuz", Toast.LENGTH_SHORT).show();
                else {
                    //if(pass.equals(repass)){
                    Boolean checkuser = DB.checkmail(user);
                    // }
                    if(checkuser==false){
                        Boolean insert = DB.insertData(name, user, pass, adrs);
                        if(insert==true){
                            Toast.makeText(kayit.this, "Kayıt başarılı", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(kayit.this, "Kayıt başarısız", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(kayit.this, "Kullanıcı zaten kayıtlı, giriş yapınız.", Toast.LENGTH_SHORT).show();
                    }
                    //else{password uyuşmuyor}
                }

            }
        });

        buttongiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = mail2.getText().toString();
                String pass = password2.getText().toString();

                if (user.equals("")||pass.equals(""))
                    Toast.makeText(kayit.this, "Lütfen gerekli alanları doldurunuz", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkmailpassword = DB.checkmailpassword(user, pass);
                    if (checkmailpassword==true){
                        Toast.makeText(kayit.this, "Giriş başarılı!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),UrunlerActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(kayit.this, "Giriş Başarısız.", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
        bomb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(kayit.this, "bomb", Toast.LENGTH_SHORT).show();
            }
        });
    }
   */
}

