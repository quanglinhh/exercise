using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex38
    {
        public static void RunCode()
        {
            int a = int.Parse(Console.ReadLine());
            if (a >= 10 && a <= 100)
            {
                Console.WriteLine("{0} is in the range [10, 100]",a);
            }
            else
            {
                Console.WriteLine("{0} is not in the range [10, 100]",a);
            }
        }
    }
}
