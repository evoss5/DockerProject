package Tests;

public class SqlQueries{
    public String getFirstName() {
        return "SELECT first_name FROM actor ORDER BY RANDOM() FETCH FIRST ROWS ONLY;";
    }
    public String getLastName(){
        return "SELECT last_name FROM actor ORDER BY RANDOM() FETCH FIRST ROWS ONLY;";
    }


}

