package com.fachrulziyyan.readify;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Set up click listeners for each category
        view.findViewById(R.id.layoutNovel).setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), NovelActivity.class);
            startActivity(intent);
        });

        view.findViewById(R.id.layoutKomik).setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), KomikActivity.class);
            startActivity(intent);
        });

        view.findViewById(R.id.layoutMajalah).setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), MajalahActivity.class);
            startActivity(intent);
        });

        view.findViewById(R.id.layoutPelajaran).setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PelajaranActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
