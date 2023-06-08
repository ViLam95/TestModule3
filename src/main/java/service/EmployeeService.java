package service;

import DAO.connection.EmployeeDAO;
import model.Department;
import model.Employee;

import javax.servlet.http.HttpServletRequest;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private final EmployeeDAO employeeDAO;
    private final DepartmentService departmentService;
    private static EmployeeService employeeService;

    private EmployeeService() {
        employeeDAO = new EmployeeDAO();
        departmentService = DepartmentService.getInstance();
    }

    public static EmployeeService getInstance() {
        if (employeeService == null) {
            employeeService = new EmployeeService();
        }
        return employeeService;
    }
    public List<Employee> getEmployees(){
        return employeeDAO.findAll();
    }
    public Employee getById(int id) {
        return employeeDAO.findById(id);
    }
    public void updateEmployee(HttpServletRequest request) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phone_number");
        double salary = Double.parseDouble(request.getParameter("salary"));
        int id_department = Integer.parseInt(request.getParameter("id_department"));
        Department department = DepartmentService.getInstance().getById(id_department);
        if (id != null) {
            int idUpdate = Integer.parseInt(id);
            employeeDAO.updateEmployeeById(new Employee(idUpdate, name, email, address, phoneNumber, salary,department));
        } else {
            employeeDAO.addEmployee(new Employee(name, email, address, phoneNumber, salary,department));
        }
    }
    public List<Employee> searchByName(HttpServletRequest request) {
        String search = request.getParameter("search");
        return employeeDAO.searchByName(search);
    }

    public void deleteById(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeDAO.deleteEmployeeById(id);
    }
    public boolean checkById(int id) {
        Employee employee = employeeDAO.findById(id);
        return employee != null;
    }
}
