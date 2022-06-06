using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex33
    {
        public static void RunCode()
        {
            int n = int.Parse(Console.ReadLine());
            if (n > 0)
            {
                Console.WriteLine("n is a positive number");
            }
            else if( n < 0)
            {
                Console.WriteLine("n is a negative number");
            }
            else
            {
                Console.WriteLine("n is equal to 0");
            }
        }
    }
}
