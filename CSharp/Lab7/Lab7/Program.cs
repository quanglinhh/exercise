using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7
{
    internal class Program
    {
        static void Main(string[] args)
        {
            /*
            InitEmployee();
            InitProject();

            //var employeeQuery2 = employees.Where(employee => employee.Age > 20 && employee.Age < 60);
            //var employeeQuery = from employee in employees where employee.Age > 20 && employee.Age < 60 select employee;
            var allEmployee = (from e in employees select e).ToList();
            //Cach1
            var allEmployee1 = (from e in employees
                              where e.EmployeeName[0] == 'L' //e.EmployeeName.StartWith("L")
                               select e.EmployeeName).ToList();
            //Cach2
            var allEmployee2 = employees.Where(e => e.EmployeeName.StartsWith("T"));
            foreach(var employee in allEmployee1)
            {
                Console.WriteLine(employee);
            }
            //OrderBy
            var orderEmployee = from e in employees orderby e.EmployeeName descending select e.EmployeeName;
            foreach(var employee in orderEmployee)
            {
                Console.WriteLine(employee);
            }
            var orderEmployee2 = employees.OrderByDescending(e => e.EmployeeName).ToList();
            foreach (var employee in orderEmployee2)
            {
                Console.WriteLine(employee.EmployeeName);
            }
            var orderEmpQ1 = from emp in employees
                             orderby emp.ProjectId descending, emp.EmployeeName 
                             select emp;
            foreach (var emp in orderEmpQ1)
            {
                Console.WriteLine(emp.EmployeeName +" dang lam project: " +emp.ProjectId);
            }
            var orderEmpQ2= employees.OrderByDescending(e => e.ProjectId).ThenByDescending(e => e.EmployeeName).ToList();
            foreach (var emp in orderEmpQ2)
            {
                Console.WriteLine(emp.EmployeeName + " dang lam project: " + emp.ProjectId);
            }
            //JOIN
            var empQ1 = from e in employees
                        join project in projects
                        on e.ProjectId equals project.ProjectId
                        select new { e.EmployeeName, project.ProjectName };
            var empQ2 = employees.Join(projects, e => e.ProjectId, p => p.ProjectId
            ,(e,p)=> new {e.EmployeeName,p.ProjectName});
            foreach(var data in empQ2)
            {
                Console.WriteLine(data.EmployeeName +" du an: "+data.ProjectName);
            }
            Console.ReadLine();
            */
            RunProgram();
            Console.ReadLine();
        }
        public static void RunProgram()
        {
            Controller controller = new Controller();
            controller.AddData();
            int choice = 0;
            while (choice != 4)
            {
                
                try
                {
                    Menu();
                    choice = int.Parse(Console.ReadLine());
                    switch (choice)
                    {
                        case 1:
                            Console.ForegroundColor = ConsoleColor.Green;
                            controller.DisplayAllEmployee();
                            Console.ResetColor();
                            break;
                        case 2:
                            Console.ForegroundColor = ConsoleColor.Green;
                            controller.DisplayAllProject();
                            Console.ResetColor();
                            break;
                        case 3:
                            controller.SearchProject();
                            break;
                        case 4:
                            Console.WriteLine("Exit");
                            Console.ReadLine();
                            break;
                        default:
                            Console.ForegroundColor = ConsoleColor.Green;
                            Console.WriteLine("Sai cu phap, nhap lai");
                            Console.ResetColor();
                            RunProgram();
                            break;
                    }

                }
                catch (FormatException)
                {
                    Console.WriteLine("Sai cu phap, nhap lai!");
                    RunProgram();
                }
            }
        }
        public static void Menu()
        {
            Console.WriteLine("==========Menu===============");
            Console.WriteLine("1. Xem Danh Sách nhan vien");
            Console.WriteLine("2. Xem Danh sách du an");
            Console.WriteLine("3. Xem thông tin du an");
            Console.WriteLine("3. Ket thuc");
            Console.WriteLine("Your choice: ");
        }
    }
}
