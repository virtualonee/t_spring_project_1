package ru.alishev.springcourse.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class Person {
    private int id;
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min=2, max=100, message="Имя должно быть длиной от 2 до 100 символов")
    private String fio;

    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
    private String date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
