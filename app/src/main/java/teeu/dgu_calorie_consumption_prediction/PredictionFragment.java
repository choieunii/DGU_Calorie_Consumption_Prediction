package teeu.dgu_calorie_consumption_prediction;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.List;
import java.util.Map;

import model.Repository;
import model.ResultData;
import model.TimeTableItem;
import teeu.dgu_calorie_consumption_prediction.R;

public class PredictionFragment extends Fragment {
    private TextView mMonDistance;
    private TextView mMonCalorie;

    private TextView mTueDistance;
    private TextView mTueCalorie;

    private TextView mWedDistance;
    private TextView mWedCalorie;

    private TextView mThuDistance;
    private TextView mThuCalorie;

    private TextView mFriDistance;
    private TextView mFriCalorie;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_prediction, container, false);

        mMonDistance = v.findViewById(R.id.prediction_distance_mon);
        mMonCalorie = v.findViewById(R.id.prediction_calorie_mon);

        mTueDistance = v.findViewById(R.id.prediction_distance_tue);
        mTueCalorie = v.findViewById(R.id.prediction_calorie_tue);

        mWedDistance = v.findViewById(R.id.prediction_distance_wed);
        mWedCalorie = v.findViewById(R.id.prediction_calorie_wed);

        mThuDistance = v.findViewById(R.id.prediction_distance_thu);
        mThuCalorie = v.findViewById(R.id.prediction_calorie_thu);

        mFriDistance = v.findViewById(R.id.prediction_distance_fri);
        mFriCalorie = v.findViewById(R.id.prediction_calorie_fri);

        Repository repo = Repository.getInstance();
        setTextMon(repo);
        setTextTue(repo);
        setTextWed(repo);
        setTextThu(repo);
        setTextFri(repo);

//        List<TimeTableItem> list =  Repository.getInstance().getTimeTableItemList();
//        setText(list);
        return v;
    }

    private void setTextMon(Repository repo) {
        List<TimeTableItem> list = repo.getMonList();
        Map<String, ResultData> map = repo.getSrcToDestMap();
        String start = "충무로역";
        double distance = 0;
        int calorie = 0;

        for(TimeTableItem item : list) {
            String spot = item.getSpot();
            String key = start + '_' + spot;
            if(map.get(key) != null) {
                distance += map.get(key).getDistance();
                calorie += map.get(key).getCalorie();
            }

            start = spot;
        }

        String key = start + '_' + "충무로역";
        if(map.get(key) != null) {
            distance += map.get(key).getDistance();
            calorie += map.get(key).getCalorie();
        }

        mMonDistance.setText(String.valueOf(Math.round(distance * 1000.0) / 1000.0)); //소수점 3자리까지 출력
        mMonCalorie.setText(String.valueOf(calorie));
    }

    private void setTextTue(Repository repo) {
        List<TimeTableItem> list = repo.getTueList();
        Map<String, ResultData> map = repo.getSrcToDestMap();
        String start = "충무로역";
        double distance = 0;
        int calorie = 0;

        for(TimeTableItem item : list) {
            String spot = item.getSpot();
            String key = start + '_' + spot;
            if(map.get(key) != null) {
                distance += map.get(key).getDistance();
                calorie += map.get(key).getCalorie();
            }

            start = spot;
        }

        String key = start + '_' + "충무로역";
        if(map.get(key) != null) {
            distance += map.get(key).getDistance();
            calorie += map.get(key).getCalorie();
        }

        mTueDistance.setText(String.valueOf(Math.round(distance * 1000.0) / 1000.0));
        mTueCalorie.setText(String.valueOf(calorie));
    }

    private void setTextWed(Repository repo) {
        List<TimeTableItem> list = repo.getWedList();
        Map<String, ResultData> map = repo.getSrcToDestMap();
        String start = "충무로역";
        double distance = 0;
        int calorie = 0;

        for(TimeTableItem item : list) {
            String spot = item.getSpot();
            String key = start + '_' + spot;
            if(map.get(key) != null) {
                distance += map.get(key).getDistance();
                calorie += map.get(key).getCalorie();
            }

            start = spot;
        }

        String key = start + '_' + "충무로역";
        if(map.get(key) != null) {
            distance += map.get(key).getDistance();
            calorie += map.get(key).getCalorie();
        }

        mWedDistance.setText(String.valueOf(Math.round(distance * 1000.0) / 1000.0));
        mWedCalorie.setText(String.valueOf(calorie));
    }

    private void setTextThu(Repository repo) {
        List<TimeTableItem> list = repo.getThuList();
        Map<String, ResultData> map = repo.getSrcToDestMap();
        String start = "충무로역";
        double distance = 0;
        int calorie = 0;

        for(TimeTableItem item : list) {
            String spot = item.getSpot();
            String key = start + '_' + spot;
            if(map.get(key) != null) {
                distance += map.get(key).getDistance();
                calorie += map.get(key).getCalorie();
            }

            start = spot;
        }

        String key = start + '_' + "충무로역";
        if(map.get(key) != null) {
            distance += map.get(key).getDistance();
            calorie += map.get(key).getCalorie();
        }

        mThuDistance.setText(String.valueOf(Math.round(distance * 1000.0) / 1000.0));
        mThuCalorie.setText(String.valueOf(calorie));
    }

    private void setTextFri(Repository repo) {
        List<TimeTableItem> list = repo.getFriList();
        Map<String, ResultData> map = repo.getSrcToDestMap();
        String start = "충무로역";
        double distance = 0;
        int calorie = 0;

        for(TimeTableItem item : list) {
            String spot = item.getSpot();
            String key = start + '_' + spot;
            if(map.get(key) != null) {
                distance += map.get(key).getDistance();
                calorie += map.get(key).getCalorie();
            }

            start = spot;
        }

        String key = start + '_' + "충무로역";
        if(map.get(key) != null) {
            distance += map.get(key).getDistance();
            calorie += map.get(key).getCalorie();
        }

        mFriDistance.setText(String.valueOf(Math.round(distance * 1000.0) / 1000.0));
        mFriCalorie.setText(String.valueOf(calorie));
    }

//    private void setText(List<TimeTableItem> list) {
//        double[] distance = {0,0,0,0,0};
//        int[] calorie = {0,0,0,0,0};
//        Map<String, ResultData> map = Repository.getInstance().getSrcToDestMap();
//        String start = "충무로역";
//
//        for(TimeTableItem item : list) {
//            String day = item.getDay();
//            String spot = item.getSpot();
//            String key = start + '_' + spot;
//            if(day.equals("월요일")) {
//                if(map.get(key) != null) {
//                    distance[0] += map.get(key).getDistance();
//                    calorie[0] += map.get(key).getCalorie();
//                }
//
//            } else if(day.equals("화요일")) {
//                if(map.get(key) != null) {
//                    distance[1] += map.get(key).getDistance();
//                    calorie[1] += map.get(key).getCalorie();
//                }
//
//            } else if(day.equals("수요일")) {
//                if(map.get(key) != null) {
//                    distance[2] += map.get(key).getDistance();
//                    calorie[2] += map.get(key).getCalorie();
//                }
//            } else if(day.equals("목요일")) {
//                if(map.get(key) != null) {
//                    distance[3] += map.get(key).getDistance();
//                    calorie[3] += map.get(key).getCalorie();
//                }
//            } else if(day.equals("금요일")) {
//                if(map.get(key) != null) {
//                    distance[4] += map.get(key).getDistance();
//                    calorie[4] += map.get(key).getCalorie();
//                }
//            }
//            start = spot;
//        }
//
//        mMonDistance.setText(String.valueOf(distance[0]));
//        mMonCalorie.setText(String.valueOf(calorie[0]));
//
//        mTueDistance.setText(String.valueOf(distance[1]));
//        mTueCalorie.setText(String.valueOf(calorie[1]));
//
//        mWedDistance.setText(String.valueOf(distance[2]));
//        mWedCalorie.setText(String.valueOf(calorie[2]));
//
//        mThuDistance.setText(String.valueOf(distance[3]));
//        mThuCalorie.setText(String.valueOf(calorie[3]));
//
//        mFriDistance.setText(String.valueOf(distance[4]));
//        mFriCalorie.setText(String.valueOf(calorie[4]));
//    }
}