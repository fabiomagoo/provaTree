package br.com.tree.prova;

import com.google.gson.JsonObject;

public class GetRequestRepository {

    private API api;

    public GetRequestRepository() {
        this.api = new API();
    }
    
    public GetRequestRepository(API api) {
        this.api = api;
    }
    
    public JsonObject getAll(String path) {
        return getAll(path, null);
    }

    public JsonObject getAll(String path, String searchquery) {
        JsonObject jsonObject = null;
        try {
            jsonObject = api.getBuilder(path, searchquery);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public JsonObject innerRequest(String uri) {
        JsonObject jsonObject = new JsonObject();
        try {
            jsonObject = api.innerRequest(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}