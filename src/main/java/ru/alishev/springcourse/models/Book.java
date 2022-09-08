package ru.alishev.springcourse.models;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Book {

    private int id;
    @NotEmpty(message = "Название книги не должно быть пустым")
    @Size(min=2, max=100, message="Название книги должно быть длиной от 2 до 100 символов")
    private String name;
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min=2, max=100, message="Имя должно быть длиной от 2 до 100 символов")
    private String author;
    @Min(value = 1900, message = "Год должен быть больше, чем 1900")
    private String year;

    private Integer person;

    public Book(){

    }

    public Book(String author, String year) {
        this.author = author;
        this.year = year;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getPerson() {

        if(person==null){
            return 0;
        }

        return person;
    }

    public void setPerson(Integer person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year='" + year + '\'' +
                ", person=" + person +
                '}';
    }
}
