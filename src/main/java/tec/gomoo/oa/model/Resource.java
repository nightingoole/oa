package tec.gomoo.oa.model;

import xyz.frt.base.model.BaseEntity;

public class Resource extends BaseEntity {

    private String url;

    private String name;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

}