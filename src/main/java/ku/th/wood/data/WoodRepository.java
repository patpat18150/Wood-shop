package ku.th.wood.data;

import ku.th.wood.model.Customer;
import ku.th.wood.model.Wood;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class WoodRepository {
    private JdbcTemplate jdbcTemplate;
    public WoodRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Wood> findAllwood() {
        String query = "SELECT * FROM wood";
        List<Wood> woods =  jdbcTemplate.query(query, new WoodRowMapper());
        return  woods;
    }
    public Wood findByWoodId( String woodId) {
        String query = "SELECT * FROM wood WHERE woodId = " + woodId;
        Wood wood = jdbcTemplate.queryForObject(query, new WoodRowMapper());
        return wood;
    }
    public List<Wood> findByWoodName(String woodname){
        String query = "SELECT * FROM wood WHERE woodname = '" + woodname + "'";
        List<Wood> woods = jdbcTemplate.query(query, new WoodRowMapper());
        System.out.println("have " + woods.size()  + " dacaena");
        return woods;
    }

    public void saveWood(Wood wood) {
        String query  = "INSERT INTO wood (woodId,type,tier,price,des,woodname) VALUES (?,?,?,?,?,?)";
        Object[] data = {wood.getWoodId(),wood.getType(),wood.getTier(),wood.getPrice(),wood.getDes(),wood.getName()};
        jdbcTemplate.update(query,data);
    }

    public void deleteByWoodId( String woodId) {
        String query  = "DELETE FROM wood WHERE woodId = " + woodId;
        System.out.println("delete wood ID " + woodId + " success");
        jdbcTemplate.update(query);
    }

    class WoodRowMapper implements RowMapper<Wood> {
        @Override
        public Wood mapRow(ResultSet resultSet, int i)
                throws SQLException {

            String woodId = resultSet.getString("woodId");
            String type = resultSet.getString("type");
            String tier = resultSet.getString("tier");
            Double price = resultSet.getDouble("price");
            String des = resultSet.getString("des");
            String woodname = resultSet.getString("woodname");

            Wood woods = new Wood(woodId,type, tier,price,des,woodname);
            return woods;

        }
    }
}
