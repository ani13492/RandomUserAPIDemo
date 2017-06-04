package com.example.aniruddh.randomuser.api.ApiModel;

import com.example.aniruddh.randomuser.Model.User;

import java.util.List;

/**
 * Created by Aniruddh on 6/2/17.
 */

public class RandomUserResponse {
    private List<User> results;
    private Info info;

    public RandomUserResponse() {
    }

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
