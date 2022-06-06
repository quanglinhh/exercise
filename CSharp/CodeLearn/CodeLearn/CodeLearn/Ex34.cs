using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex34
    {
        public static void RunCode()
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            if(a >= b)
            {
                Console.WriteLine("a is greater than or equal to b");
            }
            else
            {
                Console.WriteLine("a is smaller than b");
            }
        }
    }
}
