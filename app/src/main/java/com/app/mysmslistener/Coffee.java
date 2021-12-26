package com.example.myapplication;

class Coffee {
    public String description;
    public String title;
    public int id;

    public Coffee(String description, String title, int id) {
        this.description = description;
        this.title = title;
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
