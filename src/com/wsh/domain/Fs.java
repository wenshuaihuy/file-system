package com.wsh.domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author WS Hu
 * @date 2020/12/16 23:18
 */
public class Fs implements Serializable {
    private String id;
    private String name;
    private String time;
    private String fileSize;

    public Fs() {
    }

    public Fs(String id, String time, String name, String fileSize) {
        this.id = id;
        this.time = time;
        this.name = name;
        this.fileSize = fileSize;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "Fs{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", fileSize='" + fileSize + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Fs fs = (Fs) o;
        return Objects.equals(id, fs.id) && Objects.equals(time, fs.time) && Objects.equals(name, fs.name) && Objects.equals(fileSize, fs.fileSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, name, fileSize);
    }
}
