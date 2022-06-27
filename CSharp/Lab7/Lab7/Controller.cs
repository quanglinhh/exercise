using System;
using System.Collections;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7
{
    internal class Controller
    {
        List<Employee> employees = new List<Employee>();
        List<Project> projects = new List<Project>();
        public void AddData()
        {          
            string employeeQuery = $"SELECT * FROM employee";
            string projectQuery = $"SELECT * FROM project";
            //Connect to database
            DbConnection connectionDB = new DbConnection();
            SqlConnection connection = connectionDB.GetConnection();
            //
            SqlCommand employeeCommand = new SqlCommand(employeeQuery,connection);
            SqlCommand projectCommand = new SqlCommand(projectQuery,connection);
            connection.Open();
            
            SqlDataReader employeeReader = employeeCommand.ExecuteReader();
            while (employeeReader.Read())
            {
                Employee employee = new Employee(Convert.ToInt32(employeeReader[0]), Convert.ToString(employeeReader[1]), Convert.ToInt32(employeeReader[2]));
                employees.Add(employee);
            }                              
            connection.Close();
            connection.Open();
            SqlDataReader projectReader = projectCommand.ExecuteReader();
            while (projectReader.Read())
            {
                Project projectData = new Project(Convert.ToInt32(projectReader[0]), Convert.ToString(projectReader[1]));
                projects.Add(projectData);
            }
            connection.Close();
        }
        public  void DisplayAllProject()
        {
            foreach(Project project in projects)
            {
                Console.WriteLine(project);
            }
        }
        public void DisplayAllEmployee()
        {
            foreach (Employee emp in employees)
            {
                Console.WriteLine(emp);
            }
        }
        public bool CheckContraint(string name, string role)
        {
            if (string.Equals(role, "project"))
            {
                foreach (Project project in projects)
                {
                    if (project.ProjectName.Equals(name))
                    {
                        return true;
                    }
                }
            }
            return false;
        }
        public void SearchProject()
        {
            Console.Write("Nhap ten project: ");
            string name = Console.ReadLine();
            
            if(CheckContraint(name, "project"))
            {
                var data = employees.Join(projects, e => e.ProjectId, p => p.ProjectId
            , (e, p) => new { e.EmployeeName, p.ProjectName });
                List<string> empName = new List<string>();
                foreach (var d in data)
                {
                    if (d.ProjectName == name)
                    {
                        empName.Add(d.EmployeeName);
                    }
                }
                Console.ForegroundColor = ConsoleColor.Green;
                Console.Write($"Cac nhan vien phu trach project {name} la: ");
                for (int i = 0; i < empName.Count - 1; i++)
                {
                    Console.Write(empName[i] + ", ");

                }
                Console.WriteLine(empName[empName.Count - 1] + ".");
                Console.WriteLine("\t");
                Console.ResetColor();
            }
            else
            {
                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("Project not found!");
                Console.ResetColor();
                Program.RunProgram();
            }
           

        }
    }
}
