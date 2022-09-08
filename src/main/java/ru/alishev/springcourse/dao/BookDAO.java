package ru.alishev.springcourse.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Book;
import ru.alishev.springcourse.models.Person;

import java.util.List;


@Component
public class BookDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Book.class))
                .stream().findAny().orElse(null);
    }

    public void save(Book Book) {
        jdbcTemplate.update("INSERT INTO Book(name, author, year) VALUES(?, ?, ?, ?)", Book.getName(), Book.getAuthor(), Book.getYear(), Book.getPerson());
    }

    public void update(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE Book SET name=?, author=?, year=?, person=? WHERE id=?", updatedBook.getName(),
                updatedBook.getAuthor(), updatedBook.getYear(), updatedBook.getPerson(), id);
    }

    public void unbind(int id) {
        jdbcTemplate.update("UPDATE Book SET person=null WHERE id=?", id);
    }

    public void bind(int id, int personId) {
        jdbcTemplate.update("UPDATE Book SET person=? WHERE id=?", personId, id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }

    public List<Book> showBooksByPersonId(int personId) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE person=?", new Object[]{personId}, new BeanPropertyRowMapper<>(Book.class));
    }

    //////////////////////
    // Тестируем производительность
    //////////////////////

//    public void testMultipleUpdate() {
//        List<Book> people = create1000People();
//
//        long before = System.currentTimeMillis();
//
//        for (Book Book : people) {
//            jdbcTemplate.update("INSERT INTO Book VALUES(?, ?, ?)", Book.getId(), Book.getFio(), Book.getBirthdate());
//        }
//
//        long after = System.currentTimeMillis();
//        System.out.println("Time: " + (after - before));
//    }
//
//    public void testBatchUpdate() {
//        List<Book> people = create1000People();
//
//        long before = System.currentTimeMillis();
//
//        jdbcTemplate.batchUpdate("INSERT INTO Book VALUES(?, ?, ?)",
//                new BatchPreparedStatementSetter() {
//                    @Override
//                    public void setValues(PreparedStatement ps, int i) throws SQLException {
//                        ps.setInt(1, people.get(i).getId());
//                        ps.setString(2, people.get(i).getName());
//                        ps.setInt(3, people.get(i).getAge());
//                    }
//
//                    @Override
//                    public int getBatchSize() {
//                        return people.size();
//                    }
//                });
//
//        long after = System.currentTimeMillis();
//        System.out.println("Time: " + (after - before));
//    }
//
//    private List<Book> create1000People() {
//        List<Book> people = new ArrayList<>();
//
//        for (int i = 0; i < 1000; i++)
//            people.add(new Book()); // добавить конструктор
//
//        return people;
//    }
}
