using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex52
    {
        public static void RunCode()
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            int result = 1;
            int i = 0;
            while(i < b)
            {
                result *= a;
                i++;
            }
            Console.WriteLine(result);
        }
    }
}
