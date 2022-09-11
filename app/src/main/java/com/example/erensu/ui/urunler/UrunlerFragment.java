package com.example.erensu.ui.urunler;

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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.erensu.Anasayfa;
import com.example.erensu.R;
import com.example.erensu.ui.anasayfa.AnasayfaFragment;
import com.google.android.material.snackbar.Snackbar;

public class UrunlerFragment extends Fragment {

    private UrunlerViewModel urunlerViewModel;
    Button button1, button2, button3, button4, button5, button6, button7;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        urunlerViewModel =
                new ViewModelProvider(this).get(UrunlerViewModel.class);
        View root = inflater.inflate(R.layout.fragment_urunler, container, false);
        final TextView textView = root.findViewById(R.id.text_urunler);

        button1 = (Button) root.findViewById(R.id.button1);
        button2 = (Button) root.findViewById(R.id.button2);
        button3 = (Button) root.findViewById(R.id.button3);
        button4 = (Button) root.findViewById(R.id.button4);
        button5 = (Button) root.findViewById(R.id.button5);
        button6 = (Button) root.findViewById(R.id.button6);
        button7 = (Button) root.findViewById(R.id.button7);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Sepete Eklendi.", Toast.LENGTH_SHORT).show();
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Sepete Eklendi.", Toast.LENGTH_SHORT).show();
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Sepete Eklendi.", Toast.LENGTH_SHORT).show();
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Sepete Eklendi.", Toast.LENGTH_SHORT).show();
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Sepete Eklendi.", Toast.LENGTH_SHORT).show();
                button6.setVisibility(View.VISIBLE);
                button7.setVisibility(View.VISIBLE);
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(root, "Satın alma tamamlandı.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
              //  Intent intent = new Intent(getActivity(), Anasayfa.class);
               // startActivity(intent);

                AnasayfaFragment fragment2 = new AnasayfaFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.urunler_frame, fragment2);
                fragmentTransaction.commit();
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button6.setVisibility(View.INVISIBLE);
                button7.setVisibility(View.INVISIBLE);
            }
        });


        urunlerViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}