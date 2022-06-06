using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex32
    {
        public static void RunCode()
        {
            int n = int.Parse(Console.ReadLine());
            if(n % 2 == 0)
            {
                Console.WriteLine("n is an even number");
            }
            else
            {
                Console.WriteLine("n is an odd number");
            }
        }

    }
}
