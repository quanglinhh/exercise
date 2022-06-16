using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Part1_3
{
    internal class Program
    {
        static void Main(string[] args)
        {
            string a = "a";
            string b = "b";
            Swap<String>(ref a, ref b);
            Console.WriteLine(a +" "+b);
            Console.ReadLine();
        }
        static void Swap<T>(ref T lhs, ref T rhs)
        {
            T temp = lhs;
            lhs = rhs;
            rhs = temp;
        }


    }
}
