using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part4_1
{
    internal class Program
    {
        private static int GreaterCount(List<double> list, double min)
        {
          
            //TODO:
            return list.Where(x => x >= min).Count();
        }

        static void Main(string[] args)
        {
            List<double> list = new List<double>();
            list.Add(35);
            list.Add(20);
            list.Add(25);
            list.Add(40);
            GreaterCount(list, 20);
            Console.WriteLine(GreaterCount(list, 20));
            Console.ReadLine();

        }
    }
}
