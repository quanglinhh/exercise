using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Employee
{
    internal class Program
    {
        

        static void Main(string[] args)
        {
            Employee[] employees =
            {
                new Employee() { EmployeeId = 1, EmployeeName = "Linh",  Age = 20 },
                new Employee() { EmployeeId = 2, EmployeeName = "Nga",  Age = 30 },
                new Employee() { EmployeeId = 3, EmployeeName = "Trung",  Age = 60 },
                new Employee() { EmployeeId = 4, EmployeeName = "Bac",  Age = 50 },
                new Employee() { EmployeeId = 5, EmployeeName = "Bac",  Age = 50 },
                new Employee() { EmployeeId = 6, EmployeeName = "Son",  Age = 40 }
            };

            var employeeQuery2 = employees.Where(employee => employee.Age > 20 && employee.Age < 60);
            var employeeQuery = from employee in employees where employee.Age > 20 && employee.Age < 60 select employee;
            foreach(var employee in employeeQuery2)
            {
                Console.WriteLine(employee.EmployeeName);
            }
            var emName = employees.Where(e => e.EmployeeName == "Bac").FirstOrDefault();
            Console.WriteLine(emName.EmployeeName);
            //Count
            var numberOffEm = employees.Count(e => e.Age >= 60);
            //Any
            var checkEmployee = employees.Any();
            Console.WriteLine(checkEmployee);
            Console.WriteLine(employees.Length);
            //OrderBy
            var empOrder = employees.OrderBy(e => e.Age).ThenByDescending(e=>e.Age);
            var empOrder2 = from e in employees orderby e.Age descending select e;
            foreach(var employee in empOrder2)
            {
                Console.WriteLine(employee.EmployeeName);
            }
            //GroupBy
            var empGroub = from e in employees group e by e.Age;
            var empGroub2 = employees.GroupBy(e=>e.Age);
            Console.ReadLine();
        }
    }
}
