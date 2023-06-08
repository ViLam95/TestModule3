package DAO.connection;

import model.Department;
import model.Employee;
import service.DepartmentService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {
    private Connection connection = MyConnection.getConnection();
    private static EmployeeDAO employeeDAO;

    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        String query = "select * from employee;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
           convertResultSetToList(employeeList, preparedStatement);
            }  catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
    public Employee findById(int id) {
        Employee employee = null;
        String query = "select * from employee where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phone_number");
                double salary = resultSet.getDouble("salary");
                int id_department = resultSet.getInt("id_department");
                Department department = DepartmentService.getInstance().getById(id_department);
                employee = new Employee(id, name, email, address, phoneNumber, salary,department);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
    public void addEmployee(Employee employee) {
        String query = "insert into employee(name,email,address,phone_number,salary,id_department) values(?,?,?,?,?,?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDouble(5,employee.getSalary());
            preparedStatement.setInt(6,employee.getDeparment().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateEmployeeById(Employee employee) {
        String query = "update employee set name = ?,email=?,address=?,phone_number=?,salary=?, id_department=? where id = ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, employee.getName());
            preparedStatement.setString(2, employee.getEmail());
            preparedStatement.setString(3, employee.getAddress());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setDouble(5,employee.getSalary());
            preparedStatement.setLong(6, employee.getDeparment().getId());
            preparedStatement.setLong(7, employee.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Employee> searchByName(String name) {
        List<Employee> employeeList = new ArrayList<>();
        String query = "select * from employee where name like ?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + name + "%");
            convertResultSetToList(employeeList, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
    public void deleteEmployeeById(int id) {
        String query = "delete from employee where id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void convertResultSetToList(List<Employee> employeeList, PreparedStatement preparedStatement) throws SQLException {
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            String address = resultSet.getString("address");
            String phoneNumber = resultSet.getString("phone_number");
            double salary = resultSet.getDouble("salary");
            int id_department = resultSet.getInt("id_department");
            Department department = DepartmentService.getInstance().getById(id_department);
            Employee employee = new Employee(id, name, email, address, phoneNumber, salary,department);
            employeeList.add(employee);
        }
    }

}
