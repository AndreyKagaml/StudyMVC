package ua.kahamlyk.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.kahamlyk.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {
  //  private static int PEOPLE_COUNT;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PeopleDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

//    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
//    private static final String USERNAME = "postgres";
//    private static final String PASSWORD = "";
//
//
//    private static Connection connection;
//
//    static{
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }



    public List<Person> index() throws SQLException {

        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());

//      List<Person> people = new ArrayList<>();
//
//        Statement statement = connection.createStatement();
//        String SQL = "SELECT * FROM Person";
//        ResultSet resultSet = statement.executeQuery(SQL);
//
//        while(resultSet.next()){
//            Person person = new Person();
//            person.setId(resultSet.getInt("id"));
//            person.setName(resultSet.getString("name"));
//            person.setAge(resultSet.getInt("age"));
//            person.setEmail(resultSet.getString("email"));
//
//            people.add(person);
//        }
//        return people;
    }

    public Person show(int id){
        /**
         you can use BeanPropertyRowMapper<>(Person.class) instead of PersonMapper(),
         if column label in table and fields in object are the same
         */
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new PersonMapper()).stream().findAny().orElse(null);

       // return peoples.stream().filter(person -> person.getId() == id).findAny().orElse(null);

        //

//        Person person = null;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Person WHERE id=?");
//            preparedStatement.setInt(1, id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            resultSet.next();
//
//            person = new Person();
//            person.setId(resultSet.getInt("id"));
//            person.setName(resultSet.getString("name"));
//            person.setAge(resultSet.getInt("age"));
//            person.setEmail(resultSet.getString("email"));
//
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
//        return person;

    }

    public void save(Person person) throws SQLException{
         jdbcTemplate.update("INSERT INTO Person VALUES (1, ?, ?, ?)",
                person.getName(), person.getAge(), person.getEmail());

//        PreparedStatement preparedStatement =
//                connection.prepareStatement("INSERT INTO Person VALUES (1, ?,?,?)");
//
//        preparedStatement.setString(1, person.getName());
//        preparedStatement.setInt(2, person.getAge());
//        preparedStatement.setString(3, person.getEmail());
//
//        preparedStatement.executeUpdate();
    }

    public void update(int id, Person person){
        jdbcTemplate.update("UPDATE Person SET name=?, age=?, email=? WHERE id=?",
                person.getName(), person.getAge(), person.getEmail(), id);

//        try{
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?");
//
//            preparedStatement.setString(1, person.getName());
//            preparedStatement.setInt(2, person.getAge());
//            preparedStatement.setString(3, person.getName());
//            preparedStatement.setInt(4, id);
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);

      //  peoples.removeIf(person -> person.getId()==id);

//        try {
//            PreparedStatement preparedStatement =
//                    connection.prepareStatement("DELETE FROM Person WHERE id=?");
//            preparedStatement.setInt(1, id);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e){
//            e.printStackTrace();
//        }
    }
}
