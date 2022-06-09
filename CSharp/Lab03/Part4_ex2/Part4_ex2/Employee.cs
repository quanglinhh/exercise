using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part4_ex2
{
    internal class Employee
    {
        protected string firstName;
        protected string lastName;
        protected string address;
        protected long sin;
        protected double salary;

        public Employee(string firstName, string lastName, string address, long sin, double salary)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.address = address;
            this.sin = sin;
            this.salary = salary;
        }
        public override string ToString()
        {
            return "Name: "+firstName+" "+lastName+"\nAddress: "+address+"\nSin: "+sin+"\nSalary: "+salary;
        }
    }
}
