package com.ll;

import lombok.Getter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.FileWriter;

public class WiseRepository {
    @Getter
    List<Wise> wiseList = new ArrayList<>();
    // 파일 영속성, 빌드 경로
    private final String PATH = ("data.json");
    private final String ERROR = ("ERROR");

    public int postWise(String content, String author) {
        wiseList.add(new Wise(content, author));
        // 생성된 명언의 id값 리턴
        return wiseList.get(wiseList.size() - 1).getId();
    }

    /**
     * @param id 찾고자 하는 명언의 id값
     * @return 해당 id가 없을 시 -1 리턴 / 있을 시 해당 id 명언이 저장된 리스트 인덱스 리턴
     */
    public int getWiseIndexById(int id) {
        for (Wise wise : wiseList) {
            if (wise.getId() == id) {
                return wiseList.indexOf(wise);
            }
        }
        return -1;
    }

    public boolean deleteWise(int id) {
        int deleteIndex = getWiseIndexById(id);
        if (deleteIndex == -1) {
            return false;
        }
        wiseList.remove(deleteIndex);
        return true;
    }

    public void modifyWise(int id, String content, String author){
        wiseList.set(getWiseIndexById(id), new Wise(id, content, author));
    }

    /**
     * @return 저장 성공 시 PATH / 실패 시 -1 리턴
     */
    public String saveWise() {
        try {
            JSONArray wiseInfoArray = new JSONArray();
            for (Wise wise : wiseList) {
                JSONObject wiseInfo = new JSONObject();
                wiseInfo.put("id", String.valueOf(wise.getId()));
                wiseInfo.put("content", wise.getContent());
                wiseInfo.put("author", wise.getAuthor());
                wiseInfoArray.add(wiseInfo);
            }
            FileWriter fw = new FileWriter(PATH);
            fw.write(wiseInfoArray.toJSONString());
            fw.flush();
            fw.close();
            return PATH;
        } catch (Exception e){
            return ERROR;
        }
    }

    /**
     * @return 불러오기 성공 시 true / 실패 시 false 리턴
     */
    public boolean readWise() {
        try {
            JSONParser jsonParser = new JSONParser();
            Object object = jsonParser.parse(new FileReader(PATH));
            JSONArray jsonArray = (JSONArray) object;

            if (!jsonArray.isEmpty()) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    int id = Integer.valueOf((String) jsonObject.get("id"));
                    String author = (String) jsonObject.get("author");
                    String content = (String) jsonObject.get("content");
                    wiseList.add(new Wise(id, content, author));
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
