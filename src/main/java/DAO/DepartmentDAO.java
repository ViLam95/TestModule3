package DAO;

import DAO.connection.MyConnection;
import model.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAO {
    private Connection connection = MyConnection.getConnection();
    private static DepartmentDAO departmentDAO;
    public static DepartmentDAO getInstance() {
        if (departmentDAO == null) {
            departmentDAO = new DepartmentDAO();
        }
        return departmentDAO;
    }
        public List<Department> findAll() {
            List<Department> departmentList = new ArrayList<>();
            String query = "select * from department;";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Department department = new Department(id,name);
                    departmentList.add(department);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return departmentList;
        }

    public Department findById(int id) {
        Department department = null;
        String query = "select * from department where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                department = new Department(id, name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return department;
    }

}
