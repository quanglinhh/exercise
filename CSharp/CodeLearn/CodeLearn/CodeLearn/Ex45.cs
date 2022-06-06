using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex45
    {
        public static void RunCode()
        {
            int n = int.Parse(Console.ReadLine());
            int sum = 0;
            for(int i = 0; i <= n; i++)
            {
                if(i % 2 != 0)
                {
                    sum += i;
                }
            }
            Console.WriteLine(sum);
        }
    }
}
