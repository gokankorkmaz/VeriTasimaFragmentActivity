package kodluyoruz.com.bveritasimafragmentactivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class NewFragment extends Fragment implements View.OnClickListener {


    //3 Edittext ve Button Tanımlamaları
    EditText fragment_new_edtName;
    EditText fragment_new_edtSurname;
    EditText fragment_new_edtNumber;
    Button fragment_new_btnSend;
    //Değişkenler
    String name, surname, number;

    private OnFragmentInteractionListener mListener;


    public NewFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        //onCreteView içinde inflate.inflate komutlarını kullanarak fragment'in bağlı olduğu layout dosyasını gösteriyoruz.

        View view = inflater.inflate(R.layout.fragment_new, container, false);

        fragment_new_edtName = (EditText) view.findViewById(R.id.fragment_new_edtName);
        fragment_new_edtSurname = (EditText) view.findViewById(R.id.fragment_new_edtSurname);
        fragment_new_edtNumber = (EditText) view.findViewById(R.id.fragment_new_edtNumber);
        fragment_new_btnSend = (Button) view.findViewById(R.id.fragment_new_btnSend);


        //Button OnClick
        fragment_new_btnSend.setOnClickListener(this);

        return view;
    }


    public void onButtonPressed(String name, String surname, String number) {
        if (mListener != null) {
            mListener.onFragmentInteraction(name, surname, number);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {
        name = fragment_new_edtName.getText().toString();
        surname = fragment_new_edtSurname.getText().toString();
        number = fragment_new_edtNumber.getText().toString();
        mListener.onFragmentInteraction(name, surname, number);
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String name, String surname, String number);
    }
}
