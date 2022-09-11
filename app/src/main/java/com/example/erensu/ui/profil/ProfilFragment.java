package com.example.erensu.ui.profil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.erensu.DBHelper;
import com.example.erensu.R;
import com.example.erensu.UrunlerActivity;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class ProfilFragment extends Fragment {
    private ProfilViewModel profilViewModel;
    private TextView mTextView;
    EditText fullName, mail, password, adres, mail2, password2;
    Button buttonkaydol, buttongiris;
    DBHelper DB;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profilViewModel =
                new ViewModelProvider(this).get(ProfilViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profil, container, false);
        final TextView textView = root.findViewById(R.id.text_profil);

        fullName = (EditText) root.findViewById(R.id.fullName);
        mail = (EditText) root.findViewById(R.id.mail);
        password = (EditText) root.findViewById(R.id.password);
        adres = (EditText) root.findViewById(R.id.adres);
        mail2 = (EditText) root.findViewById(R.id.mail2);
        password2 = (EditText) root.findViewById(R.id.password2);
        buttonkaydol = (Button) root.findViewById(R.id.buttonkaydol);
        buttongiris = (Button) root.findViewById(R.id.buttongiris);
        DB = new DBHelper(getActivity());




        buttonkaydol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Kayıt başarılı", Toast.LENGTH_SHORT).show();
                String name = fullName.getText().toString();
                String user = mail.getText().toString();
                String pass = password.getText().toString();
                String adrs = adres.getText().toString();
                if (user.equals("")||pass.equals(""))
                    Toast.makeText(getActivity(), "Lütfen gerekli alanları doldurunuz", Toast.LENGTH_SHORT).show();

                else {
                    //if(pass.equals(repass)){
                    Boolean checkuser = DB.checkmail(user);
                    // }
                    if(checkuser==false){
                        Boolean insert = DB.insertData(name, user, pass, adrs);
                        if(insert==true){
                            Toast.makeText(getActivity(), "Kayıt başarılı", Toast.LENGTH_SHORT).show();


                        } else{
                            Toast.makeText(getActivity(), "Kayıt başarısız", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getActivity(), "Kullanıcı zaten kayıtlı, giriş yapınız.", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(getActivity(), "Lütfen gerekli alanları doldurunuz", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkmailpassword = DB.checkmailpassword(user, pass);
                    if (checkmailpassword==true){
                        Toast.makeText(getActivity(), "Giriş başarılı!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), UrunlerActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getActivity(), "Giriş Başarısız.", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
        profilViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}