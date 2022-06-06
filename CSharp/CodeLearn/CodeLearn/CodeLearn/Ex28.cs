using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex28
    {
        public static void RunCode()
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            int c;
            c = b;
            b = a;
            a = c;
            Console.WriteLine("after swapping, a = " + a + ", b = " + b);

        }
    }
}
