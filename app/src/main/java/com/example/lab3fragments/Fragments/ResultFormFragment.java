package com.example.lab3fragments.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.lab3fragments.Models.Persona;
import com.example.lab3fragments.R;

import org.w3c.dom.Text;

public class ResultFormFragment extends Fragment {
    public Persona persona = new Persona();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getArguments();
        persona = (Persona) bundle.getSerializable("Persona");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_result_form, container, false);
        setupUI(view);;
        return view;
    }

    private void setupUI(View view){
        //Recibir objetos
        TextView txtName =  (TextView) view.findViewById(R.id.txtResultName);
        TextView txtLastName =  (TextView) view.findViewById(R.id.txtResultLastName);
        TextView txtPhone =  (TextView) view.findViewById(R.id.txtResultPhone);
        TextView txtEmail =  (TextView) view.findViewById(R.id.txtResultEmail);

        //Setear valores
        txtName.setText(persona.getName());
        txtLastName.setText(persona.getLastName());
        txtPhone.setText(persona.getPhoneNumber());
        txtEmail.setText(persona.getEmail());
    }
}
