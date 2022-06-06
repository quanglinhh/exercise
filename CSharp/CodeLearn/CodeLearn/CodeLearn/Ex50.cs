using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex50
    {
        public static void RunCode()
        {
            int n = int.Parse(Console.ReadLine());
            while (n <= 100)
            {
                if( n % 2 == 0)
                {
                    Console.Write(n+" ");
                   
                }
                n++;
            }
        }
    }
}
