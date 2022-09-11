package com.example.erensu.ui.anasayfa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.erensu.Anasayfa;
import com.example.erensu.MainActivity;
import com.example.erensu.R;
import com.example.erensu.UrunlerActivity;
import com.example.erensu.ui.urunler.Urunler;
import com.example.erensu.ui.urunler.UrunlerFragment;
import com.example.erensu.ui.urunler.UrunlerViewModel;

public class AnasayfaFragment extends Fragment{


    private AnasayfaViewModel anasayfaViewModel;
    Button button;

    public View onCreateView(@NonNull LayoutInflater inflater,
                           ViewGroup container, Bundle savedInstanceState) {

       anasayfaViewModel =
               new ViewModelProvider(this).get(AnasayfaViewModel.class);
        View view = inflater.inflate(R.layout.fragment_anasayfa, container, false);
        final TextView textView = view.findViewById(R.id.text_anasayfa);
        button = (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Toast.makeText(getActivity(), "asdf", Toast.LENGTH_SHORT).show();

                UrunlerFragment fragment2 = new UrunlerFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.anasayfa_frame, fragment2);
                fragmentTransaction.commit();
            }
        });


        return view;

    }}

