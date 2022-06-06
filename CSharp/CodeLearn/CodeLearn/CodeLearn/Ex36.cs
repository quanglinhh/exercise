using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex36
    {
        public static void RunCode()
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            if(a != 0 && b != 0)
            {
                Console.WriteLine("a is not equal to 0 and b is not equal to 0");
            }
            else
            {
                Console.WriteLine("a is equal to 0 or b is equal to 0");
            }
        }
    }
}
