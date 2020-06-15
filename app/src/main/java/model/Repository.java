package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repository {
    private static Repository instance;
    private static List<String> sSpotList;
    private static List<String> sDayList;
    private static List<String> sTimeList;
//    private static List<TimeTableItem> sTimeTableItemList;
    private static Map<String,ResultData> sSrcToDestMap;

    private static List<TimeTableItem> sMonList;
    private static List<TimeTableItem> sTueList;
    private static List<TimeTableItem> sWedList;
    private static List<TimeTableItem> sThuList;
    private static List<TimeTableItem> sFriList;

    private Repository() {
        sSpotList = new ArrayList<>();
        sDayList = new ArrayList<>();
        sTimeList = new ArrayList<>();
//        sTimeTableItemList = new ArrayList<>();
        sSrcToDestMap = new HashMap<>();

        sMonList = new ArrayList<>();
        sTueList = new ArrayList<>();
        sWedList = new ArrayList<>();
        sThuList = new ArrayList<>();
        sFriList = new ArrayList<>();

        initSpot();
        initDay();
        initTime();
        initMap();
    }

    public static Repository getInstance() {
        if(instance == null)
            instance = new Repository();

        return instance;
    }

    public List<String> getSpotList() {
        return sSpotList;
    }

    public List<String> getDayList() {
        return sDayList;
    }

    public List<String> getTimeList() {
        return sTimeList;
    }

//    public List<TimeTableItem> getTimeTableItemList() {
//        return sTimeTableItemList;
//    }

    public Map<String,ResultData> getSrcToDestMap() {
        return sSrcToDestMap;
    }

    public List<TimeTableItem> getMonList() {
        return sMonList;
    }

    public List<TimeTableItem> getTueList() {
        return sTueList;
    }

    public List<TimeTableItem> getWedList() {
        return sWedList;
    }

    public List<TimeTableItem> getThuList() {
        return sThuList;
    }

    public List<TimeTableItem> getFriList() {
        return sFriList;
    }

    private void initSpot() {
        sSpotList.add("경영관");
        sSpotList.add("과학관");
        sSpotList.add("대운동장");
        sSpotList.add("동대입구역");
        sSpotList.add("만해광장");
        sSpotList.add("명진관");
        sSpotList.add("박물관");
        sSpotList.add("법학관");
        sSpotList.add("본관");
        sSpotList.add("사회과학관");
        sSpotList.add("상록원");
        sSpotList.add("신공학관");
        sSpotList.add("원흥관");
        sSpotList.add("정보문화관");
        sSpotList.add("중앙도서관");
        sSpotList.add("쪽문");
        sSpotList.add("충무로역");
        sSpotList.add("팔정도");
        sSpotList.add("학림관");
        sSpotList.add("학생회관");
        sSpotList.add("학술문화관");
        sSpotList.add("혜화관");
        sSpotList.add("후문");
    }

    private void initDay() {
        sDayList.add("월요일");
        sDayList.add("화요일");
        sDayList.add("수요일");
        sDayList.add("목요일");
        sDayList.add("금요일");
    }

    private void initTime() {
        sTimeList.add("09:00");
        sTimeList.add("09:30");
        sTimeList.add("10:00");
        sTimeList.add("10:30");
        sTimeList.add("11:00");
        sTimeList.add("11:30");
        sTimeList.add("12:00");
        sTimeList.add("12:30");
        sTimeList.add("13:00");
        sTimeList.add("13:30");
        sTimeList.add("14:00");
        sTimeList.add("14:30");
        sTimeList.add("15:00");
        sTimeList.add("15:30");
        sTimeList.add("16:00");
        sTimeList.add("16:30");
        sTimeList.add("17:00");
        sTimeList.add("17:30");
        sTimeList.add("18:00");
        sTimeList.add("18:30");
        sTimeList.add("19:00");
        sTimeList.add("19:30");
        sTimeList.add("20:00");
    }

    private void initMap() {
        sSrcToDestMap.put("충무로역_경영관",new ResultData(10,0.57,54));
        sSrcToDestMap.put("경영관_경영관",new ResultData(0,0,0));
        sSrcToDestMap.put("충무로역_신공학관",new ResultData(7,0.4,39));
        sSrcToDestMap.put("신공학관_상록원",new ResultData(3,0.147,15));
        sSrcToDestMap.put("경영관_충무로역",new ResultData(100,4.57,540));
    }
}
