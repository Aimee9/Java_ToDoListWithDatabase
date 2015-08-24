import org.junit.rules.ExternalResource;
import org.sql2o.*;
import java.sql.Timestamp;
import java.util.Date;

public class DatabaseRule extends ExternalResource {

  protected void before() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/todo_list_test", null, null);
   }

  protected void after() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM tasks *;";
      con.createQuery(sql).executeUpdate();
    }
  }
}
