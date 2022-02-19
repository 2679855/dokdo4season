package com.mycooco.dokdo.vo;

import java.util.ArrayList;
import java.util.List;

public class Season {

    int curIdx;

    public List<String> list = new ArrayList<>();

    public String getPrevImage() {

        curIdx--;
        if (curIdx < 0) {
            curIdx = list.size()-1;
        }

        return list.get(curIdx);
    }

    public String getNextImage() {

        curIdx++;
        if (curIdx >= list.size()) {
            curIdx = 0;
        }

        return list.get(curIdx);
    }
}
