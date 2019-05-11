package com.example.lab3fragments.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.lab3fragments.FormActivity;
import com.example.lab3fragments.Models.Persona;
import com.example.lab3fragments.R;

import java.util.PropertyResourceBundle;

public class FormFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_form, container, false);
        setupUI(view);;
        return view;
    }

    private void setupUI (final View view){
        Button btnSave = (Button) view.findViewById(R.id.btnSaveForm);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Send information to another Fragment
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ResultFormFragment fragment3 = new ResultFormFragment();
                Bundle bundle = new Bundle();
                Persona obj = collectInfo(view); //Our Persona Object
                bundle.putSerializable("Persona", obj);
                fragment3.setArguments(bundle);
                ft.replace(android.R.id.content, fragment3);
                ft.addToBackStack(null); //Add fragment in back stack
                ft.commit();
            }
        });
    }

    private Persona collectInfo(View view){
        String name =  ((EditText) view.findViewById(R.id.txtName)).getText().toString();
        String lastName =  ((EditText) view.findViewById(R.id.txtLastName)).getText().toString();
        String phoneNumber =  ((EditText) view.findViewById(R.id.txtPhoneNumber)).getText().toString();
        String email =  ((EditText) view.findViewById(R.id.txtEmail)).getText().toString();

        Persona persona = new Persona(name, lastName, phoneNumber, email);

        return persona;
    }
}
