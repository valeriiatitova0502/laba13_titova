// Song.java
package org.example;

public class Song {

    private int id;
    private String name;
    private String singer;
    private String time;

    public Song() {
    }

    public Song(int id, String name, String singer, String time) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String printInfo() {
        return "Id: " + id + ", Name: " + name + ", Singer: " + singer + ", Time: " + time;
    }
}