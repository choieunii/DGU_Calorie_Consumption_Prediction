package model;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.RawFileReader;

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

    private Repository(Context context) {
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
        initMap(context);

    }

    public static Repository getInstance(Context context) {
        if(instance == null)
            instance = new Repository(context);

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

    private void initMap(Context context) {

        sSrcToDestMap.putAll(RawFileReader.readCSV(context));

//        Log.d("MYTAG", "mapSize : " + sSrcToDestMap.size());
        //0.0665 / 5.9035 분당 이동거리, 소모열량
//        sSrcToDestMap.put("충무로역_경영관",new ResultData(10,0.57,54));
//        sSrcToDestMap.put("충무로역_신공학관",new ResultData(7,0.4,39));
//        sSrcToDestMap.put("신공학관_상록원",new ResultData(3,0.147,15));
//
//        sSrcToDestMap.put("경영관_경영관",new ResultData(0,0,0));
//        sSrcToDestMap.put("경영관_과학관",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("경영관_대운동장",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("경영관_동대입구",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("경영관_만해광장",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("경영관_명진관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("경영관_법학관",new ResultData(4,0.266,24));
//        sSrcToDestMap.put("경영관_본관",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("경영관_사회과학관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("경영관_상록원",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("경영관_신공학관",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("경영관_원흥관",new ResultData(10,0.665,59));
//        sSrcToDestMap.put("경영관_정보문화관",new ResultData(9,0.5985,53));
//        sSrcToDestMap.put("경영관_중앙도서관",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("경영관_쪽문",new ResultData(11,0.7315,65));
//        sSrcToDestMap.put("경영관_충무로역",new ResultData(19,1.2635,112));
//        sSrcToDestMap.put("경영관_팔정도",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("경영관_학림관",new ResultData(11,0.7315,65));
//        sSrcToDestMap.put("경영관_학생회관",new ResultData(10,0.665,59));
//        sSrcToDestMap.put("경영관_학술문화관",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("경영관_혜화관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("경영관_후문",new ResultData(1,0.0665,6));
//
//        sSrcToDestMap.put("과학관_경영관",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("과학관_대운동장",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("과학관_동대입구",new ResultData(11,0.7315,65));
//        sSrcToDestMap.put("과학관_만해광장",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("과학관_명진관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("과학관_법학관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("과학관_본관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("과학관_사회과학관",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("과학관_상록원",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("과학관_신공학관",new ResultData(4,0.266,23));
//        sSrcToDestMap.put("과학관_원흥관 ",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("과학관_정보문화관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("과학관_중앙도서관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("과학관_쪽문",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("과학관_충무로역",new ResultData(15,0.9975,88));
//        sSrcToDestMap.put("과학관_팔정도",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("과학관_학림관",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("과학관_학생회관",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("과학관_학술문화관",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("과학관_혜화관",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("과학관_후문",new ResultData(8,0.532,47));
//
//        sSrcToDestMap.put("대운동장_경영관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("대운동장_과학관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("대운동장_대운동장",new ResultData(0,0,0));
//        sSrcToDestMap.put("대운동장_동대입구",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("대운동장_만해광장",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("대운동장_명진관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("대운동장_법학관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("대운동장_본관",new ResultData(4,0.266,23));
//        sSrcToDestMap.put("대운동장_사회과학관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("대운동장_상록원",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("대운동장_신공학관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("대운동장_원흥관 ",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("대운동장_정보문화관",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("대운동장_중앙도서관",new ResultData(4,0.266,23));
//        sSrcToDestMap.put("대운동장_쪽문",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("대운동장_충무로역",new ResultData(16,1.064,94));
//        sSrcToDestMap.put("대운동장_팔정도",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("대운동장_학림관",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("대운동장_학생회관",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("대운동장_학술문화관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("대운동장_혜화관",new ResultData(3,0.1995,18));
//
//        sSrcToDestMap.put("동대입구_경영관",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("동대입구_과학관",new ResultData(11,0.7315,65));
//        sSrcToDestMap.put("동대입구_대운동장",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("동대입구_동대입구",new ResultData(0,0,0));
//        sSrcToDestMap.put("동대입구_만해광장",new ResultData(14,0.931,83));
//        sSrcToDestMap.put("동대입구_명진관",new ResultData(11,0.7315,65));
//        sSrcToDestMap.put("동대입구_법학관",new ResultData(11,0.7315,65));
//        sSrcToDestMap.put("동대입구_본관",new ResultData(13,0.8645,77));
//        sSrcToDestMap.put("동대입구_사회과학관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("동대입구_상록원",new ResultData(35,2.3275,207));
//        sSrcToDestMap.put("동대입구_신공학관",new ResultData(14,0.931,83));
//        sSrcToDestMap.put("동대입구_원흥관",new ResultData(19,1.2635,112));
//        sSrcToDestMap.put("동대입구_정보문화관",new ResultData(13,0.8645,77));
//        sSrcToDestMap.put("동대입구_중앙도서관",new ResultData(13,0.8645,77));
//        sSrcToDestMap.put("동대입구_쪽문",new ResultData(20,1.33,118));
//        sSrcToDestMap.put("동대입구_충무로역",new ResultData(22,1.463,130));
//        sSrcToDestMap.put("동대입구_팔정도",new ResultData(11,0.7315,65));
//        sSrcToDestMap.put("동대입구_학림관",new ResultData(12,0.798,71));
//        sSrcToDestMap.put("동대입구_학생회관",new ResultData(13,0.8645,77));
//        sSrcToDestMap.put("동대입구_학술문화관",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("동대입구_혜화관",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("동대입구_후문",new ResultData(11,0.7315,65));
//
//        sSrcToDestMap.put("만해광장_경영관",new ResultData(9,0.5985,53));
//        sSrcToDestMap.put("만해광장_과학관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("만해광장_대운동장",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("만해광장_동대입구",new ResultData(14,0.931,83));
//        sSrcToDestMap.put("만해광장_만해광장",new ResultData(0,0,0));
//        sSrcToDestMap.put("만해광장_명진관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("만해광장_법학관",new ResultData(4,0.266,23));
//        sSrcToDestMap.put("만해광장_본관",new ResultData(1,0.0665,6));
//        sSrcToDestMap.put("만해광장_상록원",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("만해광장_신공학관 ",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("만해광장_원흥관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("만해광장_정보문화관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("만해광장_중앙도서관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("만해광장_쪽문",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("만해광장_충무로역",new ResultData(12,0.798,71));
//        sSrcToDestMap.put("만해광장_팔정도",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("만해광장_학림관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("만해광장_학생회관",new ResultData(1,0.0665,6));
//        sSrcToDestMap.put("만해광장_학술문화관",new ResultData(11,0.7315,65));
//        sSrcToDestMap.put("만해광장_혜화관",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("만해광장_후문",new ResultData(3,0.1995,18));
//
//        sSrcToDestMap.put("명진관_경영관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("명진관_과학관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("명진관_대운동장",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("명진관_동대입구",new ResultData(11,0.7315,65));
//        sSrcToDestMap.put("명진관_만해광장",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("명진관_명진관",new ResultData(0,0,0));
//        sSrcToDestMap.put("명진관_법학관",new ResultData(1,0.0665,6));
//        sSrcToDestMap.put("명진관_본관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("명진관_사회과학관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("명진관_상록원",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("명진관_신공학관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("명진관_원흥관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("명진관_정보문화관",new ResultData(4,0.266,23));
//        sSrcToDestMap.put("명진관_중앙도서관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("명진관_쪽문",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("명진관_충무로역",new ResultData(14,0.931,83));
//        sSrcToDestMap.put("명진관_팔정도",new ResultData(0,0.006,1));
//        sSrcToDestMap.put("명진관_학림관",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("명진관_학생회관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("명진관_학술문화관",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("명진관_혜화관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("명진관_후문",new ResultData(6,0.399,35));
//
//        sSrcToDestMap.put("법학관_경영관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("법학관_과학관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("법학관_대운동장",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("법학관_동대입구",new ResultData(11,0.7315,65));
//        sSrcToDestMap.put("법학관_만해광장",new ResultData(4,0.266,23));
//        sSrcToDestMap.put("법학관_명진관",new ResultData(1,0.0665,6));
//        sSrcToDestMap.put("법학관_법학관",new ResultData(0,0,0));
//        sSrcToDestMap.put("법학관_본관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("법학관_사회과학관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("법학관_상록원",new ResultData(4,0.266,23));
//        sSrcToDestMap.put("법학관_신공학관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("법학관_원흥관",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("법학관_정보문화관",new ResultData(4,0.266,23));
//        sSrcToDestMap.put("법학관_중앙도서관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("법학관_쪽문",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("법학관_충무로역",new ResultData(15,0.9975,88));
//        sSrcToDestMap.put("법학관_팔정도",new ResultData(1,0.0665,6));
//        sSrcToDestMap.put("법학관_학림관",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("법학관_학생회관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("법학관_학술문화관",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("법학관_혜화관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("법학관_후문",new ResultData(7,0.4655,41));
//
//        sSrcToDestMap.put("본관_경영관",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("본관_과학관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("본관_대운동장",new ResultData(4,0.266,23));
//        sSrcToDestMap.put("본관_동대입구",new ResultData(13,0.8645,77));
//        sSrcToDestMap.put("본관_만해광장",new ResultData(1,0.0665,6));
//        sSrcToDestMap.put("본관_명진관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("본관_법학관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("본관_본관",new ResultData(0,0,0));
//        sSrcToDestMap.put("본관_사회과학관",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("본관_상록원",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("본관_신공학관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("본관_원흥관",new ResultData(4,0.266,23));
//        sSrcToDestMap.put("본관_정보문화관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("본관_중앙도서관",new ResultData(1,0.0665,6));
//        sSrcToDestMap.put("본관_쪽문",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("본관_충무로역",new ResultData(13,0.8645,77));
//        sSrcToDestMap.put("본관_팔정도",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("본관_학림관",new ResultData(4,0.266,23));
//        sSrcToDestMap.put("본관_학생회관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("본관_학술문화관",new ResultData(9,0.5985,53));
//        sSrcToDestMap.put("본관_혜화관",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("본관_후문",new ResultData(4,0.266,23));
//
//        sSrcToDestMap.put("사회과학관_경영관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("사회과학관_과학관",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("사회과학관_대운동장",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("사회과학관_동대입구",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("사회과학관_만해광장",new ResultData(9,0.5985,53));
//        sSrcToDestMap.put("사회과학관_명진관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("사회과학관_법학관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("사회과학관_본관",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("사회과학관_사회과학관",new ResultData(0,0,0));
//        sSrcToDestMap.put("사회과학관_상록원",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("사회과학관_신공학관",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("사회과학관_원흥관",new ResultData(10,0.665,59));
//        sSrcToDestMap.put("사회과학관_정보문화관",new ResultData(9,0.5985,53));
//        sSrcToDestMap.put("사회과학관_중앙도서관",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("사회과학관_쪽문",new ResultData(11,0.7315,65));
//        sSrcToDestMap.put("사회과학관_충무로역",new ResultData(22,1.463,130));
//        sSrcToDestMap.put("사회과학관_팔정도",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("사회과학관_학림관",new ResultData(12,0.798,71));
//        sSrcToDestMap.put("사회과학관_학생회관",new ResultData(10,0.665,59));
//        sSrcToDestMap.put("사회과학관_혜화관",new ResultData(1,0.0665,6));
//        sSrcToDestMap.put("사회과학관_후문",new ResultData(11,0.7315,65));
//
//        sSrcToDestMap.put("상록원_경영관",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("상록원_과학관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("상록원_대운동장",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("상록원_동대입구",new ResultData(35,2.3275,207));
//        sSrcToDestMap.put("상록원_만해광장",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("상록원_명진관",new ResultData(2,0.133,12));
//        sSrcToDestMap.put("상록원_법학관",new ResultData(4,0.266,23));
//        sSrcToDestMap.put("상록원_본관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("상록원_사회과학관",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("상록원_상록원",new ResultData(0,0,0));
//        sSrcToDestMap.put("상록원_신공학관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("상록원_원흥관",new ResultData(22,1.463,130));
//        sSrcToDestMap.put("상록원_정보문화관",new ResultData(5,0.3325,30));
//        sSrcToDestMap.put("상록원_중앙도서관",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("상록원_쪽문",new ResultData(23,1.5295,138));
//        sSrcToDestMap.put("상록원_충무로역",new ResultData(27,1.7955,162));
//        sSrcToDestMap.put("상록원_팔정도",new ResultData(3,0.1995,18));
//        sSrcToDestMap.put("상록원_학림관",new ResultData(8,0.532,47));
//        sSrcToDestMap.put("상록원_학생회관",new ResultData(6,0.399,35));
//        sSrcToDestMap.put("상록원_학술문화관",new ResultData(10,0.665,59));
//        sSrcToDestMap.put("상록원_혜화관",new ResultData(7,0.4655,41));
//        sSrcToDestMap.put("상록원_후문",new ResultData(8,0.532,47));
    }
}
