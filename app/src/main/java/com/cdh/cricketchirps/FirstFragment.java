package com.cdh.cricketchirps;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.cdh.cricketchirps.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    EditText etChirpsCount;
    Button btnSubmit;
    TextView tvResult;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etChirpsCount = view.findViewById(R.id.etChirpsCount);
        btnSubmit = view.findViewById(R.id.btnSubmit);
        tvResult = view.findViewById(R.id.tvResult);



        tvResult.setVisibility(View.GONE);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etChirpsCount.getText().toString().isEmpty()){
                    Toast toast = Toast.makeText(getActivity(), "Please enter all fields!", Toast.LENGTH_SHORT);
                    toast.show();
                }else {
                    int chirpsCount = Integer.parseInt(etChirpsCount.getText().toString().trim());

                    double temperature = Math.round((chirpsCount / 3.0 + 4.0) * 100.0) / 100.0;

                    String text = getString(R.string.the_approximate_temparature_outside_is) + temperature + getString(R.string.celcius);
                    tvResult.setText(text);
                    tvResult.setVisibility(View.VISIBLE);
                }
            }
        });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}