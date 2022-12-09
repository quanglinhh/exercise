using System;
using System.Collections.Generic;

#nullable disable

namespace ShoppingMobile1.Models
{
    public partial class Department
    {
        public Department()
        {
            Employees = new HashSet<Employee>();
        }

        public int DeptId { get; set; }
        public string DepartmentName { get; set; }

        public virtual ICollection<Employee> Employees { get; set; }
    }
}
