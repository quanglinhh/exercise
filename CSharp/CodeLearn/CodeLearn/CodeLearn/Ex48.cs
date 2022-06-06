using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex48
    {
        public static void RunCode()
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 1; i <= n; i++)
            {
                if(n % i == 0)
                {
                    Console.Write(i+" ");
                }
            }
        }
    }
}
