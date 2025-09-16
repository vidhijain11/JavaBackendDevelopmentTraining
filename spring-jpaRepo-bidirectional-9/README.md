In this project we have not implemented the department and employee repositories method to save and read the data. 
But we are using spring data jpa repository to save and read the data. Spring provides the implementation of the repository methods.
So, we can use the repository methods to save and read the data.
It has many inbuilt methods to save, read, update and delete the data.
For example - save(), findById(), findAll(), deleteById() etc.
We can also create our own custom methods in the repository interface.
For example - findByDeptName(String deptName) in DepartmentRepository and findByEmpName(String empName) in EmployeeRepository.
We can use these methods to read the data based on department name and employee name.