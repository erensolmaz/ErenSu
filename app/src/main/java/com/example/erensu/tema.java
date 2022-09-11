package com.example.erensu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.erensu.ui.anasayfa.AnasayfaViewModel;

import org.jetbrains.annotations.NotNull;

public class tema extends Fragment {

    Switch bumb;
    TextView mod;
    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_tema, container, false);
        bumb = (Switch) root.findViewById(R.id.bumb);
        mod = (TextView) root.findViewById(R.id.mod);
        bumb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked==true) {
                    Toast.makeText(getActivity(), "Gece moduna geçildi", Toast.LENGTH_SHORT).show();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    mod.setText("Gündüz Moduna Geç");
                }else{
                    Toast.makeText(getActivity(), "Gündüz moduna geçildi", Toast.LENGTH_SHORT).show();
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    mod.setText("Gece Moduna Geç");
                }
                //Intent intent = new Intent(getActivity(), UrunlerActivity.class);
                //startActivity(intent);
            }
        });

        return root;
    }
}