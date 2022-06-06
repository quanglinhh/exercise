using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex44
    {
        public static void RunCode()
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            int sum = 0;
            for(int i = a; i <= b; i++)
            {
                sum += i;
            }
            Console.WriteLine(sum);
        }
    }
}
