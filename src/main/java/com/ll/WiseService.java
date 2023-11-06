package com.ll;

import java.util.ArrayList;
import java.util.List;

public class WiseService {
    WiseRepository wiseRepository = new WiseRepository();

    /**
     * 생성할 명언 전달 to repository
     *
     * @return 생성한 명언 id 리턴 to controller
     */
    public int postWise(String content, String author) {
        int id = wiseRepository.postWise(content, author);
        return id;
    }

    /**
     * @return totalList : 양식 적용 명언 목록 문자열
     */
    public ArrayList<String> getWiseList() {
        List<Wise> wiseList = wiseRepository.getWiseList();
        ArrayList<String> totalWiseList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int index = wiseList.size() - 1; index >= 0; index--) {
            sb.append(wiseList.get(index).getId()).append(" / ")
                    .append(wiseList.get(index).getAuthor()).append(" / ")
                    .append(wiseList.get(index).getContent());
            totalWiseList.add(sb.toString());
            sb.setLength(0);
        }
        return totalWiseList;
    }

    public boolean deleteWise(int id) {
        return wiseRepository.deleteWise(id);
    }

    public String[] findWise(int id) {
        int findIndex = wiseRepository.getWiseIndexById(id);
        if (findIndex == -1) {
            return null;
        } else {
            return new String[]{
                    wiseRepository.getWiseList().get(findIndex).getContent(),
                    wiseRepository.getWiseList().get(findIndex).getAuthor()
            };
        }
    }

    public void modifyWise(int id, String content, String author) {
        wiseRepository.modifyWise(id, content, author);
    }
}
