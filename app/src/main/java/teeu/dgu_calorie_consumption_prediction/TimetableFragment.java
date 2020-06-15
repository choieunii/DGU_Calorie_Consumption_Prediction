package teeu.dgu_calorie_consumption_prediction;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Repository;
import model.TimeTableItem;
import teeu.dgu_calorie_consumption_prediction.HomeFragment.SpinnerAdapter;

public class TimetableFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    private Spinner mDaySpinner;
    private Spinner mTimeSpinner;
    private Spinner mSpotSpinner;

    private ArrayAdapter<String> mDaySpinnerAdapter;
    private ArrayAdapter<String> mTimeSpinnerAdapter;
    private ArrayAdapter<String> mSpotSpinnerAdapter;

    private Button mAddBtn;

    private String tempDay;
    private String tempTime;
    private String tempSpot;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDaySpinnerAdapter = new SpinnerAdapter(getContext(), android.R.layout.simple_spinner_item);
        mTimeSpinnerAdapter = new SpinnerAdapter(getContext(), android.R.layout.simple_spinner_item);
        mSpotSpinnerAdapter = new SpinnerAdapter(getContext(), android.R.layout.simple_spinner_item);

        mDaySpinnerAdapter.clear();
        mTimeSpinnerAdapter.clear();
        mSpotSpinnerAdapter.clear();

        mDaySpinnerAdapter.addAll(Repository.getInstance().getDayList());
        mTimeSpinnerAdapter.addAll(Repository.getInstance().getTimeList());
        mSpotSpinnerAdapter.addAll(Repository.getInstance().getSpotList());
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_timetable, container, false);

        mDaySpinner = v.findViewById(R.id.spinner_lecture_day);
        mTimeSpinner = v.findViewById(R.id.spinner_lecture_time);
        mSpotSpinner = v.findViewById(R.id.spinner_lecture_spot);

        mDaySpinner.setAdapter(mDaySpinnerAdapter);
        mTimeSpinner.setAdapter(mTimeSpinnerAdapter);
        mSpotSpinner.setAdapter(mSpotSpinnerAdapter);

        mDaySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tempDay = (String) adapterView.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mTimeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tempTime = (String) adapterView.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mSpotSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tempSpot = (String) adapterView.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mRecyclerView = v.findViewById(R.id.recyclerView_timetable);

        mRecyclerViewAdapter = new RecyclerViewAdapter(getSortList());
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        mRecyclerView.setAdapter(mRecyclerViewAdapter);

        mAddBtn = v.findViewById(R.id.btn_add_timetable);

        mAddBtn.setOnClickListener(view -> {
            Repository repo = Repository.getInstance();
//            List<TimeTableItem> list = repo.getTimeTableItemList();
//            list.add(new TimeTableItem(tempDay, tempTime, tempSpot));
            addDayList(repo, tempDay, tempTime, tempSpot);

            mRecyclerViewAdapter.setTimeTableList(getSortList());
            Toast.makeText(getContext(), "추가 완료", Toast.LENGTH_SHORT).show();
        });

        return v;
    }

    private List<TimeTableItem> getSortList() {
        Repository repo = Repository.getInstance();
        List<TimeTableItem> monList = repo.getMonList();
        Collections.sort(monList, (t1, t2) -> t1.getTime().compareTo(t2.getTime()));

        List<TimeTableItem> tueList = repo.getTueList();
        Collections.sort(tueList, (t1, t2) -> t1.getTime().compareTo(t2.getTime()));

        List<TimeTableItem> wedList = repo.getWedList();
        Collections.sort(wedList, (t1, t2) -> t1.getTime().compareTo(t2.getTime()));

        List<TimeTableItem> thuList = repo.getThuList();
        Collections.sort(thuList, (t1, t2) -> t1.getTime().compareTo(t2.getTime()));

        List<TimeTableItem> friList = repo.getFriList();
        Collections.sort(friList, (t1, t2) -> t1.getTime().compareTo(t2.getTime()));

        List<TimeTableItem> timeTableItemList = new ArrayList<>();

        timeTableItemList.addAll(monList);
        timeTableItemList.addAll(tueList);
        timeTableItemList.addAll(wedList);
        timeTableItemList.addAll(thuList);
        timeTableItemList.addAll(friList);

        return timeTableItemList;
    }
    private void addDayList(Repository repo, String day, String time, String spot) {
        if (day.equals("월요일")) repo.getMonList().add(new TimeTableItem(day, time, spot));
        else if (day.equals("화요일")) repo.getTueList().add(new TimeTableItem(day, time, spot));
        else if (day.equals("수요일")) repo.getWedList().add(new TimeTableItem(day, time, spot));
        else if (day.equals("목요일")) repo.getThuList().add(new TimeTableItem(day, time, spot));
        else if (day.equals("금요일")) repo.getFriList().add(new TimeTableItem(day, time, spot));
    }

    private void removeDayList(Repository repo, String day, Object o) {
        if (day.equals("월요일")) repo.getMonList().remove(o);
        else if (day.equals("화요일")) repo.getTueList().remove(o);
        else if (day.equals("수요일")) repo.getWedList().remove(o);
        else if (day.equals("목요일")) repo.getThuList().remove(o);
        else if (day.equals("금요일")) repo.getFriList().remove(o);
    }

    private void updateDayList(Repository repo, String day, String time, String spot, Object o) {
        if (day.equals("월요일")) {
            int i = repo.getMonList().indexOf(o);
            repo.getMonList().get(i).setDay(day);
            repo.getMonList().get(i).setTime(time);
            repo.getMonList().get(i).setSpot(spot);
        } else if (day.equals("화요일")) {
            int i = repo.getTueList().indexOf(o);
            repo.getTueList().get(i).setDay(day);
            repo.getTueList().get(i).setTime(time);
            repo.getTueList().get(i).setSpot(spot);
        } else if (day.equals("수요일")) {
            int i = repo.getWedList().indexOf(o);
            repo.getWedList().get(i).setDay(day);
            repo.getWedList().get(i).setTime(time);
            repo.getWedList().get(i).setSpot(spot);
        } else if (day.equals("목요일")) {
            int i = repo.getThuList().indexOf(o);
            repo.getThuList().get(i).setDay(day);
            repo.getThuList().get(i).setTime(time);
            repo.getThuList().get(i).setSpot(spot);
        } else if (day.equals("금요일")) {
            int i = repo.getFriList().indexOf(o);
            repo.getFriList().get(i).setDay(day);
            repo.getFriList().get(i).setTime(time);
            repo.getFriList().get(i).setSpot(spot);
        }

    }

    class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
        List<TimeTableItem> timeTableList;

        public RecyclerViewAdapter(List<TimeTableItem> list) {
            timeTableList = list;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_timetable, parent, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
            final TimeTableItem item = timeTableList.get(i);
            holder.day.setText(item.getDay());
            holder.time.setText(item.getTime());
            holder.spot.setText(item.getSpot());

            holder.itemView.setOnClickListener(view -> {
                String[] items = {"변경", "삭제"};

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("메뉴");
                builder.setItems(items, (dialog, which) -> {
                    if (which == 0) { //수정
                        AlertDialog.Builder bd = new AlertDialog.Builder(getContext());
                        EditText day = new EditText(getContext());
                        EditText time = new EditText(getContext());
                        EditText spot = new EditText(getContext());

                        day.setText(item.getDay());
                        time.setText(item.getTime());
                        spot.setText(item.getSpot());

                        bd.setTitle("시간표 변경");
                        bd.setMessage("변경 후 확인");
                        bd.setView(day).setView(time).setView(spot);

                        bd.setNegativeButton("취소", null).
                                setPositiveButton("확인", (dialogInterface, which2) -> {
                                    Repository repo = Repository.getInstance();
//                                    List<TimeTableItem> list = repo.getTimeTableItemList();
                                    String tempDay = day.getText().toString();
                                    String tempTime = time.getText().toString();
                                    String tempSpot = spot.getText().toString();

//                                    list.get(i).setDay(tempDay);
//                                    list.get(i).setTime(tempTime);
//                                    list.get(i).setSpot(tempSpot);

                                    updateDayList(repo, tempDay, tempTime, tempSpot, item);

                                    mRecyclerViewAdapter.setTimeTableList(getSortList());
                                    Toast.makeText(getContext(), "변경 완료", Toast.LENGTH_SHORT).show();
                                }).create().show();

                    } else if (which == 1) { //삭제
                        Repository repo = Repository.getInstance();
//                        List<TimeTableItem> list = repo.getTimeTableItemList();
//                        list.remove(i);
                        removeDayList(repo,item.getDay(),item);
                        mRecyclerViewAdapter.setTimeTableList(getSortList());
                        Toast.makeText(getContext(), "삭제 완료", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.create().show();

            });
        }

        @Override
        public int getItemCount() {
            return timeTableList.size();
        }

        public void setTimeTableList(List<TimeTableItem> list) {
            timeTableList = list;
            notifyDataSetChanged();
        }
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView day;
        TextView time;
        TextView spot;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.list_item_day);
            time = itemView.findViewById(R.id.list_item_time);
            spot = itemView.findViewById(R.id.list_item_spot);
        }
    }
}