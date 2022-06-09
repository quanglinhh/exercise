using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part4_ex2
{
    internal class Program
    {
        static void Main(string[] args)
        {
            Employee employee = new Employee("Linh", "Dao", "Ninh Binh", 100, 99999.99999);
            Console.WriteLine(employee);
            Console.ReadLine();
        }
    }
}
