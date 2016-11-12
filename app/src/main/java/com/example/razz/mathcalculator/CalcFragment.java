package com.example.razz.mathcalculator;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class CalcFragment extends Fragment {

    String[] calculators = {"Percentage","Maximum","Minimum","Absolute Value","Meter to Inch","Celsius To Fahrenheit", "Molar Mass To Gram"};

    public ArrayAdapter<String> mCalculators;

    public CalcFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Add this line in order for this fragment to handle menu events.
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mCalculators =
                new ArrayAdapter<String>(
                        getActivity(),
                        R.layout.activity_listview,
                        R.id.activity_listview_textview,
                        calculators);

        View rootView = inflater.inflate(R.layout.fragment_calc, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listView_calculators);
        listView.setAdapter(mCalculators);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String calc = mCalculators.getItem(position);
                if(position == 0) {
                    Intent intent = new Intent(getActivity(), PercentageActivity.class)
                            .putExtra(Intent.EXTRA_TEXT, calc);
                    startActivity(intent);
                }
                if (position == 1){
                    Intent intent = new Intent(getActivity(),MaximumActivity.class)
                            .putExtra(Intent.EXTRA_TEXT, calc);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getActivity(), calc, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}