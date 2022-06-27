using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab7
{
    internal class Employee
    {
        public int EmployeeId { get; set; }
        public  string EmployeeName { get; set; }
        public int ProjectId { get; set; }

        public Employee(int employeeId, string employeeName, int projectId)
        {
            EmployeeId = employeeId;
            EmployeeName = employeeName;
            ProjectId = projectId;
        }
        public override string ToString()
        {
            return $"EmployeeId: {EmployeeId}, EmployeeName: {EmployeeName}, ProjectId: {ProjectId}";
        }

    }
}
