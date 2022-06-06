using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CodeLearn
{
    internal class Ex40
    {
        public static void RunCode()
        {
            int a = int.Parse(Console.ReadLine());
            int b = int.Parse(Console.ReadLine());
            int c = int.Parse(Console.ReadLine());
            if(a <= b)
            {
                if(b <= c)
                {
                    Console.WriteLine("increasing");
                }
                else
                {
                    Console.WriteLine("neither increasing nor decreasing order");
                }
            }
            else
            {
                if( b >= c)
                {
                    Console.WriteLine("decreasing");
                }
                else
                {
                    Console.WriteLine("neither increasing nor decreasing order");
                }
            }
        }
    }
}
