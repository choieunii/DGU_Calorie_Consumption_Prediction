package teeu.dgu_calorie_consumption_prediction;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import java.util.Map;

import model.Repository;
import model.ResultData;

public class HomeFragment extends Fragment {
    private Spinner mSrcSpinner;
    private Spinner mDestSpinner;
    private ArrayAdapter<String> mSrcSpinnerAdapter;
    private ArrayAdapter<String> mDestSpinnerAdapter;

    private TextView mTextViewTime;
    private TextView mTextViewDistance;
    private TextView mTextViewCalorie;

    private Button mButtonOk;

    private String tempSrc;
    private String tempDest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSrcSpinnerAdapter = new SpinnerAdapter(getContext(), android.R.layout.simple_spinner_item);
        mDestSpinnerAdapter = new SpinnerAdapter(getContext(), android.R.layout.simple_spinner_item);

        mSrcSpinnerAdapter.clear();
        mDestSpinnerAdapter.clear();

        mSrcSpinnerAdapter.addAll(Repository.getInstance().getSpotList());
        mDestSpinnerAdapter.addAll(Repository.getInstance().getSpotList());
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        mSrcSpinner = v.findViewById(R.id.spinner_src);
        mDestSpinner = v.findViewById(R.id.spinner_dest);

        mSrcSpinner.setAdapter(mSrcSpinnerAdapter);
        mDestSpinner.setAdapter(mDestSpinnerAdapter);

        mSrcSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tempSrc = (String) adapterView.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mDestSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tempDest = (String) adapterView.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mTextViewTime = v.findViewById(R.id.textView_time);
        mTextViewDistance = v.findViewById(R.id.textView_distance);
        mTextViewCalorie = v.findViewById(R.id.textView_calorie);
        mButtonOk = v.findViewById(R.id.btn_ok);

        mButtonOk.setOnClickListener(view -> {
            String key = tempSrc + '_' + tempDest;
            Map<String, ResultData> map = Repository.getInstance().getSrcToDestMap();
            ResultData resultData = map.get(key);

            if(resultData != null) {
                String arrivalTime = resultData.getArrivalTime() + "분";
                String distance = resultData.getDistance() + "km";
                String calorie = resultData.getCalorie() + "kcal";
                mTextViewTime.setText(arrivalTime);
                mTextViewDistance.setText(distance);
                mTextViewCalorie.setText(calorie);
            } else {
                String str = "No Data";
                mTextViewTime.setText(str);
                mTextViewDistance.setText(str);
                mTextViewCalorie.setText(str);
            }
        });

        return v;
    }

    public static class SpinnerAdapter extends ArrayAdapter<String> {
        private final LayoutInflater mInflater;
        private final int mResource;

        public SpinnerAdapter(@NonNull Context context, int textViewResourceId) {
            super(context, textViewResourceId);
            mInflater = LayoutInflater.from(context);
            mResource = textViewResourceId;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            final View view = mInflater.inflate(mResource, parent, false);
            ((TextView) view).setText(getItem(position));
            return view;
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            final View view = mInflater.inflate(mResource, parent, false);
            ((TextView) view).setText(getItem(position));
            return view;
        }
    }
}