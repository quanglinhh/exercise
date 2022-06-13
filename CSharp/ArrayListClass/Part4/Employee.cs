using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part4
{
    internal class Employee
    {
        private string name;
        private int age;
        private double salary;

        public Employee(string name, int age, double slary)
        {
            this.name = name;
            this.age = age;
            this.salary = slary;
        }

        public string Name { get { return name; } set { this.name = value; } }
        public int Age { get { return age; } set { this.age = value; } }

        public double Salary { get { return salary; } set { this.salary = value; } }

        public override string ToString()
        {
            return $"name: {name}, \tAge: {age},\tSalary: {salary}";
        }

    }
}
