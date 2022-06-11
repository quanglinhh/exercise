using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part3_ex2
{
    internal class Person
    {
        private string name;
        private int salary;
        private int bonus;
        public string Name { get; set; }
        public int Salary { get; set; }
        public int Bonus { get; set; }
        public Person()
        {

        }

        public Person(string name, int salary, int bonus)
        {
            Name = name;
            Salary = salary;
            Bonus = bonus;
           
        }

        public virtual void setSalary()
        {
            Console.Write($"Enter the Salary of {name}: ");

        }
        public virtual void setBonus()
        {
            Console.Write("Enter the Bonus of {0}: ");
        }
    }
}
