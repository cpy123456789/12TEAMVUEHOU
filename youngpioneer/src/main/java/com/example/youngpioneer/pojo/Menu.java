package com.example.youngpioneer.pojo;

public class Menu {
    private Integer id;

    private String menuname;

    private String resolve1;

    private String resulve2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname == null ? null : menuname.trim();
    }

    public String getResolve1() {
        return resolve1;
    }

    public void setResolve1(String resolve1) {
        this.resolve1 = resolve1 == null ? null : resolve1.trim();
    }

    public String getResulve2() {
        return resulve2;
    }

    public void setResulve2(String resulve2) {
        this.resulve2 = resulve2 == null ? null : resulve2.trim();
    }
}
