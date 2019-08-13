
package com.example.customsearch.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Queries {

    @SerializedName("previousPage")
    @Expose
    private List<PreviousPage> previousPage = null;
    @SerializedName("request")
    @Expose
    private List<Request> request = null;
    @SerializedName("nextPage")
    @Expose
    private List<NextPage> nextPage = null;

    public List<PreviousPage> getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(List<PreviousPage> previousPage) {
        this.previousPage = previousPage;
    }

    public List<Request> getRequest() {
        return request;
    }

    public void setRequest(List<Request> request) {
        this.request = request;
    }

    public List<NextPage> getNextPage() {
        return nextPage;
    }

    public void setNextPage(List<NextPage> nextPage) {
        this.nextPage = nextPage;
    }

}
